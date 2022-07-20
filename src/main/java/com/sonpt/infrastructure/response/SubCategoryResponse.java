package com.sonpt.infrastructure.response;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class SubCategoryResponse {

    @Id
    private Long id;
    private String subCateCode;
    private String cateName;
}
