public class Ex9_2 {
    public static void main(String[] args) {
        Person p1 = new Person(95100211112222L);
        Person p2 = new Person(95100211112222L);

        if(p1.equals(p2)){
            System.out.println("p1과 p2는 같은 사랍니다.");
        }else{
            System.out.println("p1과 p2는 다른 사람입니다.");
        }
    }
}

class Person{
    long id;
    public boolean equals(Object obj){
        if(!(obj instanceof Person))return  false;
        return id ==((Person)obj).id;
    }
    Person(long id){
        this.id = id;
    }
}
