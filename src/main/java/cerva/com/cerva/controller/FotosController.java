package cerva.com.cerva.controller;

import cerva.com.cerva.storage.FotoStorageRunnable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cervejas/fotos")
public class FotosController   {

    @PostMapping
    public DeferredResult<String> upload(@RequestParam("files[]") MultipartFile[] files){
        DeferredResult<String> resultado = new DeferredResult<>();
        Thread thread = new Thread(new FotoStorageRunnable(files,resultado));
        thread.start();
        System.out.println(files[0].getSize());
        return  resultado;
    }
}
