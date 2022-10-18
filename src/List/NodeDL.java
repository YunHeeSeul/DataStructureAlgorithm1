package List;
//6주차
public class NodeDL {
    MyData data;
    NodeDL left, right;

    public NodeDL() {//아무것도 없어도 하나 만들 수 있도록 해줌
    }

    public NodeDL(MyData d){//데이터 하나를 주면 하나 만들어 줌
        data=d;
        left=null;
        right=null;
    }

    public NodeDL(String s, int v){//이렇게 직접 만들어서 넣어줄 수도 있음
        data = new MyData(s,v);
    }

    public String toString(){
        return data.toString();
    }
}
