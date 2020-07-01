package cerva.com.cerva.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

    private MultipartFile[] files;
    private DeferredResult<String> resultado;

    public FotoStorageRunnable(MultipartFile[] files, DeferredResult<String> resultado) {
        this.files = files;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        System.out.println("Foto recebida "+files[0].getName());
        resultado.setResult("OK recebi a foto");
    }
}
