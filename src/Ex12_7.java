class Parent_2{
    void parentMethod(){}
}

class Child_2 extends Parent_2{
    @Override
    @Deprecated
    void parentMethod(){}
}

public class Ex12_7{
    public static void main(String[] args) {
        Child_2 c = new Child_2();
        //c.parentMethod();
    }
}