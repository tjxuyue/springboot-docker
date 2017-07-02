package blockchain.entity;

import com.alibaba.fastjson.JSON;

import lombok.Data;

@Data
public class Response {
	private String message;
	private String status;

	public String responseToString(String message, String status) {
		this.message = message;
		this.status = status;
		return JSON.toJSONString(this);
	}

}
