package hello;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceEnvConfig;
import hello.config.MyDataSourceValueConfig;
import hello.datasource.MyDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceEnvConfig.class)
@Import(MyDataSourceConfigV1.class)
@ConfigurationPropertiesScan({"hello"})
@SpringBootApplication(scanBasePackages = "hello.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}

//@Import(MyDataSourceValueConfig.class)
