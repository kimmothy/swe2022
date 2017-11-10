package Lesson8;

class base {
    int baseValue;

    public base(int baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public String toString() {
        return "base:" + this.hashCode() + ":value" + this.baseValue;

    }

    @Override//일반적인 것부터 배제한다 -- 쉴드 패턴
    public boolean equals(Object o) {
        if(o == null) return false;
        if (!(o instanceof base)) return false;
        if(o.hashCode() == this.hashCode()) return true;
        return this.baseValue == ((base)o).baseValue;

    }

    @Override
    protected base clone() throws CloneNotSupportedException {
        return new base(this.baseValue);
    }
}
