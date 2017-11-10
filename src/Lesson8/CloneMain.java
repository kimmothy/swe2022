package Lesson8;

public class CloneMain {


    static public void main(String[] art){
        base b1 = new base(10);
        Owner o1 = new Owner(10,b1);

        Owner o2 = null;
        try {
            o2 = o1.clone();

        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        base b2 = o1.getBase();
        b2.baseValue = 20;
        System.out.println(o2.getBase().baseValue);

    }
}
