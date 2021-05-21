package sk.stuba.fei.uim.oop.assignment3.Product;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public List<Product> findAll(){
        ArrayList<Product> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Product findById(Long id) throws NotFoundException {
        var product  = repository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        throw new NotFoundException("Product with this id: " + id + " doesnt exist");
    }


    public Product addProduct(Product product) {
        repository.save(product);
        return product;
    }

    public Product updateById(Long id, ProductRequest request) throws NotFoundException {
        var product = findById(id);
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if(request.getDescription() != null){
            product.setDescription(request.getDescription());
        }
        repository.save(product);
        return product;
    }

    public void deleteById(Long id) throws NotFoundException{
        findById(id);
        repository.deleteById(id);
    }

    public Integer getProductAmount(Long id) throws NotFoundException{
       return findById(id).getAmount();
    }

    public Product updateProductAmount(Long id, ProductAmountRequest productAmountRequest) throws NotFoundException{
        var product = findById(id);
        product.setAmount(product.getAmount()+productAmountRequest.getAmount());
        repository.save(product);
        return product;
    }

    public void save(Product product) {
        repository.save(product);
    }
}
