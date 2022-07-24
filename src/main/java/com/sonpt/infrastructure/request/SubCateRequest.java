package com.sonpt.infrastructure.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCateRequest {

    @NotBlank (message = "Sub Category Code không được để trống")
    @Pattern(regexp = "^SA[0-9]{4}$", message = "Sub Catetory không đúng định dạng")
    private String subCateCode;

    @NotBlank(message = "Sub Category Name không được để trống")
    @Pattern(regexp = "^[a-zA-z ]*$", message = "Sub Category Name chỉ gồm chữ")
    private String subCateName;

    @NotNull(message = "Category ID không được để trống")
    @Positive(message = "Category ID là số nguyên dương")
    private Long cateId;
}
