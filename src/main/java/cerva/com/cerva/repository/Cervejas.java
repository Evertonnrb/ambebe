package cerva.com.cerva.repository;

import cerva.com.cerva.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {

    public Optional<Cerveja> findBySku(String sku);
}
