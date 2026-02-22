package kz.seisen.task5.strategy;

import kz.seisen.task5.dto.ProductDto;
import java.util.*;

public class SortByPrice implements SortStrategy {
    @Override
    public List<ProductDto> sort(List<ProductDto> products) {
        products.sort(Comparator.comparingDouble(ProductDto::getPrice));
        return products;
    }
}