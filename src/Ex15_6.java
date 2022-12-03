import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex15_6 {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            // BufferedOutputStream의 버퍼 크기를 5로 한다.
            BufferedOutputStream bos = new BufferedOutputStream(fos,5);

            for(int i='1';i<='9';i++){
                bos.write(i);
            }
            //fos.close(); // FileOutputStream을 닫는다. -> 결과는 12345 -> 버퍼에 남아있는 데이터가 출력되지 못한 상태로 프로그램이 종료 되었기 때문이다.
            bos.close(); // 이를 해결하기 위해서는  BufferedOutputStream의 close()를 호출해 주어야 버퍼에 남아있던 모든 내용이 출력된다.
            // BufferedOutputStream의 close()는 기반 스트림인 FileOutputStream의 close()를 호출하기 때문에 FileOutputStream의 close()는 따로 호출해주지 않아도 된다.
            // 이처럼 보조 스트림을 사용한 경우에는 기반 스트림의 close()나 flush()를 호출할 필요 없이 단순히 보조 스트림의 close()를 호출하기만 하면 된다.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
