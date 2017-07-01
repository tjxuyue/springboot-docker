package blockchain.entity;

import blockchain.utils.CheckUtils;
import lombok.Data;

@Data
public class BlockchainRestBody {
	private String jsonrpc;
	private String method;
	private Params params;
	private long id;

	@Data
	public class Params {
		private String type;
		private ChaincodeID chaincodeID;
		private CtorMsg ctorMsg;
		private String secureContext;
	}

	public void setParams(String type, String name, String path, String[] args) {
		Params params = new Params();
		ChaincodeID chaincodeID = new ChaincodeID(path, name);
		CtorMsg ctorMsg = new CtorMsg(args);
		params.setType(type);
		params.setChaincodeID(chaincodeID);
		params.setCtorMsg(ctorMsg);
		this.params=params;
	}

	@Data
	public class ChaincodeID {
		private String path;
		private String name;

		public ChaincodeID(String path, String name) {
			if (CheckUtils.isEmpty(path)) {
				this.name = name;
				return;
			}
			if (CheckUtils.isEmpty(name)) {
				this.path = path;
				return;
			}
			this.name = "";

		}
	}

	@Data
	public class CtorMsg {
		private String[] args;

		public CtorMsg(String[] args) {
			this.args = args;
		}
	}
}
