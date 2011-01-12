package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.MapXMLEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MapXMLResponse;

public class MapXMLProcessor extends CommandProcessor {

        @Override
        public void process(AbstractResponse command, Player player) {
                MapXMLResponse response = (MapXMLResponse) command;
                player.notifyListeners(new MapXMLEvent(response.getMapMaker(), response.getMapXML()));
        }
}
