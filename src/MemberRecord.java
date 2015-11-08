/*
 * Member record to hold members' info
 */
public class MemberRecord extends AbstractUserRecord {

	private boolean active = false;
	private int memNum = 0;

	public MemberRecord(String n, int num, int z, boolean act, String add, String c, String s) {
		this.setName(n);
		this.setMemberNumber(num);
		this.setZipCode(z);
		this.setActive(act);
		this.setAddress(add);
		this.setCity(c);
		this.setState(s);
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
