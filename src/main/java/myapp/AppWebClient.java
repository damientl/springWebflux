package myapp;

import org.springframework.http.MediaType;
        import org.springframework.web.reactive.function.client.ClientResponse;
        import org.springframework.web.reactive.function.client.WebClient;

        import reactor.core.publisher.Mono;

public class AppWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = client.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();
    private WebClient client2 = WebClient.create("http://google.com");

    private Mono<ClientResponse> result2 = client2.get()
            .uri("")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public String getResult() {
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }

    public String getResult2() {
        return ">> result2 = " + result2.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}