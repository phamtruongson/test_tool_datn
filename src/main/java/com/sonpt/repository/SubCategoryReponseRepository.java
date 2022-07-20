package com.sonpt.repository;


import com.sonpt.infrastructure.response.SubCategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface SubCategoryReponseRepository extends JpaRepository<SubCategoryResponse, Long> {
    @Query(value = "select sub_category.id as id, sub_category.sub_cate_code, category.cate_name from " +
            "sub_category inner join category on sub_category.cate_id = category.id",nativeQuery = true)
    Page<SubCategoryResponse> getAll(Pageable pageable);
}
