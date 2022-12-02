import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex15_2 {

    public static void main(String[] args) {

        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[10]; // byte배열 temp의 크기가 10이라서 10byte를 읽어왔지만 output에 출력할 때는 temp[5]부터 5byte만 출력하였다.

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        input.read(temp,0,temp.length); // 읽어 온 데이터를 배열 temp에 담는다.
        output.write(temp,5,5); // temp[5]부터 5개의 데이터를 write한다.
        // 배열을 이용한 입출력은 작업의 효율을 증가시키므로 가능하면 입출력 대상에 따라 알맞은 크기의 배열을 사용하는 것이 좋다.

        outSrc = output.toByteArray();

        System.out.println("input Source : " + Arrays.toString(inSrc));
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }

}
