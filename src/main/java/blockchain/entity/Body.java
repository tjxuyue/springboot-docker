package blockchain.entity;

import lombok.Data;

@Data
public class Body {
	private String ip;
	private String port;
	private String chaincode;
	private String function;
	private String[] args;
	private String username;
	private String password;
	private long id;
}
