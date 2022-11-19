import java.util.Optional;

public class Ex14_0_5 {

    public static void main(String[] args) {
        // int [] arr = null; 이렇게 하면 안됨
        int [] arr = new int[0];
        System.out.println("arr.length="+arr.length);

        // Optional <String> opt = null; 이렇게 초기화해도 가능은 하나, 바람직 하지 않음
        Optional<String> opt = Optional.empty();
        //Optional<String> opt = Optional.of("abc");
        System.out.println("opt="+opt);
       String str = "";

        // 방법 1
//        try {
//            str = opt.get();
//        } catch (Exception e) {
//           str = ""; // 예외가 발생하면 빈문자열로("") 초기화
//        }
//        System.out.println("str="+str);


        // 방법 2
        // str = opt.orElse(""); // Optinal에 저장된 값이 null이면 "" 반환
        str = opt.orElseGet(String::new); // 결과는 똑같아 보여도 람다식이 활용도가 높다.
        System.out.println("str="+str);

    }
}
