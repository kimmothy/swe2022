package lesson4.network;

import java.util.ArrayList;

public class Network {
    public class Member{
        private String name;
        private ArrayList<Member> friends;

        public Member(String name){
            this.name = name;
            this.friends = new ArrayList<>();
        }

        public void leave(){
            members.remove(this);//outer가 생략된 상태

        }
    }
    //Netwokrk----------------------------------------------
    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name){
        //this == new Network() == net1 == newMember.outer
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }
    public void remove(Member member){
        members.remove(member);
    }
}
