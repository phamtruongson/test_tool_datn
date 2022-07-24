package com.sonpt.service.impl;

import com.sonpt.infrastructure.converter.ProductConverter;
import com.sonpt.infrastructure.request.ProductRequest;
import com.sonpt.infrastructure.request.ProductUpdateRequest;
import com.sonpt.infrastructure.response.ProductResponse;
import com.sonpt.model.*;
import com.sonpt.repository.*;
import com.sonpt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductResponeRepository productResponeRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductBrandRepository productBrandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        return productResponeRepository.getAll(pageable);
    }

    @Override
    public ResponeObject add(ProductRequest productRequest) {
        Optional<SubCategories> subCate = subCategoryRepository.findById(productRequest.getSubCateId());
        if (!subCate.isPresent()){
            return new ResponeObject("Fail", "Sub Category ID không tồn tại", null);
        }
        Optional<Statuses> status = statusRepository.findByStatusName(productRequest.getStatusName().trim());
        if (!status.isPresent()){
            return new ResponeObject("Fail", "Status Name không tồn tại", null);
        }
        Optional<Brands> brand = brandRepository.findById(productRequest.getBrandId());
        if (!brand.isPresent()){
            return new ResponeObject("Fail", "Brand ID không tồn tại", null);
        }
        Products newProduct = ProductConverter.convert(productRequest);
        newProduct.setStatusId(status.get().getId());
        productRepository.save(newProduct);

        ProductBrands newProductBrand = new ProductBrands(newProduct.getId(), brand.get().getId());
        productBrandRepository.save(newProductBrand);

        return new ResponeObject("Success", "Thêm thành công", newProduct);
    }

    @Override
    public ResponeObject delete(Long id) {
        Optional<Products> deleteProduct = productRepository.findById(id);
        if (!deleteProduct.isPresent()){
            return new ResponeObject("Fail", "Product không tồn tại", false);
        }
        productRepository.delete(deleteProduct.get());
        return new ResponeObject("Success", "Xóa thành công", true);
    }

    @Override
    public ResponeObject update(Long id, ProductUpdateRequest updateRequest) {
        Optional<Products> updateProduct = productRepository.findById(id);
        if (!updateProduct.isPresent()){
            return new ResponeObject("Fail", "Product không tồn tại", null);
        }
        Optional<SubCategories> updateSubCate = subCategoryRepository.findBySubCateName(updateRequest.getSubCateName().trim());
        if (!updateSubCate.isPresent()){
            return new ResponeObject("Fail", "Sub Category Name không tồn tại", null);
        }
        Optional<Statuses> updateStatus = statusRepository.findByStatusName(updateRequest.getStatusName().trim());
        if (!updateStatus.isPresent()){
            return new ResponeObject("Fail", "Status Name không tồn tại", null);
        }
        Optional<Brands> updateBrand = brandRepository.findByBrandName(updateRequest.getBrandName().trim());
        if (!updateBrand.isPresent()){
            return new ResponeObject("Fail", "Brand Name không tồn tại", null);
        }
        updateProduct.get().setSubcateId(updateSubCate.get().getId());
        updateProduct.get().setProduceName(updateRequest.getProduceName());
        updateProduct.get().setColor(updateRequest.getColor());
        updateProduct.get().setQuantity(updateRequest.getQuantity());
        updateProduct.get().setSellPrice(updateRequest.getSellPrice());
        updateProduct.get().setOriginPrice(updateRequest.getOriginPrice());
        updateProduct.get().setDescription(updateRequest.getDescription());
        updateProduct.get().setStatusId(updateStatus.get().getId());

        productRepository.save(updateProduct.get());

        ProductBrands updateProductBrand = new ProductBrands(updateProduct.get().getId(), updateBrand.get().getId());
        productBrandRepository.save(updateProductBrand);
        return new ResponeObject("Success", "Sửa thành công", updateProduct.get());
    }


}
