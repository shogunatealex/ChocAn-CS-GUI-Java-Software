import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

//Trevor
/**
 * @author Trevor Gentner Provider directory information.
 *
 */
public class ProviderDirectory implements Serializable {
	private int sNumber;
	private String Service;
	private double cost;

	public ProviderDirectory(int sNumbers, String Services, double costs) {
		this.sNumber = sNumbers;
		this.Service = Services;
		this.cost = costs;
	}

	/*
	 * @return cost
	 */
	public double get_Cost() {
		return this.cost;
	}

	public void setCost(double newCost) {
		this.cost = newCost;
	}

	/*
	 * @return serviceName
	 */
	public String get_Service() {
		return this.Service;
	}

	public void set_Service(String newService) {
		this.Service = newService;
	}

	/*
	 * @return serviceCode
	 */
	public int get_sNumber() {
		return this.sNumber;
	}

	public void set_sNumber(int num) {
		this.sNumber = num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return providerDirectory string representation.
	 */
	@Override
	public String toString() {
		String result = String.format("%s\t\t%15s\t\t%15s", this.get_sNumber(), this.get_Service(), this.get_Cost());
		return result;
	}

}
