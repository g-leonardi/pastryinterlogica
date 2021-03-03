package giuseppe.leonardi.pasticceria.webapp.service;

import giuseppe.leonardi.pasticceria.webapp.models.Ingredient;
import giuseppe.leonardi.pasticceria.webapp.models.Pastry;
import giuseppe.leonardi.pasticceria.webapp.repository.IngredientRepository;
import giuseppe.leonardi.pasticceria.webapp.repository.PastryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastryService {
    @Autowired
    private PastryRepository pastryRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public void savePastry(Pastry pastry){
        pastryRepository.save(pastry);
    }

    public List<Pastry> getAllPastries(){
        return pastryRepository.findAll();
    }

    public Pastry getPastry(Long id) {
        return pastryRepository.getOne(id);
    }

    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
