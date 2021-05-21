package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAmountRequest {
    private Integer amount;

    public ProductAmountRequest(){};
    public ProductAmountRequest(Integer amount) {
        this.amount = amount;
    }
    public ProductAmountRequest(Product product){
        this.amount = product.getAmount();
    }
}
