package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.MapType;

public class MapXMLEvent implements Event<MapXMLListener> {

        private String mapMaker;
        private String mapXML;
        private MapType mapType;

        public MapXMLEvent(String mapMaker, String mapXML, MapType mapType) {
                this.mapMaker = mapMaker;
                this.mapXML = mapXML;
                this.mapType = mapType;
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
        public void notifyListener(MapXMLListener listener) {
                listener.mapXMLReceived(mapMaker, mapXML, mapType);
        }

      
}
