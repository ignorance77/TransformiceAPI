package ee.ignorance.transformiceapi;

public enum MagicType {
	Arrow(0),
	SmallBox(1),
	LargeBox(2),
	SmallBoard(3),
	LargeBoard(4),
	Ball(6),
	Trampoline(7),
	Anvil(10),
	RedPoint(11),
	RedLeft(12),
	RedRight(13),
        BluePoint(14),
	BlueRight(15),
	BlueLeft(16),
	CannonUp(17),
	CannonDown(18),
	CannonRight(19),
	CannonLeft(20),
	YellowPoint(22),
	Bomb(23),
	Spirit(24),
	Cheese(25),
	BluePortal(26),
	OrangePortal(27),
	Balloon(28),
	RedBalloon(29),
	GreenBalloon(30),
	YellowBalloon(31),
	Rune(32),
	Snow(34),
        Totem(44);

        private final int value;
        MagicType(int value) {
                this.value = value;
        }

        public int value() {
                return value;
        }
}

