package service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.RStock;
import repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public StockService() {
	}

	public RStock createStock(RStock s) {
		return stockRepository.save(s);
	}

	public Optional<RStock> getStock(long id) {
		return stockRepository.findById(id);
	}

	public void updateStock(RStock s) {
		stockRepository.save(s);
	}

	public void deleteStocks(Long id) {
		stockRepository.deleteById(id);
	}

	public List<RStock> getAllStocks() {
		return stockRepository.findAll();
	}
}
