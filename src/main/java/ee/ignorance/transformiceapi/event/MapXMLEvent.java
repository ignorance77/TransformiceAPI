package ee.ignorance.transformiceapi.event;

public class MapXMLEvent implements Event<MapXMLListener> {

        private String mapMaker;
        private String mapXML;

        public MapXMLEvent(String mapMaker, String mapXML) {
                this.mapMaker = mapMaker;
                this.mapXML = mapXML;
        }

        public String getMapMaker() {
                return mapMaker;
        }

        public String getMapXML() {
                return mapXML;
        }

        @Override
        public void notifyListener(MapXMLListener listener) {
                listener.mapXMLReceived(mapMaker, mapXML);
        }

      
}
