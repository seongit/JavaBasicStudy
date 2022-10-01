abstract class Player{ // 추상 클래스
 abstract void play(int pos);
 abstract void stop();
}

class AudioPlayer extends Player{

    @Override
    void play(int pos) {
        System.out.println(pos + "위치부터 play합니다.");
    }

    @Override
    void stop() {
        System.out.println("재생을 멈춥니다.");
    }
}

public class PlayerTest {
    public static void main(String[] args) {
        Player ap = new AudioPlayer(); // 다형성
        ap.play(100); // 참조변수의 타입과는 상관이 없다. 실제 객체(AudioPlayer)가 가지고 있는 play 메소드가 호출됨
        ap.stop();

    }
}
