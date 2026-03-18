package rvt;

import java.util.*;

public class online_store {

class warehouse {
    
    private Map<String, Integer> prices;
    private Map<String, Integer> stock;

    public warehouse() {
        this.prices = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.stock.getOrDefault(product, 0);
    }

    public boolean take(String product) {

        if(!this.stock.containsKey(product)) {
            return false;
        }

        int current = this.stock.get(product);
        if (current > 0) {
            this.stock.put(product, current - 1);
            return true;    
        }    
        return false;
    }
    public Set<String> products() {
        return this.prices.keySet();
    }
}

public class item {
    private String product;
    private int qty;
    private int unitPrice;

    public item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    } 

    public int price() {
        return this.qty * this.unitPrice;
    }

    public  void increaseQuantity() {
        this.qty++;
    }

    @Override
    public String toString() {
        return this.product + ": " + this.qty;
    }

}

class shopping_cart {
    private Map<String, item> items;

    public shopping_cart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, new item(product, 1, price));
        }
    }

    public int price() {
        int total = 0;
        for (item item : this.items.values()) {
            total += item.price();
        }
        return total;
    }

    public void print() {
        for (item item : this.items.values()) {
            System.out.println(item);
        }
    }
}

class store {

    private warehouse warehouse;
    private Scanner scanner;

    public store(warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    public void shop(String customer) {
        shopping_cart cart = new shopping_cart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our products: ");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.println("what do you want to buy (press enter to end)?");
            String product = this.scanner.nextLine();

            if (product.isEmpty()) {
                break;
            }

           if (this.warehouse.stock(product) > 0) {
                cart.add(product, this.warehouse.price(product));
                this.warehouse.take(product);
           }
        }
        
    System.out.println("your shopping cart:");
    cart.print();
    System.out.println("total: " + cart.price());
        }
}


        public static void main(String[] args) {

            online_store os = new online_store();

            warehouse warehouse = os.new warehouse();
            warehouse.addProduct("coffee", 5, 10);
            warehouse.addProduct("milk", 3, 20);
            warehouse.addProduct("cream", 2, 55);
            warehouse.addProduct("bread", 7, 8);

            Scanner scanner = new Scanner(System.in);
            store store = os.new store(warehouse, scanner);
            store.shop("John");
        }
    }

