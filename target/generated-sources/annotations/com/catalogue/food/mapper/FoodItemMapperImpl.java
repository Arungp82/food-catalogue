package com.catalogue.food.mapper;

import com.catalogue.food.dto.FoodItemDto;
import com.catalogue.food.entity.FoodItem;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-29T12:20:48+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class FoodItemMapperImpl implements FoodItemMapper {

    @Override
    public FoodItem mapFoodItemDTOToFoodItem(FoodItemDto foodItemDto) {
        if ( foodItemDto == null ) {
            return null;
        }

        FoodItem foodItem = new FoodItem();

        foodItem.setId( foodItemDto.getId() );
        foodItem.setItemName( foodItemDto.getItemName() );
        foodItem.setItemDescription( foodItemDto.getItemDescription() );
        foodItem.setVeg( foodItemDto.isVeg() );
        foodItem.setPrice( foodItemDto.getPrice() );
        foodItem.setRestaurantId( foodItemDto.getRestaurantId() );
        foodItem.setQuantity( foodItemDto.getQuantity() );

        return foodItem;
    }

    @Override
    public FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem) {
        if ( foodItem == null ) {
            return null;
        }

        FoodItemDto foodItemDto = new FoodItemDto();

        foodItemDto.setId( foodItem.getId() );
        foodItemDto.setItemName( foodItem.getItemName() );
        foodItemDto.setItemDescription( foodItem.getItemDescription() );
        foodItemDto.setVeg( foodItem.isVeg() );
        foodItemDto.setPrice( foodItem.getPrice() );
        foodItemDto.setRestaurantId( foodItem.getRestaurantId() );
        foodItemDto.setQuantity( foodItem.getQuantity() );

        return foodItemDto;
    }
}
