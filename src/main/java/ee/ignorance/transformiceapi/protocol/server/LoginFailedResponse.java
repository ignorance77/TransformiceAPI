package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.LoginFailedProcessor;

import java.util.List;

public class LoginFailedResponse extends AbstractResponse {

        public LoginFailedResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new LoginFailedProcessor();
        }
}
