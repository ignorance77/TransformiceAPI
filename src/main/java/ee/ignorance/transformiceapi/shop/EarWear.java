package ee.ignorance.transformiceapi.shop;

import java.util.HashMap;
import java.util.Map;

public enum EarWear implements Item {
	NewUnknown(-1,"New Unknown EarWear"),
	None(0, "None"),
	
	PinkBow(201, "Pink Bow"),
	SpiderEarring(202, "Spider Earring"),
	RedOrnament(203, "Red Ornament"),
	FlowerHairClip(204, "Flower Hair Clip"),
	Headphones(205, "Headphones"),
	HeartEarring(206, "Heart Earring"),
	FishEarring(207, "Fish Earring"),
	StarfishEarring(208, "Starfish Earring"),
	CheeseEarring(209, "Cheese Earring");
	
	private int id;
	private String desc;
	
	private static final Map<Integer, EarWear> map = new HashMap<Integer, EarWear>();
	
	static {
		for (EarWear earWear : values())
			map.put(earWear.id, earWear);
	}
	
	private EarWear(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	@Override
	public int getId() {
		return id;
	}

	public static EarWear getById(int id) {
		EarWear result = map.get(id);
		if (result == null)
			return NewUnknown;
		return result;
	}

	public static EarWear getByLocalId(int localId) {
		return getById(localId != 0 ? localId + 200 : localId); 
	}
	
	@Override
	public String toString() {
		return desc;
	}

}
