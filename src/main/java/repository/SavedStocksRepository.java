package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.SavedStocks;

@Repository
public interface SavedStocksRepository extends JpaRepository<SavedStocks, Long> {

}
