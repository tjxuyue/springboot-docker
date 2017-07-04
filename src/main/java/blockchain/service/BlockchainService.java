package blockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import blockchain.config.Constant;
import blockchain.config.PropertiesBlockchainRestConfig;
import blockchain.entity.BlockchainRestBody;
import blockchain.entity.Body;
import blockchain.utils.CheckUtils;

@Service
public class BlockchainService {

	@Autowired
	PropertiesBlockchainRestConfig propertiesBlockchainRestConfig;

	public BlockchainRestBody getBlockchainRestBody(Body body) {
		try {
			String[] newArgs = new String[body.getArgs().length + 1];

			newArgs[0] = body.getFunction();
			for (int i = 0; i < body.getArgs().length; i++) {
				newArgs[i + 1] = body.getArgs()[i];
			}
			BlockchainRestBody blockchainRestBody = new BlockchainRestBody();
			blockchainRestBody.setId(body.getId());
			blockchainRestBody.setMethod(Constant.METHOD_INVOKE);
			blockchainRestBody.setJsonrpc(propertiesBlockchainRestConfig.getJsonrpc());
			blockchainRestBody.setParams(propertiesBlockchainRestConfig.getType(), body.getChaincode(), null, newArgs);
			return blockchainRestBody;
		} catch (Exception e) {
			return null;
		}
	}

	public String PostRest(String url, String bodyJson) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<String>(bodyJson, headers);
		System.out.println("发送请求===>" + JSON.toJSONString(formEntity));
		String response = restTemplate.postForObject(url, formEntity, String.class);
		if (!CheckUtils.isEmpty(response)) {
			System.out.println("返回结果===>" + response);
		}
		return response;
	}

	public String chaincodeRestUrlFormat(String url, String port) {
		return "http://" + url + ":" + port + "/chaincode";
	}

	public String chainRestUrlFormat(String url, String port) {
		return "http://" + url + ":" + port + "/chain";
	}

	public String blockRestUrlFormat(String url, String port, String height) {
		return "http://" + url + ":" + port + "/chain/blocks/" + height;
	}
}
