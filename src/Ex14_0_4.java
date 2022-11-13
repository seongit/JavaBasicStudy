import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex14_0_4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> intStream = list.stream(); // list를 Stream으로부터 생성
        intStream.forEach(System.out::print); // forEach() 최종연산

        // stream은 일회용. stream을 재생성 해야 됨
        // list로부터 stream을 생성
        intStream = list.stream();
        intStream.forEach(System.out::print);

    }
}
