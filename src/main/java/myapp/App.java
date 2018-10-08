package myapp;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        AppWebClient wc = new AppWebClient();
        System.out.println(wc.getResult());
    }
}