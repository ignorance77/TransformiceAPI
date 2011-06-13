package ee.ignorance.transformiceapi.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shop {
	public enum ItemType {
		None(0,"No Item"),
		
		Helmet(3,"Helmet"),
		Sunhat(5,"Sunhat"),
		StrawHat(2,"Strawhat"),
		TopHat(4,"Tophat"),
		Beanie(1,"Beanie"),
		WhiteFedora(6,"White Fedora"),
		Sunglasses(101,"Sunglasses"),
		Heartglasses(102,"Heartglasses"),
		SoldierHelmet(7,"Soldier Helmet"),
		MiningHat(8,"Mining Hat"),
		LieutenantHat(9, "Lieutenant Hat"),
		Beret(10, "Beret"),
		NinjaHeadband(11, "Ninja Headband"),
		Monocle(104, "Monocle"),
		Horns(12, "Horns"),
		Halo(13, "Halo"),
		VikingHelmet(14, "Viking Helmet"),
		PunkSunglasses(103, "Punk Sunglasses"),
		EyePatch(105, "Eye Patch"),
		BanditMask(15, "Bandit Mask"),
		Mustache(301, "Mustache"),
		Straw(302, "Straw"),
		BowTie(303, "Bow Tie"),
		Pipe(304, "Pipe"),
		PirateHat(16, "Pirate Hat"),
		WitchHat(17, "Witch Hat"),
		Bowler(18, "Bowler"),
		NurseHat(19, "Nurse Hat"),
		PolicemansHat(20, "Policeman's Hat"),
		SantaHat(21, "Santa Hat"),
		PinkBow(201, "Pink Bow"),
		Rose(305, "Rose"),
		ChefsHat(22, "Chef's Hat"),
		BunnyEars(23, "Bunny Ears"),
		PurpleWig(24, "Purple Wig"),
		AussieSlouchHat(25, "Aussie Slouch Hat"),
		PomeloRindHelmet(26, "Pomelo Rind Helmet"),
		ChineseHat(27, "Chinese Hat"),
		TopPonytail(28, "Top Ponytail"),
		UncleSamHat(29, "Uncle Sam Hat"),
		WinterScarf(401, "Winter Scarf"),
		RedBandana(402, "Red Bandana"),
		MargeSimpsonHair(30, "Marge Simpson Hair"),
		PlumberCap(31, "Plumber Cap"),
		SuperSaiyanHair(32, "Super Saiyan Hair"),
		PartyHat(33, "Party Hat"),
		AsterixsWingHelmet(34, "Asterix's Wing Helmet"),
		Crown(35, "Crown"),
		FunkyDreads(36, "Funky Dreads"),
		Afro(37, "Afro"),
		PharaohsHeadpiece(38, "Pharaoh's Headpiece"),
		SnorkelAndMask(106, "Snorkel and Mask"),
		SpiderEarring(202, "Spider Earring"),
		PumpkinHat(39, "Pumpkin Hat"),
		SkullMask(40, "Skull Mask"),
		ReindeerAntlers(41, "Reindeer Antlers"),
		SnowmansHead(42, "Snowman's Head"),
		SantasBeard(403, "Santa's Beard"),
		RedOrnament(203, "Red Ornament"),
		BlondeWig(43, "Blonde Wig"),
		FloralHat(44, "Floral Hat"),
		ElvisPompadour(45, "Elvis Pompadour"),
		TenLiterBambooHat(46, "10 Liter Bamboo Hat"),
		ChieftainsHeaddress(47, "Chieftains Headdress"),
		ThreeDGlasses(107, "3D Glasses"),
		FlowerHairClip(204, "Flower Hair Clip"),
		GreenLightsaber(306, "Green Lightsaber"),
		RedLightsaber(307, "Red Lightsaber"),
		FloralNecklace(404, "Floral Necklace"),
		Glasses(108, "Glasses"),
		UraharasHat(48, "Uraharas Hat"),
		MegamansHelmet(52, "Megaman's Helmet"),
		Headphones(205, "Headphones"),
		AviatorsCap(51, "Aviators Cap"),
		FoolsCap(49, "Fools Cap"),
		Zangetsu(308, "Zangetsu"),
		YoshisEggshell(54, "Yoshi's Eggshell"),
		Deadmau5Hat(50, "Deadmau5 Hat"),
		ViewtifulJoesHelmet(53, "Viewtiful Joes Helmet"),
		GasMask(309, "Gas Mask"),
		EyelinerAndMascara(109, "Eyeliner and Mascara"),
		NeckTie(405, "Neck Tie"),
		HeartEarring(206, "Heart Earring"),
		LeprechaunsHat(55, "Leprechauns Hat"),
		LuckyScarf(406, "Lucky Scarf"),
		FourLeafClover(310, "Four Leaf Clover"),
		FishHat(56, "Fish Hat"),
		CatHat(57, "Cat Hat"),
		FishbowlHat(58, "Fishbowl Hat"),
		FishEarring(207, "Fish Earring"),
		StarfishEarring(208, "Starfish Earring"),
		FishBones(311, "Fishbones"),
		Ribbon(59, "Ribbon"),
		EasterBasketsHat(60, "Easter Basket's Hat"),
		BellNecklace(407, "Bell Necklace"),
		CheeseEarring(209, "Cheese Earring"),
		IchigoHair(61, "Ichigo Hair"),
		LuffysStrawHat(62, "Luffy's Straw Hat"),
		GreenGridGlasses(110, "Green Grid Glasses"),
		SonicHair(63, "Sonic Hair"),
		Fez(64, "Fez"),
		Unknown(-1, "Unknown Item");
		
		private int id;
		private String description;
		
		private ItemType(int id, String description) {
			this.id = id;
			this.description = description;
		}
		
		public static ItemType getById(int id) {
			for (ItemType type : ItemType.values()) {
				if (type.id == id)
					return type;
			}
			return Unknown;
		}
	}
	
	public enum ItemKind {
		Hat(0,"Hat"),
		Glasses(1,"Glasses"),
		EarWear(2,"EarWear"),
		Muzzle(3,"Muzzle"),
		NeckWear(4,"NeckWear");
		
		private int id;
		private String desc;
		
		private ItemKind(int id, String desc) {
			this.id = id;
			this.desc = desc;
		}
		
		public static ItemKind getById(int id) {
			for (ItemKind kind : ItemKind.values()) {
				if (kind.id == id)
					return kind;
			}
			return null;
		}
	}
	
	private static Map<Integer, Item> items = new HashMap<Integer, Item>();
		
	public static class Item {
		
		private static Map<Integer, Item> unknownItems = new HashMap<Integer, Item>();
				
		private int id;
		private int price;
		private String description;
		
		private ItemType type = ItemType.Unknown;
		private ItemKind kind;
		
		public Item(int id, int price) {
			type = ItemType.getById(id);
			this.id = id;
			this.price = price;
			kind = ItemKind.getById(id / 100);
			
			if (kind == null) // should not happen
				throw new IllegalArgumentException("New Item would have had an unknown kind");
			
			if (type == ItemType.Unknown) {
				if (!unknownItems.containsKey(id)) {
					int count = 1;
					for (Item item : unknownItems.values()) {
						if (item.kind == kind) {
							count++;
						}
					}
					this.description = "Unknown"+kind.desc+"-"+count;
					unknownItems.put(id, this);
				}
			} else {
				this.description = type.description;
			}
		}
		public int getId() {
			return id;
		}
		public String getDescription() {
			return description;
		}
		public boolean isBuyable() {
			return (price != 1000000);
		}
		public int getPrice() {
			return price;
		}
		public boolean hasPrice() {
			return (price != -1 && isBuyable());
		}
		public ItemKind getKind() {
			return kind;
		}
		public ItemType getType() {
			return type;
		}
		@Override
		public String toString() {
			return description;
		}
	}

	public static void parse(String data) {	
		for (String line : data.split(";")) {
			String entries[] = line.split(",");
			
			int kind = Integer.valueOf(entries[0]);
			int id = kind * 100 + Integer.valueOf(entries[1]);
			int price = Integer.valueOf(entries[2]);
			
		
			Item item = new Item(id, price);
			items.put(id, item);			
		}
	}
	
	public static Item getItemById(int id) {
		if (items.containsKey(id))
			return items.get(id);
		else
			return new Item(id, -1);
	}
}
