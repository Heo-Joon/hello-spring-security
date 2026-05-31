package kr.ac.hansung.repository;

import kr.ac.hansung.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    long countByStockEquals(int stock);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%") // ✅ 추가
    Page<Product> findByNameContaining(@Param("keyword") String keyword, Pageable pageable); // ✅ 추가
}