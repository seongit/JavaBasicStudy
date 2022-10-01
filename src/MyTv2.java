public class MyTv2 {
    /**
     * 연습문제 7-4- MyTv2 클래스에 gotoPrevChannel 메서드를 추가하여 완성하시오
     */

    boolean isPowerOn;
    int channel;
    int prevChannel;
    int volume;


    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel(){
       return this.channel;
    }

    public void setChannel(int channel){
         this.prevChannel = this.channel;
         this.channel = channel;
    }


    // 메서드명 gotoPrevChannel
    // 기능 : 현재 채널을 이전 채널로 변경한다.
    // 반환타입 : 없음
    // 매개변수 : 없음
    // 이전 채널의 값을 저장할 멤버변수를 정의하라
    public void gotoPrevChannel(){
       setChannel(prevChannel);
    }

}

class Excercise7_5{
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH : " + t.getChannel());
        t.setChannel(20);
        System.out.println("CH : " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH : " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH : " + t.getChannel());
    }
}
