import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Student14_11{

    String name;
    boolean isFeMale; // 성별
    int hak; // 학년
    int ban; // 반
    int score;

    public Student14_11(String name, boolean isFeMale, int hak, int ban, int score) {
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

public class Ex14_11 {

    public static void main(String[] args) {
        Student14_11[] stuArr = {
                new Student14_11("나자바", true, 1, 1, 300),
                new Student14_11("김지미", false, 1, 1, 250),
                new Student14_11("김자바", true, 1, 1, 200),
                new Student14_11("이지미", false, 1, 2, 150),
                new Student14_11("남자바", true, 1, 2, 100),
                new Student14_11("안지미", false, 1, 2, 50),
                new Student14_11("황지미", false, 1, 3, 100),
                new Student14_11("강지미", false, 1, 3, 150),
                new Student14_11("이자바", true, 1, 3, 200),
                new Student14_11("나자바", true, 2, 1, 300),
                new Student14_11("김지미", false, 2, 1, 300),
                new Student14_11("김자바", true, 2, 1, 250),
                new Student14_11("이지미", false, 2, 2, 200),
                new Student14_11("남자바", true, 2, 2, 150),
                new Student14_11("안지미", false, 2, 2, 100),
                new Student14_11("황지미", false, 2, 3, 150),
                new Student14_11("강지미", false, 2, 3, 20),
                new Student14_11("이자바", true, 2, 3, 300),
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");

        Map<Integer, List<Student14_11>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student14_11::getBan));

        for(List<Student14_11>ban : stuByBan.values()) {
            for(Student14_11 s: ban){
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");

        Map<Student14_11.Level,List<Student14_11>>stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s->{
                    if(s.getScore() >= 200 ) return Student14_11.Level.HIGH;
                    else if(s.getScore() >= 100) return Student14_11.Level.MID;
                    else return Student14_11.Level.LOW;
                }));
        TreeSet<Student14_11.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(Student14_11.Level key : keySet){
            System.out.println("["+key+"]");
            for(Student14_11 s : stuByLevel.get(key)){
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("3. 단순그룹화 + 통계(성적별 학생수)%n");

        Map<Student14_11.Level,Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s->{
                    if(s.getScore() >= 200) return Student14_11.Level.HIGH;
                    else if(s.getScore() >= 100) return Student14_11.Level.MID;
                    else return Student14_11.Level.LOW;
                },counting()));

        for(Student14_11.Level key : stuCntByLevel.keySet()){
            System.out.printf("[%s] - %d명, " ,key,stuCntByLevel.get(key));
            System.out.println();
        }

        System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");

        Map<Integer,Map<Integer,List<Student14_11>>> stuByHakAndBan =
                Stream.of(stuArr)
                .collect(groupingBy(Student14_11::getHak,groupingBy(Student14_11::getBan)));

        for(Map<Integer,List<Student14_11>> hak : stuByHakAndBan.values()){
            for(List<Student14_11> ban : hak.values()){
                System.out.println();
                for(Student14_11 s : ban){
                    System.out.println(s);
                }
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별,반별 1등)%n");

        Map<Integer,Map<Integer,Student14_11>> topStuByHakAndBan =
                Stream.of(stuArr)
                .collect(groupingBy(Student14_11::getHak,
                        groupingBy(Student14_11::getBan,
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(Student14_11::getScore))
                                        ,Optional::get
                                ))));

        for(Map<Integer,Student14_11> ban : topStuByHakAndBan.values()){
            for(Student14_11 s :ban.values()){
                System.out.println(s);
            }
        }

        System.out.printf("%n6. 다중그룹화 + 통계(학년별,반별 성적그룹)%n");

        Map<String,Set<Student14_11.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s->s.getHak() + "-" + s.getBan(),
                        mapping(s->{
                            if(s.getScore() >= 200) return Student14_11.Level.HIGH;
                            else if(s.getScore() >= 100) return Student14_11.Level.MID;
                            else return Student14_11.Level.LOW;
                        },toSet())));

        Set <String> keySet2 = stuByScoreGroup.keySet();
        for(String key : keySet2){
            System.out.println("["+key+"]" + stuByScoreGroup.get(key));
        }

    }



}
