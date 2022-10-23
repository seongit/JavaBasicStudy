import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex11_13 {

    public static void main(String[] args) {
        Set set = new TreeSet();  // 범위 검색, 정렬. 정렬 필요 없음
        //Set set = new HashSet();  // 정렬 필요
        for(int i=0;set.size() < 6; i++){
            int num = (int)(Math.random()*45)+1;
            set.add(new test());
            //set.add(new test());
        }
        System.out.println(set);
    }
}
// 저장 객체가 Comparable을 가지고 있거나
class Test implements  Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class test{

}

// TreeSet이 어떤 정렬 기준을 가지고 있거나
class TestComp implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}