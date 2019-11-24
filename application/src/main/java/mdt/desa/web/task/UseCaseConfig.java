package mdt.desa.web.task;


import mdt.desa.usecase.GenerateExcelUseCase;
import mdt.desa.usecase.SampleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public SampleUseCase createTasksUseCase() {
        return new SampleUseCase();
    }

    @Bean
    public GenerateExcelUseCase generateExcelUseCase() {return new GenerateExcelUseCase();};

}
