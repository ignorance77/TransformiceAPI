package ee.ignorance.transformiceapi.shop;

import java.util.HashMap;
import java.util.Map;

public enum Muzzle implements Item {
	NewUnknown(-1,"New Unknown Muzzle"),
	None(0, "None"),
	
	Mustache(301, "Mustache"),
	Straw(302, "Straw"),
	BowTie(303, "Bow Tie"),
	Pipe(304, "Pipe"),
	Rose(305, "Rose"),
	GreenLightsaber(306, "Green Lightsaber"),
	RedLightsaber(307, "Red Lightsaber"),
	Zangetsu(308, "Zangetsu"),
	GasMask(309, "Gas Mask"),
	FourLeafClover(310, "Four Leaf Clover"),
	FishBones(311, "Fishbones");
	
	private int id;
	private String desc;
	
	private static final Map<Integer, Muzzle> map = new HashMap<Integer, Muzzle>();
	
	static {
		for (Muzzle muzzle : values())
			map.put(muzzle.id, muzzle);
	}
	
	private Muzzle(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	@Override
	public int getId() {
		return id;
	}

	public static Muzzle getById(int id) {
		Muzzle result = map.get(id);
		if (result == null)
			return NewUnknown;
		return result;
	}

	public static Muzzle getByLocalId(int localId) {
		return getById(localId != 0 ? localId + 300 : localId); 
	}
	
	@Override
	public String toString() {
		return desc;
	}

}
