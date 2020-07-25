package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.RStock;

@Repository
public interface StockRepository extends JpaRepository<RStock, Long>{

}
