public class Ex7_14 {
    private int outerIv = 0;
    static  int outerCv = 0;

    class InstanceInner{
        int iiv = outerIv; // 외부 클래스의 privat 멤버 접근
        int iiv2 = outerCv;
    }

    static  class StaticInner{
        // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        //int siv = outerIv;
        static int scv = outerCv;
    }
    void myMethod(){
        int lv = 0;
        final int LV = 0;

        class LocalInner{
            int liv = outerIv;
            int liv2 = outerCv;
            // 외부 클래스의 지역변수는 fianl이 붙은 변수(상수)만 접근 가능하다.
             int ilv3 = lv; // JDK 1.8부터 에러 아님
             int liv4 = LV;
        }
    }
}
