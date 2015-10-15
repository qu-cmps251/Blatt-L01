public class Player {
	private String name;
	private CharacterType type;
	private int currHp;
	private int gold;

	public Player() {
		this.currHp = 20;
		this.gold = 0;
	}

	public Player(String name) {
		this();
		this.name = name;
	}

	public Player(String name, int charType) {
		this(name);
		this.type = new CharacterType(charType);
	}

	public Player(String name, String charType) {
		this(name);
		this.type = new CharacterType(charType);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CharacterType getType() {
		return type;
	}

	public String getTypeString() {
		return type.toString();
	}

	public int setType(int numType) {
		if (numType < 1 || numType > 3) {
			return -1;
		} else {
			type = new CharacterType(numType);
			return type.getType();
		}
	}

	public int getCurrHp() {
		return currHp;
	}

	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String toString() {
		return String.format("Name: %s\nType: %s\nHP: %d\nGold: %d\n",
				this.name, this.type, this.currHp, this.gold);
	}
}
