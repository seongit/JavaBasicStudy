
class Time{
    private int hour; //
    int minute;
    int second;

    public void setHour(int hour){
        if(isValidHour(hour)) return;
        this.hour = hour;
    }
    // 매개변수로 넘겨진 hour가 유효한지 확인해서 알려주는 메서드
    // 굳이 public으로 할 필요가 없음
    private boolean isValidHour(int hour){
        return hour < 0 || hour > 23;
    }
    public int getHour(){return hour;};
}
public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();
        t.setHour(21);
        System.out.println(t.getHour());
        t.setHour(100);
        System.out.println(t.getHour());
    }
}
