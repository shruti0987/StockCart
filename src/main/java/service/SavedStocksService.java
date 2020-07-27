package service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.SavedStocks;
import repository.SavedStocksRepository;

@Service
public class SavedStocksService {

	@Autowired
    private SavedStocksRepository repository;
	
	
	public SavedStocksService() {
    }

    public SavedStocks saveStock(SavedStocks s) {
        return repository.save(s);
    }

    public Optional<SavedStocks> getSavedStocks(long id) {
        return repository.findById(id);
    }

    public Collection<SavedStocks> getAllSavedStocksById(long user_id)
    {
    	return repository.findByUserId(user_id);
    }
    
    public List<SavedStocks> getAllSavedStocks()
    {
    	return repository.findAll();
    }
}

