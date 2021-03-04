package giuseppe.leonardi.pasticceria.webapp.models.dao;

import giuseppe.leonardi.pasticceria.webapp.models.Unit;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long quantity;
    private Unit unit;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pastry parentPastry;

}
