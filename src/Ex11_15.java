import java.util.SortedMap;
import java.util.TreeSet;

public class Ex11_15 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int[] score = {80,95,50,35,45,65,10,100};

        for(int i=0;i< score.length;i++){
            set.add(new Integer(score[i])); // set.add(score[i]); 도 가능
        }

        System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
        System.out.println("50보다 작은 값 : " + set.headSet(50)); // 자바 컴파일러에 의한 오토박싱
        System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
        System.out.println("50보다 큰 값 : " + set.tailSet(50)); // 자바 컴파일러에 의한 오토박싱

    }

}

