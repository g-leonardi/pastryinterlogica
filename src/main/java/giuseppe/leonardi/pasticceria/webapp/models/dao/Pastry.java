package giuseppe.leonardi.pasticceria.webapp.models.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentPastry", fetch = FetchType.LAZY)
    private List<Ingredient> recipe;

}
