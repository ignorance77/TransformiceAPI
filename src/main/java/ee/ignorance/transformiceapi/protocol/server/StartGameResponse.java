package ee.ignorance.transformiceapi.protocol.server;

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
                setModeNext(rawMessage.get(1));
                setText(rawMessage.get(2));
                setGameCode(rawMessage.get(3));

                if (getModeNext().equals("-1")) {   //custom usermade map
                        char separator = (char) 0x02;
                        int index;

                        if (rawMessage.get(4).startsWith("<")) {
                                index = 4;
                        } else {
                                index = 5;
                        }

                        String[] mapData = rawMessage.get(index).split(String.valueOf(separator));
                        setMapXML(mapData[0]);
                        setMapMaker(mapData[1]);
                } else {        //vanilla map
                        setMapMaker(getModeNext());         //store map number as map maker name for vanilla maps
                        setMapXML("");                      //no xml
                }
        }

        public String getModeNext() {
                return modeNext;
        }

        public void setModeNext(String modeNext) {
                this.modeNext = modeNext;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public String getGameCode() {
                return gameCode;
        }

        public void setGameCode(String gameCode) {
                this.gameCode = gameCode;
        }

        public String getMapMaker() {
                return mapMaker;
        }

        public void setMapMaker(String mapMaker) {
                this.mapMaker = mapMaker;
        }

        public String getMapXML() {
                return mapXML;
        }

        public void setMapXML(String mapXML) {
                this.mapXML = mapXML;
        }
}
