package giuseppe.leonardi.pasticceria.webapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class SellPastry {
    private Long id;
    private int quantity;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    private Pastry pastry;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToOne
    public Pastry getPastry() {
        return pastry;
    }

    @PrePersist
    public void onCreate(){ setCreateDate(new Date()); }
}
