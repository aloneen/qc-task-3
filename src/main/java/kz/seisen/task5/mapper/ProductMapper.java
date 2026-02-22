package kz.seisen.task5.mapper;


import kz.seisen.task5.dto.ProductDto;
import kz.seisen.task5.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);

    Product toEntity(ProductDto dto);
}
