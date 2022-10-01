import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_7 {
    public static void main(String[] args) {
        // 1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
        int answer = (int)(Math.random()*100+1);
        int input = 0; // 사용자 입력을 저장할 공간
        int count = 0; // 시도 횟수를 세기 위한 변수

        do{
            count++;
            try {
                System.out.print("1과 100사이의 값을 입력하세요 : ");
                input = new Scanner(System.in).nextInt();
                if(input < 1 || input >= 100){
                    System.out.println("[WAR] 유효한 범위의 값을 입력하세요.");
                }else {
                    if(answer > input){
                        System.out.println("더 큰 수를 입력하세요.");
                    }else if(answer < input){
                        System.out.println("더 작은 수를 입력하세요");
                    }else {
                        System.out.println("맞췄습니다.");
                        System.out.println("시도횟수는 " + count + "번입니다.");
                        break;
                    }
                }
            }catch (InputMismatchException im){
                System.out.println("[ERROR] 숫자만 입력해주세요");
            }
        }while (true);
    } // end of main
} // end of class HighLow
