package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public abstract class AbstractResponse {

	public AbstractResponse(List<String> rawMessage) {
		parse(rawMessage);
	}

        public AbstractResponse(byte[] rawMessage) {
		parse(rawMessage);
	}
	
	public void parse(List<String> rawMessage){
                throw new UnsupportedOperationException("This class does not use List<String>") ;
        }

        public void parse(byte[] rawMessage){
                throw new UnsupportedOperationException("This class does not use byte[]") ;
        }
	
}
