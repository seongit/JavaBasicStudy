import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static jdk.nashorn.internal.objects.Global.print;

public class Ex11_1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1,4));
        print(list1,list2);

        Collections.sort(list1);
        Collections.sort(list2);

        print(list1,list2);

        System.out.println("list1.contacinsAll(List2):" + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3,"A");
        print(list1,list2);

        list2.set(3,"AA");
        print(list1,list2);

        System.out.println("list1.retainAll(list2):"+list1.retainAll(list2));
        print(list1,list2);

        // 주의 사항
//        list1.add(1); // autoboxing에 의해 내부적으로 list1.add(new Integer(1))로 변환되어 참조형으로 변경됨
//        list1.remove(1); // 인덱스가 1인 객체를 삭제
//        list1.remove(new Integer(1)); // 1을 삭제

        for(int i = list2.size()-1;i>=0;i--){
            if(list1.contains(list2.get(i)))
                list2.remove(i);    // 인덱스가 i인 곳에 저장된 요소를 삭제
        }
        print(list1,list2);
    }
    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
    }
} // class


