import java.io.Serializable;

import java.util.Comparator;

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

	/**
	 * Initialize service record
	 * 
	 * @param Date
	 * @param Time
	 * @param ProviderNumber
	 * @param MemberNumber
	 * @param ServiceCode
	 * @param Comments
	 */
	public ServiceRecord(String Date, String Time, int ProviderNumber, int MemberNumber, int ServiceCode,
			String Comments) {
		date = Date;
		time = Time;
		providerNumber = ProviderNumber;
		memberNumber = MemberNumber;
		serviceCode = ServiceCode;
		comments = Comments;
	}

	public String printLine() {
		String result;

		result = String.format("%s %s %d %d %d %s", this.date, this.time, this.providerNumber, this.memberNumber,
				this.serviceCode, this.comments);

		return result;
	}

	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return providerNumber
	 */
	public int getProviderNumber() {
		return providerNumber;
	}

	/**
	 * @return memberNumber
	 */
	public int getMemberNumber() {
		return memberNumber;
	}

	/**
	 * @return serviceCode
	 */
	public int getServiceCode() {
		return serviceCode;
	}

	/**
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * 
	 * @param newDate
	 */
	public void setDate(String newDate) {
		date = newDate;
	}

	/**
	 * 
	 * @param newTime
	 */
	public void setTime(String newTime) {
		time = newTime;
	}

	/**
	 * 
	 * @param newProviderNumber
	 */
	public void setProviderNumber(int newProviderNumber) {
		providerNumber = newProviderNumber;
	}

	/**
	 * 
	 * @param newMemberNumber
	 */
	public void setMemberNumber(int newMemberNumber) {
		memberNumber = newMemberNumber;
	}

	/**
	 * 
	 * @param newServiceCode
	 */
	public void setServiceCode(int newServiceCode) {
		serviceCode = newServiceCode;
	}

	/**
	 * 
	 * @param newComments
	 */
	public void setComments(String newComments) {
		comments = newComments;
	}
	

}
