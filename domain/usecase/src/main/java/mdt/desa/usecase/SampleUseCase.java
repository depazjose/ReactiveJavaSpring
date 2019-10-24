package mdt.desa.usecase;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SampleUseCase {


    public Mono<Void> assignTask(String taskId, String userId){
        return  Mono.empty();
    }
}
