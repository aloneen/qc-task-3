package kz.seisen.task5.repository;

import kz.seisen.task5.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public void save(Product product) {
        product.setId(nextId++);
        products.add(product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
