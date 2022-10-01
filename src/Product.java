 class Product
{
    int price;
    int bonusPoint;
    Product(){}
    Product(int price){
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
}
 class Tv extends Product{
     Tv(){}
     public String toString(){
         return "TV";
     }
 }

class Exercies7_3{
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}