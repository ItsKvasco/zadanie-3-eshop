package sk.stuba.fei.uim.oop.assignment3.Cart;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

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
}
