package pl.coderslab.day2.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CartController {
    private final Cart cart;
    private final ProduktDao produktDao;

    public CartController(Cart cart, ProduktDao produktDao) {
        this.cart = cart;
        this.produktDao = produktDao;
    }


    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam Long id, @RequestParam int quantity) {
        Product product = produktDao.findById(id);
        if (product != null) {
            cart.addToCart(quantity, product);
            return "Dodano " + quantity + " x " + product.getName() + " do koszyka.";
        } else {
            return "Nie znaleziono produktu o id = " + id;
        }

    }

    @RequestMapping("/cart")
    @ResponseBody
    public String showCart() {
        int amount = 0;
        double wholePrice = 0;

        for (CartItem ci : cart.getCartItems()) {
            amount += ci.getQuantity();
            wholePrice += ci.getQuantity() * ci.getProduct().getPrice();
        }

        return "W koszyku jest " + cart.getCartItems().size() + " pozycji.<br>" +
                "W koszyku jest " + amount + " produktów.<br>" +
                "Wartość koszyka to: " + String.format("%.2f", wholePrice) + " zł";
    }

}
