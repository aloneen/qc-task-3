package kz.seisen.task5;

import kz.seisen.task5.controller.ProductController;
import kz.seisen.task5.dto.ProductDto;
import kz.seisen.task5.repository.ProductRepository;
import kz.seisen.task5.service.ProductService;
import kz.seisen.task5.strategy.SortByName;
import kz.seisen.task5.strategy.SortByPrice;

public class Main {

    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository, new SortByName());
        ProductController controller = new ProductController(service);


        controller.addProduct(new ProductDto(0L, "Banana", 1.5));
        controller.addProduct(new ProductDto(0L, "Apple", 0.9));
        controller.addProduct(new ProductDto(0L, "Mango", 3.2));

        System.out.println(" by name: ");
        controller.showAll();

        controller.setSortStrategy(new SortByPrice());
        System.out.println(" by price: ");
        controller.showAll();

        System.out.println(" by ID: ");
        controller.showById(2);
        controller.showById(99);
    }
}