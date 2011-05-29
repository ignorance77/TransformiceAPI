package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.LoginSuccessProcessor;

public final class LoginSuccessResponse implements Processable {

        private String username;
        private int mouseId;
        private boolean admin;
        private boolean moderator;
        private boolean invite;

        public LoginSuccessResponse(List<String> rawMessage) {
	            username = rawMessage.get(1);
	            mouseId = Integer.parseInt(rawMessage.get(2));
	            invite = rawMessage.get(3).equals("0"); // ?
	            moderator = rawMessage.get(3).equals("5") || rawMessage.get(3).equals("6");
	            admin = rawMessage.get(3).equals("10");
        }

        public String getUsername() {
                return username;
        }

        public int getMouseId() {
                return mouseId;
        }

        public boolean isAdmin() {
                return admin;
        }

        public boolean isModerator() {
                return moderator;
        }

        public boolean isInvite() {
                return invite;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new LoginSuccessProcessor();
        }
}
