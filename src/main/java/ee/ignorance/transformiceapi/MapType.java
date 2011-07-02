package ee.ignorance.transformiceapi;

public enum MapType {
	Vanilla,
	Custom,
	Permanent,
	P2,
	Bootcamp,
	Deleted;

	public static MapType getType(int code) {
		if (code == 1) {
			return MapType.Permanent;
		}
		if (code == 2) {
			return MapType.P2;
		}
		if (code == 3) {
			return MapType.Bootcamp;
		}
		if (code == 44) {
			return MapType.Deleted;
		}

		return MapType.Custom;
	}
}
