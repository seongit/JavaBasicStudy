import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex15_3 {

    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Source : " + Arrays.toString(inSrc));

        try {
            // read()나 write()이 IOException을 발생시킬 수 있기 때문에 try-catch문으로 감싸주었다.
            // available()은 블락킹없이 읽어 올 수 있는 바이트의 수를 반환한다.
            // 블락킹이란 데이터를 읽어 올 때 데이터를 기다리기 위해 멈춰있는 것을 뜻한다.
            // 예를 들어 사용자가 데이터를 ㅣㅇ별갛기 전까지 기다리고 있을 때 블락킹 상태에 있다고 한다.
            while (input.available() > 0){
//                input.read(temp);
//                output.write(temp);
//
                int len = input.read(temp);
                output.write(temp,0,len);
                outSrc = output.toByteArray();
                printArrays(temp,outSrc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp :" + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }

}
