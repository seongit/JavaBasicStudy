import java.util.function.Function;

public class Ex14_0_2 {
    public static void main(String[] args) {
        // 방법 1.
        // Function<String,Integer> f = (String s) -> Integer.parseInt(s);

        // 방법 2. 메서드 참조
        // Function<String,Integer> f = 클래스이름::메서드이름;
        Function<String,Integer> f = Integer::parseInt;
        System.out.println(f.apply("100")+200);
    }
}
