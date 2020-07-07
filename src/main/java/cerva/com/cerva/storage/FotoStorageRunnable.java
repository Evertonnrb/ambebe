package cerva.com.cerva.storage;

import cerva.com.cerva.dto.FotoDTO;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

    private MultipartFile[] files;
    private DeferredResult<FotoDTO> resultado;

    public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado) {
        this.files = files;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        System.out.println("Foto recebida "+files[0].getName());
        String nomeFoto = files[0].getOriginalFilename();
        String contentType = files[0].getContentType();
        resultado.setResult(new FotoDTO(nomeFoto,contentType));
    }
}
