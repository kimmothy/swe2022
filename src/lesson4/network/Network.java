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
            unenroll(this);//outer가 생략된 상태
            //members.remove(this); 이렇게 쓰면 캡슐화를 어긴 상태

        }
        public boolean belongsTo(Network n){
            return Network.this == n;
        }
    }
    //Netwokrk----------------------------------------------
    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name){
        //this == new Network() == net1 == newMember.outer
        Member newMember = this.new Member(name);
        members.add(newMember);
        return newMember;
    }
    public void unenroll(Member member){
        members.remove(member);
    }
}
