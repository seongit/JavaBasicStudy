public class Ex13_10 {
    public static void main(String[] args) {

        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");
        th1.start();
        th2.start();
        th3.start();


        try {
            Thread.sleep(2000); // 쓰레드 th1을 잠시 중단시킨다.
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume(); // 쓰레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();

        }catch (InterruptedException e){}

        System.out.println("프로그램이 종료되었습니다.");
    }
}
class MyThread implements Runnable{

    volatile  boolean suspended = false;
    volatile  boolean stopped = false;

    Thread th; // 내부적으로 쓰레드를 만들어서 쓰기 위함

    MyThread(String name){ // 생성자에서 쓰레드 이름을 받아 쓰레드를 생성함
        th = new Thread(this,name); // Thread(Runnable r, String name) 호출
    }

    void start(){
        th.start(); // 내부적으로 선언된 쓰레드를 start한다
    }

    void stop(){
        stopped = true;
    }

    void suspend(){
        suspended = true;
    }

    void resume(){
        suspended = false;
    }

    @Override
    public void run() {
        while (!stopped){
            if(!suspended){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
            }
        }
    }
}