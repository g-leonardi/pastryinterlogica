package giuseppe.leonardi.pasticceria.webapp.service;

import giuseppe.leonardi.pasticceria.webapp.models.Pastry;
import giuseppe.leonardi.pasticceria.webapp.repository.PastryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastryService {
    @Autowired
    private PastryRepository repository;

    public void savePastry(Pastry pastry){
        repository.save(pastry);
    }

    public List<Pastry> getAllPastries(){
        return repository.findAll();
    }

    public Pastry getPastry(Long id) {
        return repository.getOne(id);
    }
}
