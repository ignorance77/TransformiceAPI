package ee.ignorance.transformiceapi.shop;

import java.util.HashMap;
import java.util.Map;

public enum NeckWear implements Item {
	NewUnknown(-1,"New Unknown NeckWear"),
	None(0, "None"),
	
	WinterScarf(401, "Winter Scarf"),
	RedBandana(402, "Red Bandana"),
	SantasBeard(403, "Santa's Beard"),
	FloralNecklace(404, "Floral Necklace"),
	NeckTie(405, "Neck Tie"),
	LuckyScarf(406, "Lucky Scarf"),
	BellNecklace(407, "Bell Necklace");
	
	private int id;
	private String desc;
	
	private static final Map<Integer, NeckWear> map = new HashMap<Integer, NeckWear>();
	
	static {
		for (NeckWear neckWear : values())
			map.put(neckWear.id, neckWear);
	}
	
	private NeckWear(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	@Override
	public int getId() {
		return id;
	}
	

	public static NeckWear getById(int id) {
		NeckWear result = map.get(id);
		if (result == null)
			return NewUnknown;
		return result;
	}

	public static NeckWear getByLocalId(int localId) {
		return getById(localId != 0 ? localId + 400 : localId); 
	}

	@Override
	public String toString() {
		return desc;
	}
}
