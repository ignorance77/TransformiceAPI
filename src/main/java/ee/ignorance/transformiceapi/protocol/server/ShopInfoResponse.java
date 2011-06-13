package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.ShopInfoProcessor;
import ee.ignorance.transformiceapi.shop.Shop;

public final class ShopInfoResponse implements Processable {
	
	public ShopInfoResponse(List<String> rawMessage) {
		System.out.println("new ShopInfoResponse");
		
		/*for (String s : rawMessage)
			System.out.println("\t\t"+s);*/
		
		String cheeseInShop = rawMessage.get(1);
		
		Shop.parse(rawMessage.get(2));
				
		String[] data = rawMessage.get(3).split(",");
		String currentHat = data[0];
		String currentGlasses = data[1];
		String currentEarWear = data[2];
		String currentMuzzle = data[3];
		String currentNeckWear = data[4];
		
		System.out.printf("(%s,%s,%s,%s,%s)%n", currentHat, currentGlasses, currentEarWear, currentMuzzle, currentNeckWear);
				
		for (String ownedItem : rawMessage.get(4).split(",")) {			
			System.out.println("I own "+ownedItem);
		}
	}
		
	@Override
	public AbstractProcessor getProcessor() {
		return new ShopInfoProcessor();
	}

}
