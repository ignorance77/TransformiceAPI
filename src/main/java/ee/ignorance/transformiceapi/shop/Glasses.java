package ee.ignorance.transformiceapi.shop;

import java.util.HashMap;
import java.util.Map;

public enum Glasses implements Item {
	NewUnknown(-1,"New Unknown Glasses"),
	None(0, "None"),
	
	Sunglasses(101,"Sunglasses"),
	Heartglasses(102,"Heartglasses"),
	Monocle(104, "Monocle"),
	PunkSunglasses(103, "Punk Sunglasses"),
	EyePatch(105, "Eye Patch"),
	SnorkelAndMask(106, "Snorkel and Mask"),
	ThreeDGlasses(107, "3D Glasses"),
	Glasses(108, "Glasses"),
	EyelinerAndMascara(109, "Eyeliner and Mascara"),
	GreenGridGlasses(110, "Green Grid Glasses");
	
	private int id;
	private String desc;
	
	private static final Map<Integer, Glasses> map = new HashMap<Integer, Glasses>();
	
	static {
		for (Glasses glasses : values())
			map.put(glasses.id, glasses);
	}
	
	private Glasses(int id, String desc) {
		this.id = id;
		this.desc = desc;
		
		
	}

	@Override
	public int getId() {
		return id;
	}

	public static Glasses getById(int id) {	
		Glasses result = map.get(id);
		if (result == null)
			return NewUnknown;
		return result;
	}

	public static Glasses getByLocalId(int localId) {
		return getById(localId != 0 ? localId + 100 : localId); 
	}
	
	@Override
	public String toString() {
		return desc;
	}

}
