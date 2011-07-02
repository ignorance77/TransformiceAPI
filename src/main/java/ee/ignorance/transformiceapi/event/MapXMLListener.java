package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.MapType;

public interface MapXMLListener {

        void mapXMLReceived(String mapMaker, String mapXML, MapType mapType);
}
