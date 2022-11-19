import java.util.*;
import java.util.stream.Stream;

public class Ex14_7 {

    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
                new String[] {"abc","def","jkl"},
                new String[] {"ABC","GHI","JKL"}
        );

        // Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm
                .map(String::toLowerCase) // 스트림의 요소를 모두 소문자로 변경
                .distinct() // 중복제거
                .sorted() // 정렬
                .forEach(System.out::println);
        System.out.println();


        String [] lineArr = {
                "Believe of not It is ture",
                "Do  or  do  not  There  is  no  try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // line을 split하면 String []이 나온다. String을 문자열 배열로 바꾸는데,이걸 map으로 바꾸면 Stream의 Stream이 된다.
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }

}
