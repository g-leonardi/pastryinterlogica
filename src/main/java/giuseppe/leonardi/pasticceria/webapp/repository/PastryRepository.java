package giuseppe.leonardi.pasticceria.webapp.repository;

import giuseppe.leonardi.pasticceria.webapp.models.dao.Pastry;
import giuseppe.leonardi.pasticceria.webapp.models.dao.SellPastry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastryRepository extends JpaRepository<Pastry, Long> {

    public Pastry save(Pastry pastry);

}
