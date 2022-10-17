package List;

//5주차
public class MyLLMain {
    public static void main(String[] args){
        //MyLinkedList0 타입의 변수를 만들어서 쓰겠다는 것
        //MyLinkedList0 me = new MyLinkedList0();

        MyLinkedList1 me = new MyLinkedList1();


        for(int i=0; i<20; i++){
            me.add((int) (100*Math.random()));  //0~100까지 랜덤으로 정수 넣어주기
        }
        //확인 용
        System.out.println(me.toString());
        me.addFirst(49);
        //확인 용
        System.out.println(me.toString());

        me.addLast(35);
        //확인 용
        System.out.println(me.toString());

        me.remove(49);
        //확인 용
        System.out.println(me.toString());

        me.remove(35);
        //확인 용
        System.out.println(me.toString());
    }
}
