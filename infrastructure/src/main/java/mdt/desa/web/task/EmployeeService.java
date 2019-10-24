package mdt.desa.web.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mdt.desa.usecase.SampleUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeService {

    private final SampleUseCase useCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/hello/msn")
    public Mono<Void> saveMsn(@RequestBody MessageData data) {
        System.out.println("data: " + data.taskId + ", " + data.userId);
        return useCase.assignTask(data.taskId, data.userId);
    }

    @Data
    private static class MessageData {
        private String taskId;
        private String userId;
    }

}
