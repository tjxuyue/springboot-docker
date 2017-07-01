package blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import blockchain.config.PropertiesBlockchainRestConfig;
import blockchain.config.PropertiesServerConfig;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableConfigurationProperties({ PropertiesServerConfig.class, PropertiesBlockchainRestConfig.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}