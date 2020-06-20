package cerva.com.cerva.service;

import cerva.com.cerva.model.Estilo;
import cerva.com.cerva.repository.Estilos;
import cerva.com.cerva.service.exception.NomeJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroEstiloService {

    @Autowired
    private Estilos estilos;

    @Transactional
    public Estilo cadastrarEstilo(Estilo estilo) {
        Optional<Estilo> estiloOptional = estilos.findByNome(estilo.getNome());
        if(estiloOptional.isPresent()){
            throw new NomeJaCadastradoException("Nome do estilo já cadastrado");
        }
        return estilos.saveAndFlush(estilo);
    }
}
