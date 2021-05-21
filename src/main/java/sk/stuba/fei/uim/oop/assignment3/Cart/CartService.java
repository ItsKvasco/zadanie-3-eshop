package sk.stuba.fei.uim.oop.assignment3.Cart;

import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;
import sk.stuba.fei.uim.oop.assignment3.Product.ProductService;

import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;

    public Cart addCart() {
        return cartRepository.save(new Cart());
    }

    public Cart findById(Long id) throws NotFoundException {
        var cart  = cartRepository.findById(id);
        if(cart.isPresent()){
            return cart.get();
        }
        throw new NotFoundException("Cart with this id: " + id + " doesnt exist");
    }
    public void deleteCartById(Long id) throws NotFoundException{
        findById(id);
        cartRepository.deleteById(id);
    }

    public Cart addToCart(Long id, ProductInCart request) throws NotFoundException, BadHttpRequest {
        var cart = findById(id);
        if(cart.isPayed()){
            throw new BadHttpRequest();
        }
        var product = productService.findById(request.getProductId());
        if(product.getAmount() < request.getAmount()){
            throw new BadHttpRequest();
        }
        var cartList  = cart.getShoppingList().stream().filter((item->item.getProductId().equals(request.getProductId()))).findAny();
        if(cartList.isEmpty()){
            cart.getShoppingList().add(request);
        }else{
            cartList.get().setAmount(cartList.get().getAmount()+request.getAmount());
        }
        product.setAmount(product.getAmount()-request.getAmount());
        cartRepository.save(cart);
        productService.save(product);
        return cart;
    }

    public String payForCart(Long id) throws NotFoundException, BadHttpRequest {
        var cart = findById(id);
        if(cart.isPayed()){
            throw new BadHttpRequest();
        }
        Float suma = 0f;
        for(var p : cart.getShoppingList()){
            suma+=p.getAmount()*productService.findById(p.getProductId()).getPrice();
        }
        cart.setPayed(true);
        cartRepository.save(cart);
        return suma.toString();
    }
}
