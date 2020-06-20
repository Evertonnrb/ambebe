package cerva.com.cerva.repository;

import cerva.com.cerva.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface Estilos extends JpaRepository<Estilo,Long> {

    public Optional<Estilo> findByNome(String nome);

}
