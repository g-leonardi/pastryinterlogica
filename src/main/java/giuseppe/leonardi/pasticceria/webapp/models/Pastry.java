package giuseppe.leonardi.pasticceria.webapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Pastry {

    private Long id;
    private String name;
    @ToString.Exclude
    private List<Ingredient> recipe;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentPastry", fetch = FetchType.LAZY)
    public List<Ingredient> getRecipe() {
        return recipe;
    }
}
