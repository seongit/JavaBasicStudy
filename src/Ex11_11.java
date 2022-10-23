import java.util.HashSet;
import java.util.Objects;

public class Ex11_11 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add("1");
        set.add(new Person2("David",10));
        set.add(new Person2("David",10));

        System.out.println(set);
    }
}

// equals()와 hashCode()를 오버라이딩 해야함
class Person2 {
    String name;
    int age;

    public int hashCode(){
        return Objects.hash(name,age);
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Person2)) return false;

        Person2 p = (Person2) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    Person2(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return name + ":" + age;
    }
}