package com.smalleats.service;

import com.smalleats.DTO.foodProductDTO.*;
import com.smalleats.entity.Category;
import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.FoodProduct;
import com.smalleats.repository.FoodProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodProductService {
    private final FoodProductDAO foodProductDAO;
    public List<FoodProductsRespDto> getFoodProducts(){
        FoodProductsRespDto foodProductsRespDto = new FoodProductsRespDto();
        List<FoodProductsRespDto> foodProductRespDtoList = new ArrayList<>();
        List<FoodProduct> foodProductList = foodProductDAO.getFoodProducts();
        foodProductList.forEach(foodProduct -> {
            foodProductRespDtoList.add(foodProductsRespDto.toDto(foodProduct));
        });
        return foodProductRespDtoList;
    }

    public List<FoodMenuRespDto> getFoodMenu(int foodId){
        FoodMenuRespDto foodMenuRespDto = new FoodMenuRespDto();
        List<FoodMenuRespDto> foodMenuRespDtoList = new ArrayList<>();
        List<FoodMenu> foodMenuList = foodProductDAO.getFoodMenu(foodId);
        foodMenuList.forEach(foodMenu -> {
            foodMenuRespDtoList.add(foodMenuRespDto.toDto(foodMenu));
        });
        return foodMenuRespDtoList;
    }

    public List<FoodDeliveryRespDto> getFoodDeliverArea(int foodId){
        FoodDeliveryRespDto foodDeliveryRespDto = new FoodDeliveryRespDto();
        List<FoodDeliveryRespDto> foodDeliveryRespDtoList = new ArrayList<>();
        List<FoodDeliveryArea> foodDeliveryAreaList = foodProductDAO.getDeliveryArea(foodId);
        foodDeliveryAreaList.forEach(foodDeliveryArea -> {
            foodDeliveryRespDtoList.add(foodDeliveryRespDto.toDto(foodDeliveryArea));
        });
        return foodDeliveryRespDtoList;
    }
    public ProductDetailRespDto getProductDetail(int foodId){
        ProductDetailRespDto productDetailRespDto = new ProductDetailRespDto();
        FoodProduct foodProduct = foodProductDAO.getProductDetail(foodId);
        return productDetailRespDto.toDto(foodProduct);
    }

    public List<FoodProductsRespDto> foodProductSearch(SearchReqDto searchReqDto){
        FoodProductsRespDto productsRespDto = new FoodProductsRespDto();

        List<FoodProduct> foodProductList = foodProductDAO.searchFoodProducts(searchReqDto.toEntity());
        List<FoodProductsRespDto> foodProductsRespDtoList = new ArrayList<>();

        foodProductList.forEach(foodProduct -> {
            foodProductsRespDtoList.add(productsRespDto.toDto(foodProduct));
        });

        return foodProductsRespDtoList;
    }
}
