package kz.seisen.task5.service;

import kz.seisen.task5.dto.ProductDto;
import kz.seisen.task5.mapper.ProductMapper;
import kz.seisen.task5.repository.ProductRepository;
import kz.seisen.task5.strategy.SortStrategy;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository repository;
    private SortStrategy sortStrategy;

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    public ProductService(ProductRepository repository, SortStrategy sortStrategy) {
        this.repository = repository;
        this.sortStrategy = sortStrategy;
    }

    public void addProduct(ProductDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    public List<ProductDto> getAllSorted() {
        List<ProductDto> dtos = repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return sortStrategy.sort(dtos);
    }

    public Optional<ProductDto> getById(int id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}