package cerva.com.cerva;

import cerva.com.cerva.converter.EstiloConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class CervaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CervaApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new FixedLocaleResolver(new Locale("pt","BR"));
    }

  /*  @Bean
    public FormattingConversionService formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new EstiloConverter());

        return conversionService;
    }*/
}
