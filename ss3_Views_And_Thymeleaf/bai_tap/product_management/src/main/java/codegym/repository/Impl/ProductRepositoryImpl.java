package codegym.repository.Impl;

import codegym.entity.Product;
import codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put("1", new Product("1", "IPhone 11", 12000000, "128GB", "Apple"));
        productMap.put("2", new Product("2", "Samsumg Galaxy S22", 10000000, "64GB", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void add(Product product) {
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void update(String id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(String id) {
            productMap.remove(id);
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> products = new ArrayList<>();
        for(Product product : productMap.values()){
            if (product.getProduct_name().equals(name))
                products.add(product);
        }
        return products;
    }
}
