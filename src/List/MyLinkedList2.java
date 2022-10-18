package List;

import org.w3c.dom.Node;

import java.util.Arrays;

//6주차
public class MyLinkedList2 {
    NodeDL head, tail;
    int size;

    public MyLinkedList2(){
        head=null;
        tail=null;
        size=0;
    }
    public int indexOf(MyData data){
        NodeDL temp = head;
        for(int i=0; i<size; i++){
            if(temp.data.equals(data))
                return i;
            temp=temp.right;
        }
        return -1;
    }
    public MyData get(int index){
        if(checkIndexValidation(index)) {
            NodeDL temp = head;
            for(int i=0; i<index; i++){
                temp=temp.right;
            }
            return temp.data;
        }
        else
            return null;
    }
    public void set(int index, MyData data){
        if(checkIndexValidation(index)) {
            NodeDL temp = head;
            for(int i=0; i<index; i++){
                temp=temp.right;
            }
        }
    }
    public int sizeOf(){
        return size;
    }
    public void sort(){
        MyLinkedList2 tempList = new MyLinkedList2();//자기 자신에 해당하는 인스턴스 tempList 하나 만들기
        NodeDL temp = head;
        while (temp!=null){
            tempList.addInOrder(temp.data);//this에 해당하는 것들을 temp가 0이 될 때까지(전부다) tempList에 순서를 유지하면서 add하겠다
            //tempList라는 새로운 리스트가 생김
            temp=temp.right;
        }
        this.head=tempList.head;//this.head가 tempList.head 값을 가지고
        this.tail=tempList.tail;//this.tail이 tempList.tail 값을 가지고
        //그 결과 this에 해당되는 리스트는 tempList로 바꿔치기 됨
    }

    private void addInOrder(MyData data) {//순서를 유지하는 add 메소드
        if(head==null || data.compareTo(head.data)>0)//아무것도 없거나 넣을 데이터가 head의 데이터보다 크면
            addFirst(data);
        else{
            NodeDL newNode = new NodeDL(data); //새 노드 만들고
            NodeDL temp = head;
            while(temp!=null && temp.data.compareTo(data)>0){ //temp(head)가 널이 아니고 넣을 데이터보다 크다면
                temp=temp.right;//하나씩 뒤로 밀어줘야 함
            }
            //여기서 빠져나왔다는 것은 두 경우 중 하나
            if(temp!=null){//맨 끝이 아니면, 즉 중간에 넣는 거라면
                temp.left.right=newNode;
                newNode.left=temp.left;
                temp.left=newNode;
                newNode.right=temp;
            }
            else{
                newNode.left=tail;
                tail.right=newNode;
                tail=newNode;
            }
        }
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
    public void add(MyData data){
        addLast(data);
    }

    public void addLast(MyData data) {//맨 뒤에 저장
        NodeDL newNode = new NodeDL(data);  //새노드 만들기
        //맨 뒤에 넣을 것이니까 tail에 넣을건데
        if(tail==null){//아무것도 없다는 말 = 그냥 맨 처음으로 값을 넣어준다는 의미
            //tail과 head 모두 newNode를 가리키게 됨
            tail=newNode;
            head=newNode;
        }
        else{
            newNode.left=tail;  //newNode의 left는 현재의 마지막 것인 tail을 가리키고
            tail.right=newNode; //현재 마지막 것인 tail의 right가 newNode를 가리키면 됨
            tail=newNode; //그리고 tail이 newNode를 가리키면 됨
        }
        size++;
    }
    public void addFirst(MyData data) {//맨 앞에 저장
        NodeDL newNode = new NodeDL(data);  //새노드 만들기
        //맨 앞에 넣을 것이니까 head에 넣을건데
        if(head==null){//아무것도 없다는 말 = 그냥 맨 처음으로 값을 넣어준다는 의미
            //tail과 head 모두 newNode를 가리키게 됨
            tail=newNode;
            head=newNode;
        }
        else{
            //newNode.left는 newNode가 맨 앞이니까 아무것도 안가리킴. 따라서 따로 적어줄 필요 없음
            newNode.right=head;  //newNode의 right는 현재의 맨 처음 것인 head를 가리키고
            head.left=newNode; //현재 맨 앞의 것인 head의 left가 newNode를 가리키면 됨
            head=newNode; //그리고 head가 newNode를 가리키면 됨
        }
        size++;
    }

    public void add(int index, MyData data){    //index<=size
        if(checkIndexValidation(index)){//checkIndexValidation의 경우 index와 size가 같은 경우는 배제함 따라서 그 경우도 고려해줘야 함
            if(index==0)//맨 앞이면
                addFirst(data);
            else{
                NodeDL temp = head; //temp에 head를 주고
                for(int i=0; i<index; i++)
                    temp=temp.right;  //찾아가기
                NodeDL newNode = new NodeDL(data);  //넣어줄 데이터를 담은 새노드 생성
                //newNode를 temp(원하는 인덱스의 노드) 앞에 넣는거니까
                newNode.right=temp; //새노드의 오른쪽이 temp를 가리키게
                newNode.left=temp.left;//새노드의 왼쪽이 원래 temp의 왼쪽 노드를 가리키게
                temp.left.right=newNode;//temp의 왼쪽 노드의 오른쪽이 newNode를 가리키게
                temp.left=newNode;//temp의 왼쪽노드가 newNode가 되게
                size++;
            }
        } else if (index==size)
            addLast(data);
    }

    public MyData remove(int index){//index 주면 그 index data값 지우고 지운 data 리턴
        if(checkIndexValidation(index)){
            NodeDL temp = head;
            for(int i=0; i<index; i++)
                temp=temp.right;
            MyData ret =temp.data;  //temp의 data(주어진 index 노드의 data)를 ret에 저장
            removeANode(temp);
            return ret; //지운 노드의 데이터 리턴
        }
        else
            return null;
    }

    private void removeANode(NodeDL temp) {
        if(head==temp){
            if (tail==temp){ //head와 tail이 가리키는 노드가 모두 지울 노드라면 지울 노드 하나만 있는 경우
                //head와 tail 모두 가리킬 것이 없어짐
                head=null;
                tail=null;
            }
            else{//맨 앞의 노드를 지우는 경우
                head=head.right;//원래 head의 오른쪽 노드를 head가 가리키게 됨
                head.left=null;//head의 왼쪽 노드는 존재x
            }
        }
        else{
            if (tail==temp){ //맨 뒤의 노드를 지우는 경우
                tail=tail.left;//원래 tail의 왼쪽 노드가 tail이 됨
                tail.right=null;
            }
            else{   //그냥 중간에 있는 노드를 지우는 경우
                temp.right.left = temp.left;//지울 노드의 오른쪽 노드의 왼쪽 노드는 지울 노드의 왼쪽 노드가 됨
                temp.left.right=temp.right;//지울 노드의 왼쪽 노드의 오른쪽 노드는 지울 노드의 오른쪽 노드가 됨
            }
        }
        size--;
    }

    public boolean remove(MyData data) {
        NodeDL temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                removeANode(temp);
                return true;
            } else
                temp = temp.right;  //오른쪽 전진진        }
        }
        return false;
    }

    public String toString(){
        String ret="";
        NodeDL temp = head;
        while(temp!=null){
            ret = ret+temp.data.toString()+" ";
            temp=temp.right;
        }
        return ret;
    }
}
