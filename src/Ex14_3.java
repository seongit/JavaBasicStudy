import java.util.function.Predicate;

public class Ex14_3 {
    public static void main(String[] args) {
        Predicate<Integer> p =  i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 ==0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150)); // true

        String str1 = new String("abc");
        String str2 = new String("abc") ;

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str2);
        // boolean result = str1.equlas(str2);
        boolean result = Predicate.isEqual(str2).test(str2);
        System.out.println(result);

    }
}
