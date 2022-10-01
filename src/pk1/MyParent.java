package pk1;

 public class MyParent{
    private int prv;
            int dft;
    protected int prt;
    public int pub;

    public void printMember(){
        System.out.println(prv);
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}

 class MyParentTest {
    public static void main(String[] args) {
        MyParent p = new MyParent();
        //System.out.println(p.prv); // 에러
        System.out.println(p.dft); // OK
        System.out.println(p.prt); // OK
        System.out.println(p.pub); // OK
    }
}
