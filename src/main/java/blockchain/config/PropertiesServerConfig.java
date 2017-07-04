package blockchain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "server")
public class PropertiesServerConfig {
	private String port;
	private String host_ip;
}
