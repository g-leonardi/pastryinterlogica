package giuseppe.leonardi.pasticceria.webapp.service;

import giuseppe.leonardi.pasticceria.webapp.models.dao.Ingredient;
import giuseppe.leonardi.pasticceria.webapp.models.dao.Pastry;
import giuseppe.leonardi.pasticceria.webapp.models.dao.SellPastry;
import giuseppe.leonardi.pasticceria.webapp.repository.IngredientRepository;
import giuseppe.leonardi.pasticceria.webapp.repository.PastryRepository;
import giuseppe.leonardi.pasticceria.webapp.repository.SellPastryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PastryService {
    @Autowired
    private PastryRepository pastryRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private SellPastryRepository sellPastryRepository;

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

    public void deleteIngredient(Optional<Long> ingredientId) {
        Ingredient byId = ingredientRepository.findById(ingredientId.get()).get();
        byId.setParentPastry(null);
        ingredientRepository.delete(byId);
    }

    public void deletePastry(Optional<Long> pastryId) {
        Pastry pastry = pastryRepository.findById(pastryId.get()).get();
        pastryRepository.delete(pastry);
    }

    public void saveSellPastry(SellPastry sellPastry) {
        sellPastryRepository.save(sellPastry);
    }

    public List<SellPastry> getAllSellPastries() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -4);
        return sellPastryRepository.findAllByCreateDateAfter(cal.getTime());
    }

    public double getPrice(SellPastry sellPastry) {
        LocalDate sellPastryDate = sellPastry.getCreateDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = LocalDate.now();
        long daysBetween = Period.between(sellPastryDate, now).getDays();
        if(daysBetween==0){
            return sellPastry.getPrice();
        }if(daysBetween==1){
            return (sellPastry.getPrice()*4)/5;
        }if(daysBetween==2){
            return sellPastry.getPrice()/5;
        }
        return 0l;
    }
}
