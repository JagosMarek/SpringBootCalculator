package cz.marek.springblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories // <-- Přidáním tohoto řádku "aktivujeme" JPA v našem Spring Boot projektu
public class SpringBlogApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringBlogApplication.class, args);

    }
}
