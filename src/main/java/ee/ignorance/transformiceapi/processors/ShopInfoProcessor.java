package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MapXMLEvent;
import ee.ignorance.transformiceapi.protocol.server.Processable;
import ee.ignorance.transformiceapi.protocol.server.ShopInfoResponse;

public class ShopInfoProcessor extends AbstractProcessor<ShopInfoResponse> {

	@Override
	public void process(ShopInfoResponse response, GameConnection connection) {
		PlayerImpl player = connection.getPlayer();
		player.setCheeseInShop(response.getCheeseInShop());
		player.setCurrentOutfit(response.getCurrentOutfit());
		player.setOwnedItems(response.getOwnedItems());
	}

}
