package kz.seisen.task5.strategy;



import kz.seisen.task5.dto.ProductDto;
import java.util.List;

public interface SortStrategy {
    List<ProductDto> sort(List<ProductDto> products);
}