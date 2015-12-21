

public class CharacterType {
	private int type;
	
	public CharacterType() {
		this.type = 1;
	}
	
	public CharacterType(int type) {
		this();
		
		if (type >0 && type < 4) {
			this.type = type;
		}
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String toString() {
		switch (this.type) {
		case 1:
			return "Warrior";
		case 2:
			return "Thief";
		case 3:
			return "Wizard";
		default:
			return "This should never happen";
		}
	}
}
