import java.io.Serializable;

/**
 * @author Evan Dwyer Extends AbstractUserRecord. Holds fields for provider
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
	
	public String printLine(){
		String result;
		result = String.format("%s %d %d %s %s %s", 
				this.getName(),this.zip,this.provNum,this.address, this.city,this.state);
		return result;
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
