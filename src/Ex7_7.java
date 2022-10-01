public class Ex7_7 {
    public static void main(String[] args) {
        CarTest car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;
        fe2 = (FireEngine)car;
        //car.water();
        fe2.water();

    }
}

class CarTest{
    String color;
    int door;
    void drive(){
        System.out.println("drive, Brrr~");
    }
    void stop(){
        System.out.println("stop!!!");
    }
}

class FireEngine extends CarTest{
    void water(){
        System.out.println("water!!!");
    }
}