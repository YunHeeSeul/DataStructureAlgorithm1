package List;

//자바 안에 들어있는 어레이리스트처럼 서비스를 해줄 수 있는 클래스를 하나 정의해주려는 것
//그러면 실제로 데이터를 넣고 빼고 할 수 있는 저장 공간이 필요함
public class MyArrayList1 {

    //초기 capacity를 10으로 설정해줬지만 그 이상이 들어와도 돌아가도록 코드를 만들어줘야 함.
    int initCapacity=10;  //어레이 초기 사이즈
    int[] elementData;
    int size; //실제 데이터 개수
    int currCapacity; //현재 확대된 사이즈

    public MyArrayList1(){  //MyArrayList1 타입의 인스턴스를 만들 때 생성자 만들어 줌
        elementData = new int[initCapacity];
        size=0;
        currCapacity=initCapacity;  //초기엔 currCapacity가 initCapacity와 같음
    }   //이렇게 선언해주면 하나의 어레이 생성 완료

    public String get(int index){   //다른 것들도 사용해야 하니까 public으로
        return null;
    }
    public int search(int data){
        return 0;
    }
    public void add(int data){  //data를 맨 뒤에 집어넣기
        //사이즈 체크하기
        if(size==initCapacity) {//꽉 차 있어서 더는 집어 넣을 수 없는 상태면
            //크기 확대해줘야 함 ==> 기본적인 방법 : 두 배 크기의 array를 만들어서 기존 data를 복사한 뒤 새 array에 데이터 추가
            int[] newArray = new int[currCapacity * 2];
            for (int i = 0; i < size; i++) {//newArray에 기존 어레이의 데이터 복사
                newArray[i]=elementData[i];
            }
            // 전체 클래스에서는 elementData라는 이름을 사용하고 있기 때문에
            // 크기를 확대한 어레이의 이름을 elementData로 바꿔치기 해줌
            elementData = newArray;
            currCapacity=currCapacity*2;  //currCapacity의 크기가 2배로 바뀐 것도 바꿔줌
        }
        else{   //그게 아니라면
            elementData[size]=data;
            size++;
        }
    }
    public void add(int index, int data){   //data를 원하는 index에 집어넣기

    }
    public String remove(int index){    //해당 index의 데이터를 지우고 리턴
        return null;
    }
    public int sizeOf(){    //현재 데이터 개수 리턴
        return size;
    }
    public int arrSize(){   //현재 어레이 공간 사이즈
        return currCapacity;
    }
    public String toString(){   //현재 있는 데이터를 다 써주는 것
        String ret = "";    //빈 string 하나 만들어 줌
        for(int i=0; i<size; i++)
            ret = ret + elementData[i]+"|";
        return ret;
    }

}
