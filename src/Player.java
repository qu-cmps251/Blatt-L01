
public class Player {
	private String name;
	private int charType;
	
	public Player(String name, int charType) {
		this.name = name;
		this.charType = charType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCharType() {
		return charType;
	}
	public void setCharType(int charType) {
		this.charType = charType;
	}

	public String getCharTypeString() {
		switch (this.charType) {
		case 1:
			return "Warrior";
		case 2:
			return "Thief";
		case 3:
			return "Mage";
		case 4:
			return "Sharpshooter";
		}
		// This should never occur
		return "Invalid";
	}
	
}
