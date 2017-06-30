package blockchain.controller;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockchainController {
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}