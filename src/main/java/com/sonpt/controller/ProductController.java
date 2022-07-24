package com.sonpt.controller;

import com.sonpt.infrastructure.request.ProductRequest;
import com.sonpt.infrastructure.request.ProductUpdateRequest;
import com.sonpt.infrastructure.response.ProductResponse;
import com.sonpt.model.ResponeObject;
import com.sonpt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("get-list/{page}")
    public ResponseEntity<Page<ProductResponse>> getAll(@PathVariable int page){
        Sort sort = Sort.by("id").ascending();
        Pageable pageProduct = PageRequest.of(page, 5, sort);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll(pageProduct));
    }

    @PostMapping("add")
    public ResponseEntity<ResponeObject> add(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(productRequest));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponeObject> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.delete(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponeObject> update(@PathVariable Long id, @Valid @RequestBody ProductUpdateRequest updateRequest){
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, updateRequest));
    }
}
