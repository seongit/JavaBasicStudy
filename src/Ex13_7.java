public class Ex13_7 implements Runnable{

    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new Ex13_7()); // run()이라는 메서드를 가지고 있는 클래스의 객체를 매개변수로 주는 것
        t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. start()보다 먼저 작성할 것
        t.start();

        for(int i=1; i<=10;i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            System.out.println(i);
            if(i==5) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000); // 3초마다
            } catch (InterruptedException e) {
            }
            if (autoSave) autoSave();
        }
    }
    public void autoSave(){
        System.out.println("작업파일이 자동저장되었습니다.");
    }

}
