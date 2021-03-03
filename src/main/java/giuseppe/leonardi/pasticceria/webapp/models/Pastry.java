package giuseppe.leonardi.pasticceria.webapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Pastry {

    private Long id;
    private String name;
    private List<Ingredient> recipe;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToMany
    public List<Ingredient> getRecipe() {
        return recipe;
    }
}
