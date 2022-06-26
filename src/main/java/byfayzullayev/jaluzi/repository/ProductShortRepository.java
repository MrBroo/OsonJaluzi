package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.ProductShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProductShortRepository extends JpaRepository<ProductShortEntity, Long> {
    Optional<ProductShortEntity> findByName(String productShortEntity);

    @Query(value = "select t.* from product_short_entity t where t.category_entity_id = ?1", nativeQuery = true)
    List<ProductShortEntity> findByCategoryId(long id);
}
