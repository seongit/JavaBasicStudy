import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex15_8 {


    public static void main(String[] args) {
        try {
            String fileName = "test.txt";
            FileInputStream fis = new FileInputStream(fileName); // 바이트기반 스트림
            FileReader fr = new FileReader(fileName); // 문자기반 스트림

            int data = 0;
            while((data=fis.read())!=-1){
                System.out.print((char)data); // 출력 : Hello, ìëíì¸ì? -> 인코딩 깨짐
            }
            System.out.println();
            fis.close();

            while((data=fr.read())!=-1){
                System.out.print((char)data); // 출력 : Hello, 안녕하세요?
            }
            System.out.println();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
