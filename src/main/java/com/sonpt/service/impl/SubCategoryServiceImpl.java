package com.sonpt.service.impl;


import com.sonpt.infrastructure.converter.SubCateConverter;
import com.sonpt.infrastructure.request.SubCateRequest;
import com.sonpt.infrastructure.response.SubCategoryResponse;
import com.sonpt.model.Categories;
import com.sonpt.model.ResponeObject;
import com.sonpt.model.SubCategories;
import com.sonpt.repository.CategoryRepository;
import com.sonpt.repository.SubCategoryReponseRepository;
import com.sonpt.repository.SubCategoryRepository;
import com.sonpt.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryReponseRepository subCategoryReponseRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<SubCategoryResponse> getAll(Pageable pageable) {
        Page<SubCategoryResponse> page = subCategoryReponseRepository.getAll(pageable);
        return page;
    }

    @Override
    public ResponeObject add(SubCateRequest request) {
        Optional<Categories> requetCate = categoryRepository.findById(request.getCateId());
        if (!requetCate.isPresent()){
            return new ResponeObject("Fail", "Category ID không tồn tại", null);
        }
        SubCategories newSubCate = SubCateConverter.convert(request);
        subCategoryRepository.save(newSubCate);
        return new ResponeObject("Success", "Thêm thành công", newSubCate);
    }

    @Override
    public ResponeObject update(SubCateRequest request, Long id) {
        Optional<SubCategories> subCate = subCategoryRepository.findById(id);
        if (!subCate.isPresent()){
            return new ResponeObject("Fail", "Sub Category không tồn tại", null);
        }
        subCate.get().setSubCateName(request.getSubCateName());
        subCate.get().setSubCateCode(request.getSubCateCode());
        subCate.get().setCateId(request.getCateId());
        subCategoryRepository.save(subCate.get());
        return new ResponeObject("Success", "Sửa thành công", subCate.get());
    }


}
