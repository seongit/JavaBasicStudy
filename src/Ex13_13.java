public class Ex13_13 {
    public static void main(String[] args) {

        Runnable r = new RunnableEx12();
        new Thread(r).start();
        new Thread(r).start();

    }
}

class Account2{
    private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

    public int getBalance(){
        return balance;
    }

    public synchronized void withdraw(int money){
        if(balance >= money){
            try{ Thread.sleep(1000);}catch (InterruptedException e){}
            balance -= money;
        }
    }

}

class RunnableEx13 implements Runnable{

    @Override
    public void run() {

    }
}