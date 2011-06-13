package ee.ignorance.transformiceapi.shop;

import java.util.HashMap;
import java.util.Map;

public class Shop {
	
	private final static int UNBUYABLE_ITEM = 1000000;
	
	private final static Map<Integer, Item> items = new HashMap<Integer, Item>();
	
	private final static Map<Integer, Item> newUnknownItems = new HashMap<Integer, Item>();
	
	private final static Map<Integer, Integer> itemPrices = new HashMap<Integer, Integer>();
	
	static {
		for (Item item : Hat.values()) {
			if (item.getId() > 0)
				items.put(item.getId(), item);
		}
		for (Item item : Glasses.values()) {
			if (item.getId() > 0)
				items.put(item.getId(), item);
		}
		for (Item item : Muzzle.values()) {
			if (item.getId() > 0)
				items.put(item.getId(), item);
		}
		for (Item item : EarWear.values()) {
			if (item.getId() > 0)
				items.put(item.getId(), item);
		}
		for (Item item : NeckWear.values()) {
			if (item.getId() > 0)
				items.put(item.getId(), item);
		}
	}
	
	public static void parse(String data) {
		
		for (String line : data.split(";")) {
			String entries[] = line.split(",");
			
			int kind = Integer.valueOf(entries[0]);
			int localId = Integer.valueOf(entries[1]);
			int price = Integer.valueOf(entries[2]);
			
			int id = (kind * 100) + localId;
			
			Item item = items.get(id);
			
			if (item == null) {
				item = getNewUnknownItemByKind(kind);
				items.put(id, item);
				newUnknownItems.put(id, item);
			}
			
			itemPrices.put(id, price);
		}
	}
	
	public static boolean retrievedPrices() {
		return itemPrices.size() != 0;
	}
	
	public static boolean hasPrice(Item item) {
		return itemPrices.containsKey(item.getId());
	}
	
	public static boolean canBeBought(Item item) {
		return hasPrice(item) && (itemPrices.get(item.getId()) != UNBUYABLE_ITEM);
	}
	
	public static Item getItem(int id) {
		return items.get(id);
	}
	
	public static void addItem(int id, Item item) {
		Item result = getItem(id);
		
		if (result != null)
			return;
		
		items.put(id, item);
		newUnknownItems.put(id, item);
	}
	
	private static void addItem(int id, int kind) {
		addItem(id, getNewUnknownItemByKind(kind));
	}
	
	public static int getPrice(Item item) {
		if (!retrievedPrices())
			throw new IllegalStateException("You need to retrieve the prices before you can access them!");
		
		if (!canBeBought(item))
			throw new IllegalStateException("Check if the Item can be bought before you retrieve the price!");
		
		return itemPrices.get(item.getId());
	}
	
	private static Item getNewUnknownItemByKind(int kind) {
	
		switch (kind) {
			case 0:
				return Hat.NewUnknown;
			case 1:
				return Glasses.NewUnknown;
			case 2:
				return EarWear.NewUnknown;
			case 3:
				return Muzzle.NewUnknown;
			case 4:
				return NeckWear.NewUnknown;
			default:
				throw new IllegalArgumentException("I only know 5 different item kinds");
		}
	}
	
}
