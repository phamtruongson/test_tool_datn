package com.sonpt.service.impl;


import com.sonpt.infrastructure.response.SubCategoryResponse;
import com.sonpt.repository.SubCategoryReponseRepository;
import com.sonpt.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryReponseRepository subCategoryReponseRepository;

    @Override
    public Page<SubCategoryResponse> getAll(Pageable pageable) {
        Page<SubCategoryResponse> page = subCategoryReponseRepository.getAll(pageable);
        return page;
    }

}
