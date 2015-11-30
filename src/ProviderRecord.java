import java.io.Serializable;

/**
 * Extends AbstractUserRecord. Holds fields for provider record.
 * 
 * @author Evan Dwyer
 *
 */
public class ProviderRecord extends AbstractUserRecord implements Serializable {

	private int provNum;

	/**
	 * 
	 * @param n
	 *            name
	 * @param z
	 *            zipCode
	 * @param pNum
	 *            providerNumber
	 * @param add
	 *            address
	 * @param c
	 *            city
	 * @param s
	 *            state
	 */
	public ProviderRecord(String n, int pNum, int z, String add, String c, String s) {
		this.setName(n);
		this.setZipCode(z);
		this.setProviderNumber(pNum);
		this.setAddress(add);
		this.setCity(c);
		this.setState(s);
	}

	public String printLine() {
		String result;
		result = String.format("%s %d %d %s %s %s", this.getName(), this.zip, this.provNum, this.address, this.city,
				this.state);
		return result;
	}

	/**
	 * 
	 * @param num
	 *            providerNumber
	 */
	public void setProviderNumber(int num) {
		provNum = num;
	}

	/**
	 * @return providerNumber
	 */
	public int getProviderNumber() {
		return provNum;
	}
}
