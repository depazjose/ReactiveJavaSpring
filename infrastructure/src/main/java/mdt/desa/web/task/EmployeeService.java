package mdt.desa.web.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mdt.desa.usecase.SampleUseCase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeService {

    private final SampleUseCase useCase;
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
            e.printStackTrace();
        }

        try {
            File file = resource.getFile();
            logger.info(file.getName());
            logger.info(file.toString());

        } catch (IOException e) {
            logger.error(e.getMessage());
            //e.printStackTrace();
        }
    }
}
