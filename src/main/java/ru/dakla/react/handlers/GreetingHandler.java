package ru.dakla.react.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dakla.react.domain.Message;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Long start = request.queryParam("start").map(Long::valueOf).orElse(0L);
        Long count = request.queryParam("count").map(Long::valueOf).orElse(3L);
        Flux<Message> data = Flux.just(
                "Hello, reactive!",
                "More then 1",
                "3 post",
                "4 post",
                "5 post"
        )
                .skip(start)
                .take(count)
                .map(Message::new);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(data, Message.class);
    }

    public Mono<ServerResponse> index(ServerRequest request) {
            String user = request.queryParam("user").orElse("Nobody");
            return ServerResponse
                    .ok()
                    .render("index", Map.of("user", user));
    }
}
