package sk.stuba.fei.uim.oop.assignment3.Product;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);
}
