package giuseppe.leonardi.pasticceria.webapp.repository;

import giuseppe.leonardi.pasticceria.webapp.models.dao.Pastry;
import giuseppe.leonardi.pasticceria.webapp.models.dao.SellPastry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface SellPastryRepository extends JpaRepository<SellPastry, Long> {

    public SellPastry save(SellPastry pastry);

    public List<SellPastry> findAllByCreateDateAfter(Date createDate);

    public Optional<SellPastry> findByPastry(Pastry pastry);
}
