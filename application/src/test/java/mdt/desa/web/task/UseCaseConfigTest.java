package mdt.desa.web.task;

import static org.assertj.core.api.Assertions.*;
import mdt.desa.web.task.controller.SampleUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UseCaseConfigTest {

    @Autowired
    private SampleUseCase createUseCase;

    @Test
    public void createUseCase (){
        assertThat(createUseCase).isNotNull();
    }

    @SpringBootApplication
    @Import({UseCaseConfig.class})
    static class App {
        public static void main(String[] args) {
            SpringApplication.run(App.class, args);
        }
    }
}
