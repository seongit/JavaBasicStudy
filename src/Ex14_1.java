@FunctionalInterface
interface MyFunction{
    void run(); // public abstract void run();
}
public class Ex14_1 {

    static void execute(MyFunction f){
        f.run(); // 매개변수의 타입이 MyFunction인 메서드
    }

    static MyFunction getMyFunction(){
        // 반환 타입이 MyFunction인 메서드
        /**
         * 방법 1
         MyFunction f = () -> System.out.println("f3.run()");
         return f;
         */

        /*
        방법 2
         */
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction의 run()을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            // 익명 클래스로 run()을 구현
            @Override
            public void run() { // public을 반드시 붙여야 함 -> 왜 ? 오버라이딩 생성 규칙 확인할 것 !
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();
        execute(f1);
        execute(() -> System.out.println("run()"));

    }


}
