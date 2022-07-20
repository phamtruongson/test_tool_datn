package com.sonpt.controller;


import com.sonpt.infrastructure.response.SubCategoryResponse;
import com.sonpt.service.impl.SubCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/sub-cate/")
public class SubCategoryController {
    @Autowired
    public SubCategoryServiceImpl subCategoryService;

    @GetMapping(value = "get-list/{size}")
    public ResponseEntity<Page<SubCategoryResponse>> getAllSubCate(@PathVariable("size") int size ){
        Pageable pageable = PageRequest.of(0, size);
        return new ResponseEntity<>(subCategoryService.getAll(pageable), HttpStatus.OK);
    }
}
