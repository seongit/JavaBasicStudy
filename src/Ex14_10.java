import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Student14_10{

    String name;
    boolean isFeMale; // 성별
    int hak; // 학년
    int ban; // 반
    int score;

    public Student14_10(String name, boolean isFeMale, int hak, int ban, int score) {
        this.name = name;
        this.isFeMale = isFeMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isFeMale() {
        return isFeMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%d학년,%d반,%3d점]", name, isFeMale ? "여" : "남", hak, ban, score);
    }

  enum Level {HIGH,MID,LOW}

}

public class Ex14_10 {
    public static void main(String[] args) {
        Student14_10 [] stuArr = {
                new Student14_10("나자바",true,1,1,300),
                new Student14_10("김지미", false,1,1,250),
                new Student14_10("김자바",true,1,1,200),
                new Student14_10("이지미",false,1,2,150),
                new Student14_10("남자바",true,1,2,100),
                new Student14_10("안지미",false,1,2,50),
                new Student14_10("황지미",false,1,3,100),
                new Student14_10("강지미",false,1,3,150),
                new Student14_10("이자바",true,1,3,200),
                new Student14_10("나자바",true,2,1,300),
                new Student14_10("김지미", false,2,1,300),
                new Student14_10("김자바",true,2,1,250),
                new Student14_10("이지미",false,2,2,200),
                new Student14_10("남자바",true,2,2,150),
                new Student14_10("안지미",false,2,2,100),
                new Student14_10("황지미",false,2,3,150),
                new Student14_10("강지미",false,2,3,20),
                new Student14_10("이자바",true,2,3,300),
        };

        System.out.printf("%n1. 단순분할(성별로분할)%n");
        Map<Boolean, List<Student14_10>> stuBySex = Stream.of(stuArr).collect(partitioningBy(Student14_10::isFeMale));

        List<Student14_10> femaleStudent = stuBySex.get(true);
        List<Student14_10> maleStudent = stuBySex.get(false);

        for(Student14_10 s:femaleStudent) System.out.println(s);
        for(Student14_10 s:maleStudent) System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");

        Map<Boolean,Long> stuNumBySex = Stream.of(stuArr).collect(partitioningBy(Student14_10::isFeMale,counting()));

        System.out.println("여학생수 : " + stuNumBySex.get(true));
        System.out.println("남학생수 : " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별1등)%n");

        Map<Boolean, Optional<Student14_10>> topScoreBySex = Stream.of(stuArr).collect(partitioningBy(Student14_10::isFeMale,maxBy(Comparator.comparingInt(Student14_10::getScore))));

        System.out.println("여학생1등 :" + topScoreBySex.get(true));
        System.out.println("남학생1등: " + topScoreBySex.get(false));

        Map<Boolean,Student14_10> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student14_10::isFeMale
                                    ,collectingAndThen(maxBy(Comparator.comparingInt(Student14_10::getScore)),Optional::get)));

        System.out.println("여학생1등 :" + topScoreBySex2.get(true));
        System.out.println("남학생1등: " + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean,Map<Boolean,List<Student14_10>>> failedStuBySex = Stream.of(stuArr).collect(
                partitioningBy(Student14_10::isFeMale,partitioningBy(s->s.getScore() <= 100)));

        List<Student14_10> failedFemaleStu = failedStuBySex.get(true).get(true);
        List<Student14_10> failedmaleStu = failedStuBySex.get(false).get(true);

        for(Student14_10 s : failedFemaleStu) System.out.println(s);
        for(Student14_10 s : failedmaleStu) System.out.println(s);

    }
}
