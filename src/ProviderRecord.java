import java.io.Serializable;

/**
 * @author Alex Anderson Extends AbstractUserRecord. Holds fields for provider
 *         record.
 *
 */
public class ProviderRecord extends AbstractUserRecord implements Serializable {

	private int provNum;

	public ProviderRecord(String n, int z, int pNum, String add, String c, String s) {
		this.setName(n);
		this.setZipCode(z);
		this.setProviderNumber(pNum);
		this.setAddress(add);
		this.setCity(c);
		this.setState(s);
	}

	public void setProviderNumber(int num) {
		provNum = num;
	}

	/*
	 * @return providerNumber
	 */
	public int getProviderNumber() {
		return provNum;
	}
}
