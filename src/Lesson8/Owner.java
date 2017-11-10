package Lesson8;

class Owner {
    private int ownerValue;
    private base ownerBase;

    Owner(int onwerValue, base ownerBase) {
        this.ownerValue = onwerValue;
        this.ownerBase = ownerBase;
    }

    @Override
    protected Owner clone() throws CloneNotSupportedException {
        // 얕은 복사
        Owner result = new Owner(this.ownerValue, this.ownerBase);
        //깊은 복사
        result = new Owner(this.ownerValue, this.ownerBase.clone());
        return result;
    }
    public base getBase(){
        return ownerBase;
    }
}
