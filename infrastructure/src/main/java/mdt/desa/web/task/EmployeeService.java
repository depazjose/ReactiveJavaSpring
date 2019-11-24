package mdt.desa.web.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mdt.desa.usecase.GenerateExcelUseCase;
import mdt.desa.usecase.SampleUseCase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.io.*;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeService {

    private final SampleUseCase useCase;
    private final GenerateExcelUseCase generateExcelUseCase;
    Logger logger = Loggers.getLogger(EmployeeService.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/hello/msn")
    public Mono<Void> saveMsn(@RequestBody MessageData data) {
        loadFile();
        logger.info("data: " + data.taskId + ", " + data.userId);
        return useCase.assignTask(data.taskId, data.userId);
    }

    @Data
    private static class MessageData {
        private String taskId;
        private String userId;
    }

    private void loadFile()
    {
        Resource resource = new ClassPathResource("Estandar.xml");

        try {
            InputStream input = resource.getInputStream();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        try {
            File file = resource.getFile();
            logger.info(file.getName());
            logger.info(file.toString());

        } catch (IOException e) {
            logger.error(e.getMessage());

        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Flux<String> fileUpload(@RequestBody MultipartFile parts) throws IOException {
        FilePart filePart = null;
                String fileName = "";

        if (parts instanceof  FilePart){
            filePart = (FilePart) parts;
            fileName = filePart.filename();
        }

        logger.info("fileName: "+ fileName);

        File convertFile = new File(fileName);
        convertFile.createNewFile();
        //FileOutputStream fout = new FileOutputStream(convertFile);
        //fout.write(parts.getgetBytes());
        //fout.close();
        return Flux.just("File is upload successfully");
    }


    @GetMapping(value = "/download")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {


        ByteArrayInputStream in = generateExcelUseCase.generateFromJson("Prices.xls");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Prices.xls");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }


}
