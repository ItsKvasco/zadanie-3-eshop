package sk.stuba.fei.uim.oop.assignment3.Cart;

import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.Product.ProductAmountRequest;

import java.beans.BeanProperty;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addProductToCart(){
        return new ResponseEntity<>(cartService.addCart(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(cartService.findById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(cartService.deleteCartById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}/add")
    public ResponseEntity<Cart> addToCart(@PathVariable("id") Long id, @RequestBody ProductInCart request) {
        try {
            return new ResponseEntity<>(cartService.addToCart(id,request), HttpStatus.OK);
        }
        catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(BadHttpRequest e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}/pay")
    public ResponseEntity<String> payForCart(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(cartService.payForCart(id), HttpStatus.OK);
        }
        catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(BadHttpRequest e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
