package service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.SavedStocks;
import repository.SavedStocksRepository;

@Service
public class SavedStocksService {

	@Autowired
    private SavedStocksRepository savedstocksRepository;
	
	
	public SavedStocksService() {
    }

    public SavedStocks createSavedStocks(SavedStocks s) {
        return savedstocksRepository.save(s);
    }

    public Optional<SavedStocks> getSavedStocks(Long id) {
        return savedstocksRepository.findById(id);
    }

    public void updateSavedStocks(SavedStocks user) {
    	savedstocksRepository.save(user);
    }

    public void deleteSavedStocks(Long id) {
    	savedstocksRepository.deleteById(id);
    }
    
    public List<SavedStocks> getAllSavedStocks()
    {
    	return savedstocksRepository.findAll();
    }
}

