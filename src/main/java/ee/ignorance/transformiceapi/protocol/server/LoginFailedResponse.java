package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.LoginFailedProcessor;

public final  class LoginFailedResponse implements Processable {

        public LoginFailedResponse() {      
        }
        
        @Override
        public AbstractProcessor getProcessor() {
                return new LoginFailedProcessor();
        }
}
