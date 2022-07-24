package com.sonpt.service;

import com.sonpt.infrastructure.request.SubCateRequest;
import com.sonpt.infrastructure.response.SubCategoryResponse;
import com.sonpt.model.ResponeObject;
import com.sonpt.model.SubCategories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SubCategoryService {
    Page<SubCategoryResponse> getAll(Pageable pageable);
    ResponeObject add(SubCateRequest request);

    ResponeObject update(SubCateRequest request, Long id);
}
