package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {

    Optional<PortfolioEntity> findByName(String portfolioEntity);
}
