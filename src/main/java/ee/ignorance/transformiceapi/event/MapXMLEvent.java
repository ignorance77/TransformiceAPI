package ee.ignorance.transformiceapi.event;

public class MapXMLEvent implements Event {

        private String mapMaker;
        private String mapXML;

        public MapXMLEvent(String mapMaker, String mapXML) {
                this.mapMaker = mapMaker;
                this.mapXML = mapXML;
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
