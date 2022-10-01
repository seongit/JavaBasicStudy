public class Ex9_5 {
    public static void main(String[] args) {
        Card2_1 c1 = new Card2_1();
        Card2_1 c2 = new Card2_1("HEART",10);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}

class Card2_1{
    String kind;
    int number;

    Card2_1(){
        this("SPADE",1);
    };
    Card2_1(String kind,int number){
        this.kind = kind;
        this.number = number;
    }

    public String toString(){
        // Card2_1의 인스턴스의 kind와 number를 문자열로 치환한다.
       // 객체는 iv의 집합이므로 객체를 문자열로 변환한다는 것은 iv의 값을 문자열로 변환한다는 것과 같다.
        return "kind : "  + kind + ", number " + number;
    }

}