package ee.ignorance.transformiceapi.shop;

import ee.ignorance.transformiceapi.shop.Shop.ItemType;

public class Outfit {
	private Shop.Item hat;
	private Shop.Item glasses;
	private Shop.Item muzzle;
	private Shop.Item neckWear;
	private Shop.Item earWear;
	
	private Outfit(Shop.Item hat, Shop.Item glasses, Shop.Item earWear, Shop.Item muzzle, Shop.Item neckWear) {
		if (hat.getType() != Shop.ItemType.None &&
				hat.getKind() != Shop.ItemKind.Hat) {
			throw new IllegalArgumentException("This is not a hat!");
		}
		if (glasses.getType() != Shop.ItemType.None &&
				glasses.getKind() != Shop.ItemKind.Glasses) {
			throw new IllegalArgumentException("This are not glasses!");
		}
		if (muzzle.getType() != Shop.ItemType.None &&
				muzzle.getKind() != Shop.ItemKind.Muzzle) {
			throw new IllegalArgumentException("This is no muzzle!");
		}
		if (neckWear.getType() != Shop.ItemType.None &&
				neckWear.getKind() != Shop.ItemKind.NeckWear) {
			throw new IllegalArgumentException("This is no neck wear!");
		}
		if (earWear.getType() != Shop.ItemType.None &&
				earWear.getKind() != Shop.ItemKind.EarWear) {
			throw new IllegalArgumentException("This is no ear wear!");
		}
		
		this.hat = hat;
		this.glasses = glasses;
		this.muzzle = muzzle;
		this.neckWear = neckWear;
		this.earWear = earWear;
	}
	
	public int getPrice() {
		int result = 0;
		
		if (hat.hasPrice())
			result += hat.getPrice();
		
		if (glasses.hasPrice())
			result += glasses.getPrice();
		
		if (muzzle.hasPrice())
			result += muzzle.getPrice();
		
		if (neckWear.hasPrice())
			result += neckWear.getPrice();
		
		if (earWear.hasPrice())
			result += earWear.getPrice();
		
		return result;
	}
	
	public Shop.Item getEarWear() {
		return earWear;
	}
		
	public static Outfit parse(String data) {
		String[] ids = data.split(",");
		
		int hatId = Integer.valueOf(ids[0]);
		int glassesId = Integer.valueOf(ids[1]);
		if (glassesId > 0)
			glassesId += 100;
		int earWearId = Integer.valueOf(ids[2]);
		if (earWearId > 0)
			earWearId += 200;
		int muzzleId = Integer.valueOf(ids[3]);
		if (muzzleId > 0)
			muzzleId += 300;
		int neckWearId = Integer.valueOf(ids[4]);
		if (neckWearId > 0)
			neckWearId += 400;
		
//		System.out.println("hatId: "+hatId);
//		System.out.println("glassesId: "+glassesId);
//		System.out.println("earWearId: "+earWearId);
//		System.out.println("muzzleId: "+muzzleId);
//		System.out.println("neckWearId: "+neckWearId);
		
		return new Outfit(
				Shop.getItemById(hatId),
				Shop.getItemById(glassesId),
				Shop.getItemById(earWearId),
				Shop.getItemById(muzzleId),
				Shop.getItemById(neckWearId));
	}

	@Override
	public String toString() {
//		return "Outfit [" + earWear + "," + glasses + ","
//		+ hat + "," + muzzle + "," + neckWear + "]";
		
		StringBuilder result = new StringBuilder();
		
		if (hat.getType() != ItemType.None)
			result.append(hat);
		
		if (earWear.getType() != ItemType.None) {
			result.append(", ");
			result.append(earWear);
		}
		if (glasses.getType() != ItemType.None) {
			result.append(", ");
			result.append(glasses);
		}
		if (muzzle.getType() != ItemType.None) {
			result.append(", ");
			result.append(muzzle);
		}
		if (neckWear.getType() != ItemType.None) {
			result.append(", ");
			result.append(neckWear);
		}
		
		return result.toString();
	
	}
	
		
}
