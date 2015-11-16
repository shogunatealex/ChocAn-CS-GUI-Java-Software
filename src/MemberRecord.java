import java.io.Serializable;
//Alex
/*
 * Member record to hold members' info
 */
public class MemberRecord extends AbstractUserRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean active = false;
	private int memNum = 0;

	public MemberRecord(String name, int number, int zipcode, boolean active, String address, String city, String state) {
		this.setName(name);
		this.setMemberNumber(number);
		this.setZipCode(zipcode);
		this.setActive(active);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
	}

	public void setMemberNumber(int num) {
		memNum = num;
	}

	public void setActive(boolean a) {
		active = a;
	}

	public int getMemberNumber() {
		return memNum;
	}

	public boolean isActive() {
		return active;
	}
}
