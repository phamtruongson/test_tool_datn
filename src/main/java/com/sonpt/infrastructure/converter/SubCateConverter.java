package com.sonpt.infrastructure.converter;

import com.sonpt.infrastructure.request.SubCateRequest;
import com.sonpt.model.SubCategories;
import org.springframework.stereotype.Component;

@Component
public class SubCateConverter {
    public static SubCategories convert(SubCateRequest request){
        SubCategories entity = new SubCategories();
        entity.setSubCateCode(request.getSubCateCode());
        entity.setSubCateName(request.getSubCateName());
        entity.setCateId(request.getCateId());
        return entity;
    }
}
