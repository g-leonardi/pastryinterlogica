package giuseppe.leonardi.pasticceria.webapp.repository;

import giuseppe.leonardi.pasticceria.webapp.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    public Ingredient save(Ingredient pastry);
}
