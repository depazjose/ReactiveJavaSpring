package mdt.desa.web.task;


import mdt.desa.web.task.controller.SampleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public SampleUseCase createTasksUseCase() {
        return new SampleUseCase();
    }


}
