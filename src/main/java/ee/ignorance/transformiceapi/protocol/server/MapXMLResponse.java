package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class MapXMLResponse extends AbstractResponse {

        private String mapXML;
        private String mapMaker;

        public MapXMLResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                if (rawMessage.get(1).equals("-1")) {   //custom usermade map
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
                        setMapMaker(rawMessage.get(1));         //store map number as map maker name for vanilla maps
                        setMapXML("");
                }
        }

        public String getMapXML() {
                return mapXML;
        }

        public void setMapXML(String MapXML) {
                this.mapXML = MapXML;
        }

        public String getMapMaker() {
                return mapMaker;
        }

        public void setMapMaker(String mapMaker) {
                this.mapMaker = mapMaker;
        }
}
