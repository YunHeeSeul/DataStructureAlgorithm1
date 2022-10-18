package List;

import java.util.Arrays;

//6주차
public class MyArrayList2 {
    int initCapacity = 10;
    int capacity;   //계속 늘어나는, 변화하는 것을 반영할 수 있는
    MyData[] myArray;
    int size;

    public MyArrayList2(){
        capacity = initCapacity;
        myArray = new MyData[capacity];
        size=0;
    }

    public int indexOf(MyData data){
        for(int i=0; i<size; i++){
            //if(myArray[i]==data)    //객체의 해쉬값이 비교되는 것임
            if(myArray[i].equals(data)) //이렇게 해주면 됨
                return i;
        }
        return -1;
    }
    public MyData get(int index){
        if(checkIndexValidation(index))
            return myArray[index];
        else
            return null;
    }

    private boolean checkIndexValidation(int index) {//index가 올바른 인덱스인지 확인하는
        /*
        if(index>=0 && index<size)
            return true;
        else
            return false;
         */
        return (index>=0 && index<size)?true:false; //이게 맞으면 true, 아니면 false. 위의 코드와 같은 의미
    }

    public void set(int index, MyData data){
        if(checkIndexValidation(index))
            myArray[index]=data;
    }
    public void add(MyData data){//맨 뒤에 저장
        if(size==capacity)//사이즈가 현재 용량과 같다면
            grow(capacity);//현재 용량만큼 더 늘려라
        //위와 같이 늘어났거나. 사이즈가 현재 용량보다 작으면
        myArray[size]=data;
        size++;
    }

    private void grow(int increment) {  //증가량을 받음.(현재 용량만큼 증량할 것)
        /*
        capacity=capacity+increment;
        MyData[] newArray = new MyData[capacity];
        for(int i=0; i<size; i++){
            newArray[i]=myArray[i];
        }
        myArray=newArray;
         */
        //위의 코드를 압축시킨 것
        capacity=capacity+increment;
        myArray= Arrays.copyOf(myArray,capacity);
    }

    public void add(int index, MyData data){
        if(checkIndexValidation(index)){
            if(size==capacity)//사이즈 체크
                grow(capacity);
            makeSlot(index);//특정 index에 넣으려고 하면 공간을 만들어야 함
            myArray[index]=data;
            size++;
        }
    }

    private void makeSlot(int index) {
        for (int i=size-1; i>index; i--)    //한칸씩 뒤로 밀어주기
            myArray[i+1]=myArray[i];
    }

    public MyData remove(int index){//index 주면 그 index data값 지우고 지운 data 리턴
        MyData ret = null;
        if(checkIndexValidation(index)){
            ret=myArray[index]; //해당 index의 data 값을 ret에 넣고
            removeSlot(index);  //앞으로 하나씩 당겨주기
            size--;
            return ret;
        }
        else 
            return null;
    }

    private void removeSlot(int index) {
        //앞으로 하나씩 당겨주기
        for(int i=index; i<size-1; i++){
            myArray[i]=myArray[i+1];
        }
    }

    public boolean remove(MyData data){
        int index = indexOf(data);
        return  (remove(index)==null)?false:true;
    }
    public int sizeOf(){
        return size;
    }
    public void sort(){
        //Selection Sort from biggest to smaller
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                //j가 i+1이니까 우선은 인덱스 i 값이 더 크다고 가정하고(큰것부터 작은 순으로 정렬하는 거니까)
                if (myArray[i].compareTo(myArray[j])<0){//만약 인덱스 i보다 j의 값이 더 크면 둘을 서로 바꿔주기
                    swap(i,j);
                }
            }
        }
    }

    private void swap(int i, int j) {
        MyData temp = myArray[i];   //인덱스i의 값을 temp에 넣어놓고
        myArray[i]=myArray[j];  //인덱스 j의 값을 인덱스 i의 값에 넣어주고
        myArray[j]=temp;    //temp에 있던 원래 인덱스 i의 값을 인덱스 j에 넣어줌
        //이로써 서로 값을 바꾸게 됨
    }

    public String toString(){
        String ret="";
        for(int i=0; i<size; i++)
            ret=ret+myArray[i].toString()+" ";
        return ret;
    }
}
