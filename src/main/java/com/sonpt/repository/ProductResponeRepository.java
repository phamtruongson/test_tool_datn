package com.sonpt.repository;

import com.sonpt.infrastructure.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductResponeRepository extends JpaRepository<ProductResponse, Long> {

    @Query(value = "select p.id as productId, sc.sub_cate_name, p.produce_name as product_name, p.color, p.quantity, p.sell_price, p.origin_price, s.status_name, b.brand_name\n" +
            "\tfrom product as p join sub_category as sc on p.subcate_id = sc.id\n" +
            "\tjoin status as s on p.status_id = s.id\n" +
            "    join product_brand as pb on p.id = pb.product_id\n" +
            "    join brand as b on pb.brand_id = b.id",
            countQuery = "select count(*) from product as p join sub_category as sc on p.subcate_id = sc.id\n" +
                    "\tjoin status as s on p.status_id = s.id\n" +
                    "    join product_brand as pb on p.id = pb.product_id\n" +
                    "    join brand as b on pb.brand_id = b.id;",
            nativeQuery = true)
    Page<ProductResponse> getAll(Pageable pageable);
}
