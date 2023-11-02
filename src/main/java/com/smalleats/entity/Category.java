package com.smalleats.entity;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private int categoryId;
    private String categoryName;
}
