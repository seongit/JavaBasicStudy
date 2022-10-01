public class Ex7_1 {
    public static void main(String[] args) {
        SmartTv stv = new SmartTv();
        stv.channel = 10;
        stv.channelUp();
        System.out.println(stv.channel);
        stv.displayCapiton("Hello World");
        stv.caption = true;
        stv.channelUp();
        System.out.println(stv.channel);
        stv.displayCapiton("Hello World");
    }
}

class TV{
    boolean power;
    int channel;
    int channelResult;
    void power(){
        power = !power;
    };
    void channelUp(){
        ++channel;
    };
    void channelDown(){
        --channel;
    }
}

class SmartTv extends TV{
    boolean caption;
    void displayCapiton(String text){
        if(caption){
            System.out.println(text);
        }
    }
}
