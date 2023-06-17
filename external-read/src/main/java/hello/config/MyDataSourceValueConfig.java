package hello.config;

import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceValueConfig {
    @Value("${my.datasource.url}")
    private String url;
    @Value("${my.datasource.username}")
    private String username;
    @Value("${my.datasource.password}")
    private String password;
    @Value("${my.datasource.etc.max-connection:3}")
    private int maxConnection;
    @Value("${my.datasource.etc.timeout}")
    private Duration duration;
    @Value("${my.datasource.etc.options}")
    private List<String> options;

    @Bean
    public MyDataSource myDataSource1() {
        return new MyDataSource(url, username, password, maxConnection, duration, options);
    }

    @Bean
    public MyDataSource myDataSource2(
            @Value("${my.datasource.url}") String url,
            @Value("${my.datasource.username}") String username,
            @Value("${my.datasource.password}") String password,
            @Value("${my.datasource.etc.max-connection:2}") int maxConnection,
            @Value("${my.datasource.etc.timeout}") Duration duration,
            @Value("${my.datasource.etc.options}") List<String> options,
            @Value("${USER}") String asd // 시스템 변수
            ) {
        log.info("USER={}",asd);
        return new MyDataSource(url, username, password, maxConnection, duration, options);
    }
}
