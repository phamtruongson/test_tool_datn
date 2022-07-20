package com.sonpt.service;

import com.sonpt.infrastructure.response.SubCategoryResponse;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface SubCategoryService {
    Page<SubCategoryResponse> getAll(Pageable pageable);
}
