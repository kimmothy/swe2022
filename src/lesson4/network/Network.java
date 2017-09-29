package lesson4.network;

import java.util.ArrayList;

public class Network {
    public class Member{
        private String name;
        private ArrayList<Member> friends;

        Member(String name){
            this.name = name;
            this.friends = new ArrayList<>();
        }
        public void leave(){

        }
    }
    //Netwokrk----------------------------------------------
    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name){
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }
    public void remove(Member member){
        members.remove(member);
    }
}
