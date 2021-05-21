package sk.stuba.fei.uim.oop.assignment3.Cart;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(cartService.findById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cart> addProductToCart(){
        return new ResponseEntity<>(cartService.addCart(), HttpStatus.CREATED);
    }



}
