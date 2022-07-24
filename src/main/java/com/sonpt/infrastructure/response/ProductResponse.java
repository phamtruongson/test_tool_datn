package com.sonpt.infrastructure.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProductResponse {
    @Id
    private Long productID;
    private String subCateName;
    private String productName;
    private String color;
    private int quantity;
    private double sellPrice;
    private double originPrice;
    private String statusName;
    private String brandName;

}
