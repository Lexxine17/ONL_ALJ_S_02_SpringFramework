package pl.coderslab.day2.session;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduktDao {
    public List<Product> getList() {
        List<Product> allProducts = new ArrayList<>();

        allProducts.add(new Product("Świeczka lawenda", 49.99, 1L));
        allProducts.add(new Product("świeczka wanilia", 49.99, 2L));
        allProducts.add(new Product("świeczka puder", 39.99, 3L));
        allProducts.add(new Product("Świeczka róża", 29.99, 4L));
        allProducts.add(new Product("Świeczka dynia", 69.99, 5L));
        return allProducts;
    }

    public Product findById(Long id) {
        Product product = null;
        for (Product p : getList()) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }
}
