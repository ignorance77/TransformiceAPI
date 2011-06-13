package ee.ignorance.transformiceapi.shop;

import java.util.HashMap;
import java.util.Map;

public enum Hat implements Item {
	NewUnknown(-1,"New Unknown Hat"),
	None(0, "None"),
	
	Helmet(3,"Helmet"),
	Sunhat(5,"Sunhat"),
	StrawHat(2,"Strawhat"),
	TopHat(4,"Tophat"),
	Beanie(1,"Beanie"),
	WhiteFedora(6,"White Fedora"),
	SoldierHelmet(7,"Soldier Helmet"),
	MiningHat(8,"Mining Hat"),
	LieutenantHat(9, "Lieutenant Hat"),
	Beret(10, "Beret"),
	NinjaHeadband(11, "Ninja Headband"),
	Horns(12, "Horns"),
	Halo(13, "Halo"),
	VikingHelmet(14, "Viking Helmet"),
	BanditMask(15, "Bandit Mask"),
	PirateHat(16, "Pirate Hat"),
	WitchHat(17, "Witch Hat"),
	Bowler(18, "Bowler"),
	NurseHat(19, "Nurse Hat"),
	PolicemansHat(20, "Policeman's Hat"),
	SantaHat(21, "Santa Hat"),
	PinkBow(201, "Pink Bow"),
	ChefsHat(22, "Chef's Hat"),
	BunnyEars(23, "Bunny Ears"),
	PurpleWig(24, "Purple Wig"),
	AussieSlouchHat(25, "Aussie Slouch Hat"),
	PomeloRindHelmet(26, "Pomelo Rind Helmet"),
	ChineseHat(27, "Chinese Hat"),
	TopPonytail(28, "Top Ponytail"),
	UncleSamHat(29, "Uncle Sam Hat"),
	MargeSimpsonHair(30, "Marge Simpson Hair"),
	PlumberCap(31, "Plumber Cap"),
	SuperSaiyanHair(32, "Super Saiyan Hair"),
	PartyHat(33, "Party Hat"),
	AsterixsWingHelmet(34, "Asterix's Wing Helmet"),
	Crown(35, "Crown"),
	FunkyDreads(36, "Funky Dreads"),
	Afro(37, "Afro"),
	PharaohsHeadpiece(38, "Pharaoh's Headpiece"),
	PumpkinHat(39, "Pumpkin Hat"),
	SkullMask(40, "Skull Mask"),
	ReindeerAntlers(41, "Reindeer Antlers"),
	SnowmansHead(42, "Snowman's Head"),
	BlondeWig(43, "Blonde Wig"),
	FloralHat(44, "Floral Hat"),
	ElvisPompadour(45, "Elvis Pompadour"),
	TenLiterBambooHat(46, "10 Liter Bamboo Hat"),
	ChieftainsHeaddress(47, "Chieftains Headdress"),
	UraharasHat(48, "Uraharas Hat"),
	MegamansHelmet(52, "Megaman's Helmet"),
	AviatorsCap(51, "Aviators Cap"),
	FoolsCap(49, "Fools Cap"),
	YoshisEggshell(54, "Yoshi's Eggshell"),
	Deadmau5Hat(50, "Deadmau5 Hat"),
	ViewtifulJoesHelmet(53, "Viewtiful Joes Helmet"),
	LeprechaunsHat(55, "Leprechauns Hat"),
	FishHat(56, "Fish Hat"),
	CatHat(57, "Cat Hat"),
	FishbowlHat(58, "Fishbowl Hat"),
	Ribbon(59, "Ribbon"),
	EasterBasketsHat(60, "Easter Basket's Hat"),
	IchigoHair(61, "Ichigo Hair"),
	LuffysStrawHat(62, "Luffy's Straw Hat"),
	SonicHair(63, "Sonic Hair"),
	Fez(64, "Fez");
	
	private int id;
	private String desc;
	
	private static final Map<Integer, Hat> map = new HashMap<Integer, Hat>();
	
	static {
		for (Hat hat : values())
			map.put(hat.id, hat);
	}
	
	private Hat(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	@Override
	public int getId() {
		return id;
	}

	public static Hat getById(int id) {
		Hat result = map.get(id);
		if (result == null)
			return NewUnknown;
		return result;
	}

	public static Hat getByLocalId(int localId) {
		return getById(localId); 
	}
	
	@Override
	public String toString() {
		return desc;
	}
	
}
