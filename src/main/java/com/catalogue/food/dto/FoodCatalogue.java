package com.catalogue.food.dto;

import com.catalogue.food.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogue {
    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}
