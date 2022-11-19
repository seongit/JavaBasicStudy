import java.io.File;
import java.util.stream.Stream;

public class Ex14_6 {

    public static void main(String[] args) {

        File[] fileArr = {
                new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
        };

        Stream<File> fileStream = Stream.of(fileArr);

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream <String> filenameStream = fileStream.map((f)->f.getName()); // 람다식
        //Stream <String> filenameStream2 = fileStream.map(File::getName); // 메소드 참조

        filenameStream.forEach(System.out::println); // 모든 파일의 이름을 출력

        fileStream = Stream.of(fileArr); // 스트림을 다시 생성
        // 스트림을 재생성 하는 이유는? forEach가 최종연산이기 때문에 스트림이 닫힘

        fileStream.map(File::getName) // Stream<File> -> Stream<String>
                .filter( s -> s.indexOf('.')!=-1) // 확장자가 없는 것은 제외
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .peek(s-> System.out.printf("extension=%s%n",s))
                .map(String::toUpperCase) // 모두 대문자로 변환
                .distinct() // 중복제거
                .forEach(System.out::print); // JAVABAKTXT

        System.out.println();


    }

}
