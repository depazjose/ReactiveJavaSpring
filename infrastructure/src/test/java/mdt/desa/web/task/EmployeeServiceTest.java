package mdt.desa.web.task;


import mdt.desa.web.task.controller.SampleUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Autowired
    private WebTestClient testClient;

    @MockBean
    private SampleUseCase useCase;
    private final String userId = "35";
    private final String taskId = "56";

    @Before
    public void init() {
            when(useCase.assignTask(taskId, userId)).thenReturn(Mono.empty());
    }


    @Test
    public void saveMsnTest() {

        final WebTestClient.ResponseSpec spec = testClient.post().uri("/employee/hello/msn")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody("{\"taskId\": \"56\", \"userId\": \"35\"}")
                .exchange();

        spec.expectStatus().isOk();
        verify(useCase).assignTask(taskId, userId);
    }

}

