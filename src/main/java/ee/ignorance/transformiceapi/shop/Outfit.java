package ee.ignorance.transformiceapi.shop;

public class Outfit {
	public final static Outfit NAKED = new Outfit(ee.ignorance.transformiceapi.shop.Hat.None, 
			ee.ignorance.transformiceapi.shop.Glasses.None,
			ee.ignorance.transformiceapi.shop.EarWear.None,
			ee.ignorance.transformiceapi.shop.Muzzle.None, 
			ee.ignorance.transformiceapi.shop.NeckWear.None);
	
	public final Hat Hat;
	public final Glasses Glasses;
	public final Muzzle Muzzle;
	public final EarWear EarWear;
	public final NeckWear NeckWear;
	
	private Outfit(Hat hat, Glasses glasses, EarWear earWear, Muzzle muzzle, NeckWear necKWear) {
		this.Hat = hat;
		this.Glasses = glasses;
		this.EarWear = earWear;
		this.Muzzle = muzzle;
		this.NeckWear = necKWear;
	}
	
	public static Outfit parse(String line) {	
	
		// It's 0 in bootcamp
		if (line.equals("0"))
		{
			return Outfit.NAKED;
		}

		String[] data = line.split(",");
		return new Outfit(
				ee.ignorance.transformiceapi.shop.Hat.getByLocalId(Integer.valueOf(data[0])),
				ee.ignorance.transformiceapi.shop.Glasses.getByLocalId(Integer.valueOf(data[1])),
				ee.ignorance.transformiceapi.shop.EarWear.getByLocalId(Integer.valueOf(data[2])),
				ee.ignorance.transformiceapi.shop.Muzzle.getByLocalId(Integer.valueOf(data[3])),
				ee.ignorance.transformiceapi.shop.NeckWear.getByLocalId(Integer.valueOf(data[4])));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EarWear == null) ? 0 : EarWear.hashCode());
		result = prime * result + ((Glasses == null) ? 0 : Glasses.hashCode());
		result = prime * result + ((Hat == null) ? 0 : Hat.hashCode());
		result = prime * result + ((Muzzle == null) ? 0 : Muzzle.hashCode());
		result = prime * result
				+ ((NeckWear == null) ? 0 : NeckWear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Outfit other = (Outfit) obj;
		if (EarWear == null) {
			if (other.EarWear != null)
				return false;
		} else if (!EarWear.equals(other.EarWear))
			return false;
		if (Glasses == null) {
			if (other.Glasses != null)
				return false;
		} else if (!Glasses.equals(other.Glasses))
			return false;
		if (Hat == null) {
			if (other.Hat != null)
				return false;
		} else if (!Hat.equals(other.Hat))
			return false;
		if (Muzzle == null) {
			if (other.Muzzle != null)
				return false;
		} else if (!Muzzle.equals(other.Muzzle))
			return false;
		if (NeckWear == null) {
			if (other.NeckWear != null)
				return false;
		} else if (!NeckWear.equals(other.NeckWear))
			return false;
		return true;
	}

	public int getPrice() {
		if (!Shop.retrievedPrices())
			return -1;
		
		int result = 0;
		
		if (Shop.canBeBought(Hat))
			result += Shop.getPrice(Hat);

		if (Shop.canBeBought(Glasses))
			result += Shop.getPrice(Glasses);
		
		if (Shop.canBeBought(Muzzle))
			result += Shop.getPrice(Muzzle);
		
		if (Shop.canBeBought(EarWear))
			result += Shop.getPrice(EarWear);
		
		if (Shop.canBeBought(NeckWear))
			result += Shop.getPrice(NeckWear);
		
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("(%s,%s,%s,%s,%s)",Hat, Glasses, Muzzle, EarWear, NeckWear);
	}		
}
