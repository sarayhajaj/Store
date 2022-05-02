import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ShoppingCart {
    public static double priceForUser(HashMap<Integer, Product> merchandiseHashMap, Customers currentCustomer){
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> customerShop = new LinkedList<>();
        int numberProduct;
        boolean completePurchase = false;
        int productStock;
        double price = 0;
        do {
            System.out.println("The product in stock is:" + merchandiseHashMap.toString());
            System.out.println("Select the product numbers you want to add to the cart , press -1 to complete a purchase");
            numberProduct = scanner.nextInt();
            if (numberProduct == -1){
                System.out.println("End of purchase");
                completePurchase = true;
            }else if (merchandiseHashMap.containsKey(numberProduct)){
                do {
                    System.out.println("What is the amount you would like to add to your cart?");
                    productStock = scanner.nextInt();
                }while (merchandiseHashMap.get(numberProduct).getAmountOfProduct() < productStock);
                System.out.println("The list of product in your cart:");
                customerShop.add(merchandiseHashMap.get(numberProduct).getProductName() + " amount : " + productStock);
                for (int i = 0 ; i < customerShop.size() ; i++ ){
                    System.out.println(customerShop.get(i));
                }
            }else System.out.println("Incorrect product number , please try again");
        }while (numberProduct != -1);
        return price;
    }
}
