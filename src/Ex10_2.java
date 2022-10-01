import java.util.Calendar;

public class Ex10_2 {
    public static void main(String[] args) {
        final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        // month의 경우 0부터 시작함 주의
        date1.set(2023,9,2);
        System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고,");
        System.out.println("오늘(date2)은 "+ toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일입니다.");

        // 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야한다
        long difference = (date1.getTimeInMillis() - date2.getTimeInMillis()) / 1000;
        System.out.println("지금(date2)부터 그날(date1)까지 " + difference + "남았습니다.");

        System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일 입니다.");


    }
    public static String toString(Calendar date){
        return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH)+1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}
