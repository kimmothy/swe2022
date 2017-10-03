package Lesson3;

import java.util.ArrayList;

public class Constructor {
    private String firstName;
    private  String lastName;
    private String seperator;
    private ArrayList<String> friends;
    {
        seperator = " ";
        friends = new ArrayList<>();

    }

    public Constructor(){
        this("john", "doe");

    }
    public Constructor(String fname){
        this(fname, "doe");

    }
    public Constructor(String fname, String lname){
        firstName = fname;
        lastName = lname;

    }
    public String getName(String a){
        return a;
    }
    static public int plus(int a, int b){
        return a + b;
    }

    public String getName(){
        return firstName + " " + lastName;
    }
    public String getFriend(int index){
        return friends.get(index);
    }
    public void setFirsName(String fname){

    }
}
