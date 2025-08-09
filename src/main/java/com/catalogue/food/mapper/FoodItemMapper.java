package com.catalogue.food.mapper;

import com.catalogue.food.dto.FoodItemDto;
import com.catalogue.food.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDto foodItemDto);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
}
