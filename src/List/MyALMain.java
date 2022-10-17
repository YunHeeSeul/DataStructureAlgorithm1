package List;
//4주차
public class MyALMain {
    public static void main(String[] args){
        //MyArrayList1 타입의 변수를 만드는 것.
        //이렇게 만들어서 쓰겠다는 것
        MyArrayList1 me = new MyArrayList1();

        //초기 capacity를 10으로 설정해줬지만 그 이상이 들어와도 돌아가도록 코드를 만들어줘야 함.
        for(int i=0; i<20; i++){
            me.add((int) (100*Math.random()));  //0~100까지 랜덤으로 정수 넣어주기
        }
        //확인 용
        System.out.println(me.toString());
    }
}
