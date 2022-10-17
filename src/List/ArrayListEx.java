package List;

import java.util.ArrayList;
//4주차
public class ArrayListEx {
    public static void main(String[] args){
        //array 만들기
        //크기를 미리 지정해줘야만 함.
        // 어레이는 컴파일러에서 미리 확인을 하는데 크기를 지정해주지 않으면 크기를 예상할 수 없어서 컴파일러가 처리를 못해줌
        int[] a = new int[3];

        //array의 크기 미리 지정 단점을 커버해주기 위해 만든 것이 arraylist
        //arraylist는 어쨌든 클래스니까 초기화 할 때 괄호가 붙어야 하는 것
        //array는 primitive를 허용해줬지만 arraylist는 허용해주지 않음
        //따라서 클래스/오브젝트/객체를 사용해야 함
        //클래스여서 연산을 할 때는 메소드를 호출해서 해야함. ex.b.add()
        //+커서를 갖다놓은 후 f3를 누르면 그 클래스에 대한 상세정보 나옴
        ArrayList<Integer> b = new ArrayList<>();
    }
}
