package kz.seisen.task5.strategy;

import kz.seisen.task5.dto.ProductDto;
import java.util.*;

public class SortByName implements SortStrategy {
    @Override
    public List<ProductDto> sort(List<ProductDto> products) {
        products.sort(Comparator.comparing(ProductDto::getName));
        return products;
    }
}