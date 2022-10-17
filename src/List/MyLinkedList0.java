package List;

//5주차
public class MyLinkedList0 {
    int capa=30;//MyLinkedList0에서는 필요. 얘도 MyArrayList1처럼 늘려주는 grow() 필요
    int [][] mPool;//memory pool을 2차원 어레이로 만들어야 함
    //인덱스들을 가리킬 포인터 2개가 필요함
    int freePointer;//할당할 수 있는 다음 인덱스를 가리킴. 빈 곳을 가리키는 포인터
    int listPointer;//새로 리스트를 만들면 리스트 포인터가 있음. 리스트의 시작점
    int size=0;//데이터 개수

    public MyLinkedList0(){
        mPool=new int[capa][2];  //mPool 생성. data와 next만 있으면 되니까 열은 2개
        initPool();//initPool
        freePointer=0;//처음엔 다 비어있으니 0번부터 가리킴
        listPointer=-1;//현재 아무것도 할당된 것이 없으니 -1
        size=0;
    }

    private void initPool() {//in
        for(int i=0; i<capa-1; i++)
            mPool[i][1]=i+1;//0이 data, 1이 next. =>mPool의 next에 다음 인덱스를 넣어주는 과정
        mPool[capa-1][1] = -1;//맨마지막꺼는 더이상 가리킬 인덱스가 없으니 인덱스에 존재할 수 없는 수인 -1을 넣어줌
    }

    public int add(int data){  //data를 맨 뒤에 집어넣기
        int index=0;   //리턴해줄 인덱스
        //linkedList에서는 더 이상의 capa가 있다 없다의 기준은 freePointer다.
        if(freePointer==-1) {//이건 이미 맨 마지막까지 소진되어서 더이상 할당할 게 없다는 의미
            System.out.println("Out-Of-Memory");
            return -1;
        }
        else{ //그렇지 않다면
            if(listPointer==-1){//=>비어있는 mPool의 첫번째 것에 add하려는 것
                listPointer=freePointer; //listPointer가 freePointer를 가지고 오고
                freePointer=mPool[freePointer][1];//mPool[freePointer][1]이 새로운 freePointer가 되야 함
                mPool[listPointer][0]=data;
                mPool[listPointer][1]=-1;//얘가 지금 마지막 부분임. 따라서 더이상 다음 것이 없으므로 -1
            }
            else {//비어있지 않다면
                //맨 뒤를 찾아가야 함. 어떻게?=>next를 타고 타고 올라가서
                int temp = listPointer; //temp에 listPointer 저장해놓고
                while(mPool[temp][1]!=-1){//맨 뒤가 아니라면
                    temp=mPool[temp][1];// temp 다음 것을 가리키게 한다는 의ㅣ
                    index++;
                }
                //루프를 빠져나왔다는 것은 현재 temp가 -1, 맨 뒤기 때문이다
                //그러면 여기에 새 노드를 붙이면 됨=>freePointer를 mPool[temp][1]에 넣으라는 의미
                mPool[temp][1]=freePointer; //next에 다음으로 가리킬 새 노드의 인덱스를 넣어주는 것과 같음
                freePointer=mPool[freePointer][1];//freePointer가 다음 걸 가리키게 함
                //지금 temp가 가리키는 것의 link(next)가 freePointer임
                temp=mPool[temp][1];//현재 temp는 새 노드를 가리킨 것.
                mPool[temp][0]=data;
                mPool[temp][1]=-1;//마지막 노드니까
            }
            size++;
            return index;
        }
    }

    public int addFirst(int data){//맨 앞에 데이터를 넣는다면면
        //linkedList에서는 더 이상의 capa가 있다 없다의 기준은 freePointer다.
        if(freePointer==-1) {//이건 이미 맨 마지막까지 소진되어서 더이상 할당할 게 없다는 의미
            System.out.println("Out-Of-Memory");
            return -1;
        }
        else{ //그렇지 않다면
            int temp = listPointer;
            listPointer=freePointer;
            freePointer=mPool[freePointer][1];//mPool[freePointer][1]이 새로운 freePointer가 되야 함
            mPool[listPointer][0]=data;
            mPool[listPointer][1]=temp;
            size++;
            return 0;
            }
        }

    public String toString(){   //현재 있는 데이터를 다 써주는 것
        String ret = "";    //빈 string 하나 만들어 줌
        int temp = listPointer;
        while(temp!=-1){
            ret = ret + mPool[temp][0]+", ";
            temp = mPool[temp][1];
        }
        return ret;
   }
    /*
    private void grow() {   //크기 확대해주는 메소드
        //크기 확대해줘야 함 ==> 기본적인 방법 : 두 배 크기의 array를 만들어서 기존 data를 복사한 뒤 새 array에 데이터 추가
        //크기 확대해주는 메소드가 따로 자바에 있음.=>grow()
        int[][] newPool = new int[capa * 2][2];
        for (int i = 0; i < size; i++) {//newArray에 기존 어레이의 데이터 복사
            for(int j=0; j<2; j++) {
                newPool[i][j] = mPool[i][j];
                size++;
            }
        }
        // 전체 클래스에서는 mPool라는 이름을 사용하고 있기 때문에
        // 크기를 확대한 이름을 mPool로 바꿔치기 해줌
        mPool = newPool;
        capa=capa*2;  //capa의 크기가 2배로 바뀐 것도 바꿔줌
    }
     */
}
