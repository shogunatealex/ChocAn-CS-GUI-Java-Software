import java.io.Serializable;

/**
 * @author Alex Anderson
 * Holds common fields of member and 
 * provider records
 *
 */
public abstract class AbstractUserRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name = "";
	protected int zip = 0;
	protected String address = "";
	protected String city = "";
	protected String state = "";

	public void setName(String n) {
		name = n;
	}

	public void setZipCode(int z) {
		zip = z;
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

	public int getZipCode() {
		return zip;
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
