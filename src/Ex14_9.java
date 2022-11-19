import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_9 {
    public static void main(String[] args) {

        String [] strArr = {
                "Inheritance","Java","Lambda","stream",
                "OptionalDouble","IntStream","count","sum"
        };

        // Stream.of(strArr).forEach(System.out::println); //스트림을 기본적으로 직렬스트림이다.
        Stream.of(strArr).parallel().forEachOrdered(System.out::println); // 병렬로 처리하되, 순서를 유지하고 싶을 때

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0); // noneMatch : 모든 요소가 불일치하면 참
        System.out.println("noEmptyStr="+noEmptyStr);

        //Optional<String> sWord = Stream.of(strArr).parallel().filter(s->s.charAt(0)=='s').findFirst();
        Optional<String> sWord = Stream.of(strArr).filter(s->s.charAt(0)=='s').findFirst();
        System.out.println("sWord="+sWord.get());

        // Stream<String>을 Stream<Integer>으로 변환
        // Stream<Integer>intStream1 = Stream.of(strArr).map(String::length);

        // Stream<String>을 IntStream으로 변환 (기본형 스트림)
        // IntStream와 Stream<Integer>은 같지만, 성능 때문에 IntStream을 사용함(= 각 요소를 기본형으로 다룸)
        // Stream<Integer>는 각 요소를 객체로 다룸
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0,(a,b) -> a + 1);
        int sum = intStream2.reduce(0,(a,b)->a+b);

        //스트림이 비어있는 경우 : OptionalInt max = IntStream.empty().reduce(Integer::max);
        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
        //System.out.println("max=" + max.orElse(0));
        System.out.println("max=" + max.orElseGet(()->0));
        System.out.println("min=" + min.getAsInt());



    }
}
