package Lesson3;


public class base0 {
    static public void main(String[] arg){
        Constructor c = new Constructor();
        System.out.println(c.getName());
        Constructor c1 = new Constructor("sdf0");
        Constructor c2 = new Constructor("","");


        Noconst no = new Noconst();

        System.out.println(no.getFirstName(c2));

        System.out.println(Constructor.plus(3,4));
        System.out.println(c2.plus(3,4));//가능하지만 불필요


    }
}
