package sk.stuba.fei.uim.oop.assignment3.Cart;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {
    @Override
    Optional<Cart> findById(Long aLong);
}
