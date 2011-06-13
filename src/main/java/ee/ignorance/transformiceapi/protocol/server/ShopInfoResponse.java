package ee.ignorance.transformiceapi.protocol.server;

import java.util.ArrayList;
import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.ShopInfoProcessor;
import ee.ignorance.transformiceapi.shop.Item;
import ee.ignorance.transformiceapi.shop.Outfit;
import ee.ignorance.transformiceapi.shop.Shop;

public final class ShopInfoResponse implements Processable {
	private int cheeseInShop;
	private Outfit currentOutfit;
	private List<Item> ownedItems = new ArrayList<Item>();
	
	public ShopInfoResponse(List<String> rawMessage) {	
		cheeseInShop = Integer.valueOf(rawMessage.get(1));
		
		Shop.parse(rawMessage.get(2));		
		
		currentOutfit = Outfit.parse(rawMessage.get(3));
		
		for (String ownedItem : rawMessage.get(4).split(",")) {			
			ownedItems.add(Shop.getItem(Integer.valueOf(ownedItem)));
		}
	}
	
	public int getCheeseInShop() {
		return cheeseInShop;
	}
	
	public Outfit getCurrentOutfit() {
		return currentOutfit;
	}
	
	public List<Item> getOwnedItems() {
		return ownedItems;
	}
		
	@Override
	public AbstractProcessor getProcessor() {
		return new ShopInfoProcessor();
	}

}
