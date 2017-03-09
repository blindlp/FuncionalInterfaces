import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


/**
 * Created by luispo on 08/03/2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        List<Product> groceryStore = new LinkedList<Product>(
                Arrays.asList(
                        new Product(0,"Tomato", "Fruit",1.75f),
                        new Product(1,"Avocado","Fruit",5f),
                        new Product(2,"Lemon","Fruit",0.5f),
                        new Product(3,"Onion","Vegetable",1.50f),
                        new Product(4,"Carrot","Vegetable",1.25f),
                        new Product(5,"Broccoli", "Vegetable", 2f),
                        new Product(6,"Shrimp", "Seafood",10.99f),
                        new Product(7,"chicken","Meat",7.35f),
                        new Product(8,"Roast Beef","Meat",8.35f)
                )
        );


        // Print each of the products
        groceryStore.forEach(
                product -> System.out.println(product)
        );


        // Predicate filter of meat caregorie

        Predicate<Product> meatRemover = (Product product) ->
                "Meat".equals(product.categoria);

        // Remove meat caregories
        groceryStore.removeIf(meatRemover);
        System.out.println("\n\nWithout Meat: List");
        groceryStore.forEach(
                product -> System.out.println(product)
        );


        // Predicate remove a product more expensive $5
        Predicate<Product> moreExpensive = (Product product) ->
                product.price > 5f;
        groceryStore.removeIf(moreExpensive);
        System.out.println("\n\nWithout more expensive & Meat : List");
        groceryStore.forEach(
                product -> System.out.println(product)
        );
    }



 static class Product {
        public int id;
        public String name,categoria;
        public float price;

    public Product(int id, String name, String categoria, float price) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.price = price;
    }

    @Override
    public String toString() {
        return ( this.name + (new DecimalFormat(" $0.00").format(this.price)));
    }
}

}
