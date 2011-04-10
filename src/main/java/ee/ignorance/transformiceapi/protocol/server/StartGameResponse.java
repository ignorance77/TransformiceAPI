package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.StartGameResponseProcessor;

import java.util.List;

public class StartGameResponse extends AbstractResponse {

        private String modeNext;
        private String text;
        private String gameCode;
        private String mapXML;
        private String mapMaker;

        public StartGameResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                modeNext = rawMessage.get(1);
                text = rawMessage.get(2);
                gameCode = rawMessage.get(3);

                if (getModeNext().equals("-1")) {   //custom usermade map
                        char separator = (char) 0x02;
                        int index;

                        if (rawMessage.get(4).startsWith("<")) {
                                index = 4;
                        } else {
                                index = 5;
                        }

                        String[] mapData = rawMessage.get(index).split(String.valueOf(separator));
                        mapXML = mapData[0];
                        mapMaker = mapData[1];
                } else {        //vanilla map
                        mapMaker = getModeNext();         //store map number as map maker name for vanilla maps
                        mapXML = "";                      //no xml
                }
        }

        public String getModeNext() {
                return modeNext;
        }

        public String getText() {
                return text;
        }

        public String getGameCode() {
                return gameCode;
        }

        public String getMapMaker() {
                return mapMaker;
        }

        public String getMapXML() {
                return mapXML;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new StartGameResponseProcessor();
        }
}
