package blockchain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "blockchain.rest")
public class PropertiesBlockchainRestConfig {
	private String jsonrpc;
	private String type;

	public String getJsonrpc() {
		return this.jsonrpc.replaceAll("\"", "");
	}

	public String getType() {
		return this.type.replaceAll("\"", "");
	}
}
