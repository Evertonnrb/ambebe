package cerva.com.cerva.converter;

import cerva.com.cerva.model.Estilo;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EstiloConverter implements Converter<String, Estilo> {
    @Override
    public Estilo convert(String s) {
        Estilo estilo = new Estilo();
        estilo.setCodigo(Long.valueOf(s));
        estilo.setNome(s);
        return estilo;
    }
}
