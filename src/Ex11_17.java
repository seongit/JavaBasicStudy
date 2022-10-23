import java.util.*;

public class Ex11_17 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김자바",90);
        map.put("김자바",100);
        map.put("이자바",100);
        map.put("강자바",80);
        map.put("안자바",90);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map.keySet(); // 이름만 가져올 때
        System.out.println("참가자 명단 : " + set);

        Collection values = map.values(); // 값들만 가져올 때
        it  = values.iterator();

        int total = 0;
        while (it.hasNext()){
            int i = (int)it.next(); // 하나씩 꺼내서
            total += i; // 총점에 담는다다
       }

        System.out.println("총점 : "  + total);
        System.out.println("평균 : " +  (float)total/set.size());
        System.out.println("최고 점수 : " +  Collections.max(values));
        System.out.println("최저 점수 : " + Collections.min(values));

    }
}
