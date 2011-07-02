package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.StartGameResponseProcessor;
import ee.ignorance.transformiceapi.MapType;

public final class StartGameResponse implements Processable {

        private String modeNext;
        private String text;
        private String gameCode;
        private String mapXML;
        private String mapMaker;
        private MapType mapType;

        public StartGameResponse(List<String> rawMessage) {
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
	                    mapType = MapType.getType(Integer.parseInt(mapData[2]));
	            } else {        //vanilla map
	                    mapMaker = getModeNext();         //store map number as map maker name for vanilla maps
	                    mapXML = "";                      //no xml
	                    mapType = MapType.Vanilla;
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

        public MapType getMapType() {
                return mapType;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new StartGameResponseProcessor();
        }
}
