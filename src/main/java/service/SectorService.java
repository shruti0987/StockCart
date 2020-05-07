package service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Sector;
import repository.SectorRepository;


@Service
public class SectorService {

	@Autowired
    private SectorRepository sectorRepository;
	
	
	public SectorService() {
    }

    public Sector createSector(Sector sec) {
        return sectorRepository.save(sec);
    }

    public Optional<Sector> getSector(Long id) {
        return sectorRepository.findById(id);
    }

    public void updateSector(Sector sec) {
    	sectorRepository.save(sec);
    }

    public void deleteSector(Long id) {
    	sectorRepository.deleteById(id);
    }
    
    public List<Sector> getAllSectors()
    {
    	return sectorRepository.findAll();
    }
}
