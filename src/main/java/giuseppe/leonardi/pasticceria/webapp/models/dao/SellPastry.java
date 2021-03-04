package giuseppe.leonardi.pasticceria.webapp.models.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class SellPastry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    private double price;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @OneToOne
    private Pastry pastry;


    @PrePersist
    public void onCreate(){ setCreateDate(new Date()); }

}
