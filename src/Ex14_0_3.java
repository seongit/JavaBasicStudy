import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex14_0_3 {
    public static void main(String[] args) {

        // Supplier는 입력 X, 출력 O
        //Supplier<MyClass> s = () -> new MyClass();

        // Function<Integer,MyClass> f = (i) -> new MyClass(i);
        Function<Integer,MyClass> f = MyClass::new;

        MyClass mc  = f.apply(100);
        System.out.println(mc.iv);
        System.out.println(f.apply(200).iv);

        Function <Integer,int[]> f2 = (i) -> new int[i];
        // 메서드 참조
        Function <Integer,int[]> f3 = int[]::new;
        System.out.println(f2.apply(100).length);
    }
}

class MyClass {
    int iv;
    MyClass(int iv){
        this.iv = iv;
    }
}
