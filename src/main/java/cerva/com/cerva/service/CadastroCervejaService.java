package cerva.com.cerva.service;

import cerva.com.cerva.model.Cerveja;
import cerva.com.cerva.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCervejaService {
    @Autowired
    private Cervejas cervejas;

    @Transactional
    public void cadastar(Cerveja cerveja) {
        cervejas.save(cerveja);
    }

}
