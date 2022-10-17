package List;
//5주차
public class MyLinkedList1 {
    //제일 먼저 해줄 건 노드를 만드는 것.
    // 데이터가 들어가는 부분과 next(link)를 저장하는 부분을 자바가 제공하는 구조체
    // 즉, 객체로 만들어주는게 편함. 왜냐면 객체 생성을 자바버츄얼머신이 알아서 도와주니까

    //흔히 단위 데이터를 저장하는 것을 노드라고 부름
    private class Node {//얘는 다음 노드를 가리키는 것 링크가 아닌.
        int value;
        //next의 타입이 뭐냐=>int면 노드를 가리킬 수 없음.
        //따라서 타입은 Node이고 노드를 가리키는 애라는 의미
        Node next;

        private Node(int data) {//만약 데이터가 주어진다면 생성자에서 데이터 값을 주고 노드를 아예 새로 하나 만들 수 있음.
            value = data;
            next = null; //클래스 객체들에 대해서 없다는 의미는 null
        }
    }

    //여기선 freePointer는 필요없음. new를 하면 되니까
    //listPointer가 필요. 얘는 노드를 가리켜야 하니까 역시나 타입은 Node
    Node listPointer;
    int size;   //데이터 개수

    public MyLinkedList1() { //생성자
        listPointer = null;
        size = 0;
    }

    public int addLast(int data) {
        Node newNode = new Node(data); //새 노드 생성
        Node temp = listPointer;
        int index=0;
        while(temp.next!=null){
            index++;
            temp=temp.next;
        }
        temp.next=newNode;
        size++;
        return index;
    }

    public int add(int data) {
        return addFirst(data);
    }

    public int addFirst(int data) {
        //얘는 freePointer로부터 가지고 오는게 아니라 newNode를 가져오는 것
        Node newNode = new Node(data);  //=>value에는 data값이 저장되어있고 next는 null인 상태로 된 새로운 노드가 하나 만들어져서 newNode라는 변수가 걔를 가리키게 되는 것
        newNode.next = listPointer;//newNode.next는 원래 맨 앞을 가리키고 있던 애의 위치를 가리키면 됨.
        listPointer = newNode;//listPointer는 newNode가 됨. 즉 리스트의 시작노드가 newNode가 되는 것
        size++; //사이즈가 늘어났으니 늘려줘야 함
        return 0;
    }

    public int remove(int data) {//특정 데이터 값 지우고 그 데이터의 인덱스를 리턴해라
        int index = 0;
        if (listPointer == null)//아무것도 없다면
            return -1;
        if (listPointer.value == data) {//바로 한 번에 찾은 것=>맨 앞의 것을 없앤다는 것
            listPointer = listPointer.next; //이 자체로 하나가 삭제된 것
            return index;
        }
        //remove가 아닌 경우에는 노드가 temp 하나여도 됨
        Node p = listPointer;
        Node q = p.next; //=listPointer.next
        while(q!=null){//=p.next가 null이 아니면 = 따라갈 것이 있으면
            index++;
            if(q.value==data){//찾음
                p.next=q.next;//이 자체로 하나 삭제된 것
                return index;
            }
            else {//찾지 못했으면 하나 전진해야 함
                p=q;
                q=q.next;
            }
        }
        //루프를 다 돌도록 못찾은 경우
        return -1;
        //null도 아니고 첫번쨰 것도 아니면 계속 따라가면서 찾아야 함
        /*
        Node temp = listPointer;
        while (temp.next != null) {//따라가기
            index++;
            temp=temp.next; //다음으로 넘어감
            if(temp.value==data){//찾음
                //ex. p->temp->next 일 때 temp가 삭제되면
                //p->next가 됨. 이경우 p는 본인의 부모(앞 노드)를 모르게 됨
                //이 경우에는 temp 노드 2개를 만듦. p,q
            }
        }
         */
    }
    public String toString() { //있는 것들을 다 나열해줌
        String ret = ""; //빈스트링 하나 만들어 놓고
        Node temp = listPointer;
        while(temp!=null) {
            ret = ret + temp.value+", ";
            temp=temp.next;
        }
        return ret;
    }
}
