package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}
