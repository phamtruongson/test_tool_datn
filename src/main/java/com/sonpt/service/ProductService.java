package com.sonpt.service;

import com.sonpt.infrastructure.request.ProductRequest;
import com.sonpt.infrastructure.request.ProductUpdateRequest;
import com.sonpt.infrastructure.response.ProductResponse;
import com.sonpt.model.ResponeObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductResponse> getAll(Pageable pageable);
    ResponeObject add(ProductRequest productRequest);

    ResponeObject delete(Long id);

    ResponeObject update(Long id, ProductUpdateRequest updateRequest);
}

