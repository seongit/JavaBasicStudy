import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ex15_14 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream("test.txt");
            ps = new PrintStream(fos);
            System.setOut(ps); // System.out의 출력대상을 test.txt로 변경
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("File not found.");
        }

        System.out.println("Hello by System.out");
        System.out.println("Hello by System.err");

    }
}
