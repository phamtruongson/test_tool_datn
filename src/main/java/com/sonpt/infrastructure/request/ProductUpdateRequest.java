package com.sonpt.infrastructure.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequest {
    @NotBlank(message = "Sub Category Name không được để trống")
    private String subCateName;

    @NotBlank(message = "Produce Name Không được để trống")
    private String produceName;

    @NotBlank(message = "Color không được để trống")
    private String color;

    @NotNull(message = "Quantity không được để trống")
    @Positive(message = "Quantity phải là số nguyên dương")
    private int quantity;

    @NotNull(message = "Sell Price không được để trống")
    private double sellPrice;

    @NotNull(message = "Origin Price không được để trống")
    private double originPrice;

    @NotBlank(message = "Description không được để trống")
    private String description;

    @NotBlank(message = "Status Name không được để trống")
    private String statusName;

    @NotBlank(message = "Brand Name không được để trống")
    private String brandName;
}
