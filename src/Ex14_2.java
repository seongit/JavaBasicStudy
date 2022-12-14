import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random() * 100 ) + 1; // 1 ~ 100 난수
        Consumer<Integer> c = i -> System.out.print(i+", ");
        Predicate<Integer> p = i -> i%2==0; // 짝수인지 검사
        Function<Integer,Integer> f = i -> i/10*10; // i의 일의 자리를 앲앤다.


        List<Integer> list = new ArrayList<>();
        makeRandom(s,list); // list를 랜덤값을 채운다.
        System.out.println(list);
        printEventNum(p,c,list); // 짝수를 출력
        List<Integer> newList = doSomething(f,list);
        System.out.println(newList);

    }

    // Function<Integer,Integer> f = i -> i/10*10; // i의 일의 자리를 앲앤다.
    static <T> List<T> doSomething(Function<T,T> f, List <T> list){
        List <T> newList = new ArrayList<T>(list.size()); // list와 똑같은 size의 새로운 list 생성

        for (T i : list){
            newList.add(f.apply(i)); // list의 값을 하나씩 읽어서 일의 자리를 없앤 후 새로운 list에 저장함.
        }
        return newList;
    }


//    Consumer<Integer> c = i -> System.out.println(i+", ");
//    Predicate<Integer> p = i -> i%2==0; // 짝수인지 검사
    static <T> void printEventNum(Predicate<T> p , Consumer <T> c, List<T> list){
        System.out.print("[");
        for(T i : list){
            if(p.test(i)) // 짝수인지 검사  -> 결과는 true or false
                c.accept(i); // 화면에 i 출력
        }
        System.out.println("]");
    }

    static <T> void makeRandom(Supplier<T> s , List <T> list){
        for(int i=0;i<10;i++){
            list.add(s.get());
        }
    }


}



