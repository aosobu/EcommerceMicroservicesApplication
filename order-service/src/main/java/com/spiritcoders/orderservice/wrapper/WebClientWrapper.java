package com.spiritcoders.orderservice.wrapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class WebClientWrapper {

    private final WebClient webClient;

    private boolean makeSynchronousCallWithClient(String uri){
        return Boolean.TRUE.equals(webClient.get().uri(uri)
                .retrieve().bodyToMono(Boolean.class)
                .block());
    }
}
