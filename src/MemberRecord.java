/*
 * Member record to hold members' info
 */
public class MemberRecord {
	private String name = "";
	private int memNum = 0;
	private int zip = 0;
	boolean active = false;
	private String address = "";
	private String city = "";
	private String state = "";

	public MemberRecord(String n, int num, int z, boolean act, String add, String c, String s) {
		this.setName(n);
		this.setMemberNumber(num);
		this.setZipCode(z);
		this.setActive(act);
		this.setAddress(add);
		this.setCity(c);
		this.setState(s);
	}

	public void setName(String n) {
		name = n;
	}

	public void setMemberNumber(int num) {
		memNum = num;
	}

	public void setZipCode(int z) {
		zip = z;
	}

	public void setActive(boolean a) {
		active = a;
	}

	public void setAddress(String add) {
		address = add;
	}

	public void setCity(String c) {
		city = c;
	}

	public void setState(String s) {
		state = s;
	}

	public String getName() {
		return name;
	}

	public int getMemberNumber() {
		return memNum;
	}

	public int getZipCode() {
		return zip;
	}

	public boolean isActive() {
		return active;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
}
