import java.io.Serializable;

/**
 * @author Evan Dwyer
 * Holds common fields of member and 
 * provider records
 *
 */
public abstract class AbstractUserRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String name = "";
	protected int zip = 0;
	protected String address = "";
	protected String city = "";
	protected String state = "";
/**
 * @param n name
 */
	public void setName(String n) {
		name = n;
	}
/**
 * 
 * @param z zipCode
 */
	public void setZipCode(int z) {
		zip = z;
	}
/**
 * 
 * @param add address
 */
	public void setAddress(String add) {
		address = add;
	}
/**
 * 
 * @param c city
 */
	public void setCity(String c) {
		city = c;
	}
/**
 * 
 * @param s state
 */
	public void setState(String s) {
		state = s;
	}
/**
 * @return name
 */
	public String getName() {
		return name;
	}
	/**
	 * @return zipCode
	 */
	public int getZipCode() {
		return zip;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}
}
