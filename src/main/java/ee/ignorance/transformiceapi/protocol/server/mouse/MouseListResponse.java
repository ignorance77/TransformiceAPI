package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseListProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

import java.util.ArrayList;
import java.util.List;

public class MouseListResponse extends AbstractResponse {

        private List<Mouse> mice;

        public MouseListResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                mice = new ArrayList<Mouse>();
                for (int i = 1; i < rawMessage.size(); i++) {
                        String[] mouseData = rawMessage.get(i).split("#");
                        Mouse mouse = Mouse.parse(mouseData);
                        mice.add(mouse);
                }
        }

        public List<Mouse> getMice() {
                return mice;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseListProcessor();
        }
}
