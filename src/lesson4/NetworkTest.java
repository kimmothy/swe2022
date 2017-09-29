package lesson4;

import lesson4.network.Network;

public class NetworkTest {
    static public void main(String[] arg){
        Network net1 = new Network();
        //Network.Member member1 =  new Network.Member(name 'fred');
        Network.Member fred = net1.enroll("fred");
    }
}
