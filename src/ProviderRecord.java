
public class ProviderRecord extends AbstractUserRecord {
	
	private int provNum;
	
	public ProviderRecord(String n, int num, int z, int pNum, String add, String c, String s) {
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

	public int getProviderNumber() {
		return provNum;
	}
}
