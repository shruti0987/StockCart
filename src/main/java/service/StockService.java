package service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Stock;
import repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
    private StockRepository stockRepository;
	
	public StockService() {
    }

    public Stock createStock(Stock s) {
        return stockRepository.save(s);
    }

    public Optional<Stock> getStock(long id) {
        return stockRepository.findById(id);
    }

    public void updateStock(Stock s) {
    	stockRepository.save(s);
    }

    public void deleteStocks(Long id) {
    	stockRepository.deleteById(id);
    }
    public List<Stock> getAllStocks()
    {
    	return stockRepository.findAll();
    }
}
