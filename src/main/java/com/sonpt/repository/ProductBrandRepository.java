package com.sonpt.repository;

import com.sonpt.model.ProductBrands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBrandRepository extends JpaRepository<ProductBrands, Long> {
}
