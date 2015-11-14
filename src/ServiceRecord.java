import java.io.Serializable;

public class ServiceRecord implements Serializable{
    private String date;
    private String time;
    private int providerNumber;
    private int memberNumber;
    private int serviceCode;
    private String comments;
    
	public ServiceRecord(String Date, String Time, int ProviderNumber, int MemberNumber, int ServiceCode, String Comments) {
        date = Date;
        time = Time;
        providerNumber = ProviderNumber;
        memberNumber = MemberNumber;
        serviceCode = ServiceCode;
        comments = Comments;
    }
	public String getDate(){return date;}
	public String getTime(){return time;}
	public int getProviderNumber(){return providerNumber;}
	public int getMemberNumber(){return memberNumber;}
	public int getServiceCode(){return serviceCode;}
	public String getComments(){return comments;}
	
	public void setDate(String newDate){date = newDate;}
	public void setTime(String newTime){time = newTime;}
	public void setProviderNumber(int newProviderNumber){providerNumber = newProviderNumber;}
	public void setMemberNumber(int newMemberNumber){memberNumber = newMemberNumber;}
	public void setServiceCode(int newServiceCode){serviceCode = newServiceCode;}
	public void setComments(String newComments){comments = newComments;}
	
}
