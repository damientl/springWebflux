
    private void webfluxTest() {

        String a = "http://www.mocky.io/v2/5c8c1628360000ec538f8412";


        //String b = "http://www.mocky.io/v2/5c8c15f636000025538f8411";


        Mono<String> aMono = WebClient.builder().build().get()
            .uri(a)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap(process -> process.bodyToMono(String.class))
            .map(response -> {
                LOGGER.info("response A: " + response);
                String b = gson.fromJson(response, WebfluxTestResponse.class).getUrl();
                LOGGER.info("B: " + b);
                return b;
            }
            );

        String urlResult = aMono.flatMap(urlB -> WebClient.builder().build().get()
            .uri(urlB)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap(process -> process.bodyToMono(String.class))
            .map(response -> {
                LOGGER.info("response B: " + response);
                String b = gson.fromJson(response, WebfluxTestResponse.class).getUrl();
                LOGGER.info("result response: " + b);
                return b;
            })).block();

        LOGGER.info("result : " + urlResult);

    }
