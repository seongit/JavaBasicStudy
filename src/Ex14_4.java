import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex14_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        // list의 모든 요소를 출력
        // 방법 1. 기존 방식
//        Iterator it = list.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next());
//        }

        // 방법 2. 람다식 사용
        list.forEach(i-> System.out.print(i+", ")); // Consumer
        System.out.println();

        // list에서 2 또는 3의 배수를 제거한다.
        list.removeIf(x-> x%2 == 0 || x%3 ==0); // Predicate
        System.out.println(list);

        list.replaceAll( i -> i*10); // Function
        System.out.println(list);

        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");

        // map의 모든 요소를 {k,v}의 형식으로 출력한다.
        // 방법 1. 기존
//        Iterator it = map.entrySet().iterator();
//        while(it.hasNext())
//            System.out.println(it.next());

        // 방법 2.
        map.forEach((k,v) -> System.out.println("{" + k + ", " + v + "},"));

    }
}
