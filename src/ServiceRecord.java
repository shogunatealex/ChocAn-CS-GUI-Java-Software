import java.io.Serializable;

//Trevor
/**
 * @author Trevor Gentner Hold information of service record.
 *
 */
public class ServiceRecord implements Serializable {
	private String date;
	private String time;
	private int providerNumber;
	private int memberNumber;
	private int serviceCode;
	private String comments;

	public ServiceRecord(String Date, String Time, int ProviderNumber, int MemberNumber, int ServiceCode,
			String Comments) {
		date = Date;
		time = Time;
		providerNumber = ProviderNumber;
		memberNumber = MemberNumber;
		serviceCode = ServiceCode;
		comments = Comments;
	}

	/*
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/*
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/*
	 * @return providerNumber
	 */
	public int getProviderNumber() {
		return providerNumber;
	}

	/*
	 * @return memberNumber
	 */
	public int getMemberNumber() {
		return memberNumber;
	}

	/*
	 * @return serviceCode
	 */
	public int getServiceCode() {
		return serviceCode;
	}

	/*
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}

	public void setDate(String newDate) {
		date = newDate;
	}

	public void setTime(String newTime) {
		time = newTime;
	}

	public void setProviderNumber(int newProviderNumber) {
		providerNumber = newProviderNumber;
	}

	public void setMemberNumber(int newMemberNumber) {
		memberNumber = newMemberNumber;
	}

	public void setServiceCode(int newServiceCode) {
		serviceCode = newServiceCode;
	}

	public void setComments(String newComments) {
		comments = newComments;
	}

}
