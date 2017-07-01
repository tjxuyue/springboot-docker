package blockchain.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import blockchain.config.ErrorCode;
import blockchain.entity.BlockchainRestBody;
import blockchain.entity.Body;
import blockchain.service.BlockchainService;
import blockchain.utils.CheckUtils;

@RestController
public class BlockchainController {

	@Autowired
	BlockchainService blockchainService;

	@RequestMapping("/chaincode/invoke")
	public String chaincode(@RequestBody Body body, HttpServletRequest request) {
		if (CheckUtils.isEmpty(body.getIp(), body.getPort(), body.getFunction()) || CheckUtils.isEmpty(body.getId())) {
			return ErrorCode.MISSING_BASIC_PARAMETER;
		}
		BlockchainRestBody blockchainRestBody = blockchainService.getBlockchainRestBody(body);
		String url = blockchainService.chaincodeRestUrlFormat(body.getIp(), body.getPort());
		return blockchainService.PostRest(url, JSON.toJSONString(blockchainRestBody));

	}

	@RequestMapping("/chaincode")
	public String test(@RequestBody String blockchainRestBody) {
		return blockchainRestBody;
	}
}