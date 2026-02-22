package kz.seisen.task5.controller;

import kz.seisen.task5.dto.ProductDto;
import kz.seisen.task5.service.ProductService;
import kz.seisen.task5.strategy.SortStrategy;

import java.util.List;

public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void addProduct(ProductDto dto) {
        service.addProduct(dto);
        System.out.println("Added: " + dto.getName() + " / $" + dto.getPrice());
    }

    public void showAll() {
        List<ProductDto> products = service.getAllSorted();
        products.forEach(System.out::println);
    }

    public void showById(int id) {
        service.getById(id)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Product not found: " + id)
                );
    }

    public void setSortStrategy(SortStrategy strategy) {
        service.setSortStrategy(strategy);
    }
}