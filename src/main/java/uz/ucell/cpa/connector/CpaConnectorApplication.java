package uz.ucell.cpa.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CpaConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpaConnectorApplication.class, args);
    }

}
