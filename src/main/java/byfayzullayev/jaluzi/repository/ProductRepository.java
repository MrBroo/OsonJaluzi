package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByName(String productEntity);
    List<ProductEntity> findByProductShortEntityId(long id);


}
