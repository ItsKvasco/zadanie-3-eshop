package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
@Getter
@Setter
@Embeddable
public class ProductInCart {
    private Long productId;
    private Integer amount;
}
