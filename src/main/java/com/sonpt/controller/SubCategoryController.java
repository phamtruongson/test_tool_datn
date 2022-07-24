package com.sonpt.controller;


import com.sonpt.infrastructure.request.SubCateRequest;
import com.sonpt.infrastructure.response.SubCategoryResponse;
import com.sonpt.model.ResponeObject;
import com.sonpt.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import javax.validation.Valid;


@RestController
@RequestMapping("/sub-cate/")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping(value = "get-list/{page}")
    public ResponseEntity<Page<SubCategoryResponse>> getAllSubCate(@PathVariable("page") int page){
        Pageable pageable = PageRequest.of(page, 5);
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.getAll(pageable));
    }

    @PostMapping("add")
    public ResponseEntity<ResponeObject> addSubCate(@Valid @RequestBody SubCateRequest subCateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.add(subCateRequest));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponeObject> updateSubCate(@Valid @RequestBody SubCateRequest subCateRequest,
                                                       @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.update(subCateRequest, id));
    }
}
