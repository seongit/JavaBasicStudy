import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {
    public static void main(String[] args) {

        Stream <Student2> studentStream = Stream.of(new Student2("이자바",3,300)
                ,new Student2("김자스",1,320)
                ,new Student2("안자바",2,100)
                ,new Student2("박자스",2,150)
                ,new Student2("소자바",1,200)
                ,new Student2("나자바",3,290));

        studentStream.sorted(
                Comparator.comparing(Student2::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        ; // 반별 정렬

    }
}

class Student2 implements Comparable<Student2>{
    String name;
    int ban;
    int totalScore;

    Student2(String name, int ban, int totalScore){
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString(){
        return String.format("[%s,%d,%d]" , name,ban,totalScore);
    }

    String getName(){
        return name;
    }

    int getBan(){
        return ban;
    }

    int getTotalScore(){
        return totalScore;
    }

    @Override
    public int compareTo(Student2 s) {
        // 총점 내림차순을 기본 정렬로 한다.
        return s.totalScore - this.totalScore;
    }
}
