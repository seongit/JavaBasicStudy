public class FighterTest {
    public static void main(String[] args) {
//    Fighter f = new Fighter();
//    f.move(100,200);
//    f.attact(new Fighter());
    // 다형성으로 인해 부모타입의 참조변수로 자식객체에 접근할 수 있음
    Fighter f = new Fighter();
    Fightable f2 = f.getFightable();
    //Fightable f = new Fighter();
    f.move(100,200);
    f.attact(new Fighter());
    }
}
abstract class Unit2{
    int x,y;
    abstract void move(int x, int y);
    void stop(){
        System.out.println("멈춥니다.");
    }
}

interface Fightable{
    void move(int x,int y); // public astract가 생략됨
    void attact(Fightable f);// public astract가 생략됨
}

class Fighter extends Unit2 implements Fightable{

    @Override
    public void move(int x, int y) {
        System.out.println("[" + x + "]" + "[" +y  +"]로 이동" );
    }

    @Override
    public void attact(Fightable f) {
        System.out.println(f+"를 공격");
    }

    Fightable getFightable(){
        Fighter f = new Fighter();
        return f;
    }
}