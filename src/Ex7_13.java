public class Ex7_13 {
    class InstaceInner{}
    static class StaticInner{}
    // 인스턴스멤버 간에는 서로 직접 접근이 가능한다.
    InstaceInner iv = new InstaceInner();
    // static 멤버간에는 서로 직접 접근이 가능하다.
    static StaticInner cv = new StaticInner();

    static void staticMethod(){
        // statce 멤버는 인스턴스 멤버에 직접 접근할 수 없다.
        //InstaceInner obj1 = new InstaceInner();
        StaticInner obj2 = new StaticInner();

        // 굳이 접근하려면 아래와 같이 객체를 생성해야 한다.
        // 인스턴스클래스는 외부 클래스를 먼저 생성해야만 생성할 수 있다.
        Ex7_13 outer = new Ex7_13();
        InstaceInner obj1 = outer.new InstaceInner();
    }

    void instaceMethod(){
        // 인스턴스메서드에서는 인스턴스멤버와 static 멤버 모두 접근 가능하다.
        InstaceInner obj1 = new InstaceInner();
        StaticInner obj2 = new StaticInner();
        // 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
        // LocalInner lv = new LocalInner();
    }
    void myMethod(){
        class LocalInner{}
        LocalInner lv = new LocalInner();
    }
}
