public class CharacterType {
	private int type;
	
	public CharacterType(int type) {
		if (type >0 && type < 4) {
			this.type = type;
		}
	}
	
	public CharacterType(String type) {
		switch (type) {
		case "Warrior":
			this.type = 1;
			break;
		case "Thief":
			this.type = 2;
			break;
		case "Wizard":
			this.type = 3;
			break;
		default:
			this.type = 1;
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
