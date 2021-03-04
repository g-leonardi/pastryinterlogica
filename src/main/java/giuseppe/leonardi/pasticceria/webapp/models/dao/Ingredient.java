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
    private Long id;
    private String name;
    private long quantity;
    private Unit unit;
    @ToString.Exclude
    private Pastry parentPastry;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Pastry getParentPastry() {
        return parentPastry;
    }
}
