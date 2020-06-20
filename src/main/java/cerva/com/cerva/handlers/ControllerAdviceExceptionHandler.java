package cerva.com.cerva.handlers;

import cerva.com.cerva.service.exception.NomeJaCadastradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(NomeJaCadastradoException.class)
    public ResponseEntity<String> handlerNomeJaCadastrado(NomeJaCadastradoException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
