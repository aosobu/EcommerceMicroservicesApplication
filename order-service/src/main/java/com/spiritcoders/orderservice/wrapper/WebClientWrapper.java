package com.spiritcoders.orderservice.wrapper;

import com.spiritcoders.orderservice.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WebClientWrapper {

    private final WebClient.Builder webClient;

    public Class [] fetch(String uri, Class expectedClass, List<?> requestParams, String paramName){
        return (Class []) webClient.build().get().uri(uri, uriBuilder -> uriBuilder.queryParam(paramName, requestParams).build())
                        .retrieve().bodyToMono(expectedClass)
                            .block();
    }

    public InventoryResponse[] fetchTemp(String uri, List<?> requestParams, String paramName){
        return webClient.build().get().uri(uri, uriBuilder -> uriBuilder.queryParam(paramName, requestParams).build())
                .retrieve().bodyToMono(InventoryResponse[].class)
                .block();
    }
}
