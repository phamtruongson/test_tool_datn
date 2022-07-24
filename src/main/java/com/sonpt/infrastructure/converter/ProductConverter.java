package com.sonpt.infrastructure.converter;

import com.sonpt.infrastructure.request.ProductRequest;
import com.sonpt.infrastructure.request.ProductUpdateRequest;
import com.sonpt.model.Products;

public class ProductConverter {
    public static Products convert(ProductRequest request){
        Products newProduct = new Products();
        newProduct.setSubcateId(request.getSubCateId());
        newProduct.setProduceName(request.getProduceName());
        newProduct.setColor(request.getColor());
        newProduct.setQuantity(request.getQuantity());
        newProduct.setSellPrice(request.getSellPDrice());
        newProduct.setOriginPrice(request.getOriginPrice());
        newProduct.setDescription(request.getDescription());

        return newProduct;
    }

}
