package List;
//6주차
public class MyData {
    //2개의 attribute
    //key를 정의한 이유는 key는 서로 구분을 해줘야 하니 달라야 하고, value는 같을 수 있따
    String key; //key값을 String으로 한 이유 : 자바의 실제 키가 해쉬코드, 스트링이니까.
    int value;

    public MyData(){

    }
    //생성자가 여러 개 있을 수 있음. 오버로딩
    public MyData(String s, int v){
        key = s;
        value = v;
    }
    //별도로 같은지 아닌지를 확인해주는 메소드
    public boolean equals(MyData that){
        if(this.key==that.key)
            return true;
        else
            return false;
    }
    //크다 작다를 비교해주는 메소드
    public int compareTo(MyData that){
        //key를 가지고 compare 한다. value를 가지고도 할 수 있음.->ex.key가 사람이고 value가 점수인 경우
        if(this.key.compareTo(that.key)>0)//통상적으로 primitive data 타입을 제외한 것들의 비교는 compareTo를 이용함.
            //this가 크면 양수, 같으면 0, 작으면 음수
            return 1;
        else if (this.key.compareTo(that.key)<0) //this가 작으면
            return -1;
        else
            return 0;
    }

    //오버라이딩 해서 우리가 원하는 형태로 출력될 수 있도록 해줌. 이걸 하지 않으면 그냥 MyData를 출력할 때 해쉬코드가 출력됨
    public String toString(){
        return ""+"("+key+", "+value+") ";
    }
}
