import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {
    public static void main(String[] args) {
        Object[] objArr = {"1",new Integer(1),"2","3","4","4","5","6","5"};
        Collection set = new HashSet();

        for(int i=0;i<objArr.length;i++){
            set.add(objArr[i]); // HashSet에 objArr의 요소들을 저장한다.
        }

        // HashSet에 저장된 요소들을 출력한다.
        System.out.println(set);

        // HashSet에 저장된 요소들을 출력한다(Iterator 이용)

        Iterator it = set.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
