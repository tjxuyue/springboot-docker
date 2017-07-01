package blockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		BlockchainRestBody blockchainRestBody = new BlockchainRestBody();
		blockchainRestBody.setId(body.getId());
		blockchainRestBody.setMethod(Constant.METHOD_INVOKE);
		blockchainRestBody.setJsonrpc(propertiesBlockchainRestConfig.getJsonrpc());
		blockchainRestBody.setParams(propertiesBlockchainRestConfig.getType(), body.getChaincode(), null,
				body.getArgs());
		return blockchainRestBody;
	}

	public String PostRest(String url, String bodyJson) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<String>(bodyJson, headers);
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
