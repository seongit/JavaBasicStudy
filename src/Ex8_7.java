public class Ex8_7 {
    public static void main(String[] args) {
        // throw new Exception();
        // Exception과 그 자손은 반드시 예외처리를 해줘야 한다(필수)
        try{
            throw new Exception();
        }catch (Exception e){

        }
        throw new RuntimeException();
        // RuntimeException과 그 자손은 예외처리를 해주지 않아도 컴파일이 된다.(선택)
    }
}
