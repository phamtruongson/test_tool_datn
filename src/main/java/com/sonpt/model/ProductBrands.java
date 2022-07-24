package com.sonpt.model;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "product_brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrands implements Serializable {

    @Id
    private Long productId;

    private Long brandId;
}
