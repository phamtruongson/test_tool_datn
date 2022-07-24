package com.sonpt.repository;

import com.sonpt.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brands, Long> {
    public Optional<Brands> findByBrandName(String brandName);
}
