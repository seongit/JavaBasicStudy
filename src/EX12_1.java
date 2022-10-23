import java.util.*;
class Product3{}
class Tv3 extends Product3{}
class Audio3 extends Product3{}

public class EX12_1 {

    public static void main(String[] args) {
        ArrayList<Product3> productList = new ArrayList<Product3>();
        ArrayList<Tv3> tvList = new ArrayList<Tv3>();

        productList.add(new Tv3());
        productList.add(new Audio3());

        tvList.add(new Tv3());
        // tvList.add(new Audio3()); 컴파일 에러 발생

        printAll(productList);
        //printAll(tvList);

    }
    public static void printAll(ArrayList<Product3> list){
        for(Product3 p: list){
            System.out.println(p);
        }
    }
}
