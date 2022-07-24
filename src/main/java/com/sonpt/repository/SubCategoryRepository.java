package com.sonpt.repository;

import com.sonpt.model.SubCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategories, Long> {
    public Optional<SubCategories> findBySubCateName(String subCateName);
}
