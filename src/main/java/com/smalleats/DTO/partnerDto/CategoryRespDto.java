package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRespDto {
    private int categoryId;
    private String categoryName;

    public CategoryRespDto toDto(Category category){
        return CategoryRespDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
