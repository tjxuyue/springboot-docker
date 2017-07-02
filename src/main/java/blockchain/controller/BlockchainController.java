package blockchain.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import blockchain.config.Constant;
import blockchain.entity.BlockchainRestBody;
import blockchain.entity.Body;
import blockchain.entity.Response;
import blockchain.service.BlockchainService;
import blockchain.utils.CheckUtils;

@RestController
public class BlockchainController {

	@Autowired
	BlockchainService blockchainService;

	@RequestMapping("/chaincode/invoke")
	public String chaincode(@RequestBody Body body, HttpServletRequest request) {
		Response response = new Response();
		if (CheckUtils.isEmpty(body.getIp(), body.getPort(), body.getFunction()) || CheckUtils.isEmpty(body.getId())) {
			return response.responseToString(Constant.STATUS_ERROR_MISSING_BASIC_PARAMETER, Constant.MESSAGE_ERROR);
		}

		BlockchainRestBody blockchainRestBody = blockchainService.getBlockchainRestBody(body);
		if (null == blockchainRestBody) {
			return response.responseToString(Constant.STATUS_ERROR_BODY_ERROR, Constant.MESSAGE_ERROR);
		}
		String url = blockchainService.chaincodeRestUrlFormat(body.getIp(), body.getPort());
		if (null == url) {
			return response.responseToString(Constant.STATUS_ERROR_URL, Constant.MESSAGE_ERROR);
		}
		String message = blockchainService.PostRest(url, JSON.toJSONString(blockchainRestBody));
		return response.responseToString(message, Constant.STATUS_SUCCESS);

	}

	@RequestMapping("/chaincode")
	public String test(@RequestBody String blockchainRestBody) {
		return blockchainRestBody;
	}
}