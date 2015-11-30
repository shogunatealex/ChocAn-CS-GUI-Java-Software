import java.io.Serializable;

/**
 * Extends AbstractUserRecord. Holds fields of member record.
 * 
 * @author Evan Dwyer
 *
 */
public class MemberRecord extends AbstractUserRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean active = false;
	private int memNum = 0;

	public MemberRecord(String name, int number, int zipcode, boolean active, String address, String city,
			String state) {
		this.setName(name);
		this.setMemberNumber(number);
		this.setZipCode(zipcode);
		this.setActive(active);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
	}

	public String printLine() {
		String result;
		String active;
		if (this.isActive()) {
			active = "active";
		} else {
			active = "Suspended";
		}

		result = String.format("%s %d %d %s %s %s", this.getName(), this.getMemberNumber(), this.getZipCode(), active,
				this.getAddress(), this.getCity(), this.getState());

		return result;
	}

	/**
	 * 
	 * @param num
	 *            memberNumber
	 */
	public void setMemberNumber(int num) {
		memNum = num;
	}

	/**
	 * 
	 * @param a
	 *            status
	 */
	public void setActive(boolean a) {
		active = a;
	}

	/**
	 * @return member memebrNumber
	 */
	public int getMemberNumber() {
		return memNum;
	}

	/**
	 * @return status active or suspended
	 */
	public boolean isActive() {
		return active;
	}
}
