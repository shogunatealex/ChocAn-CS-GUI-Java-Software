import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProviderDirectory {
	private int sNumber;
	private String Service;
	private double cost;

	public ProviderDirectory(int sNumbers, String Services, double costs) {
		this.sNumber = sNumbers;
		this.Service = Services;
		this.cost = costs;
	}

	public double get_Cost() {
		return this.cost;
	}

	public void setCost(double newCost) {
		this.cost = newCost;
	}

	public String get_Service() {
		return this.Service;
	}

	public void set_Service(String newService) {
		this.Service = newService;
	}

	public int get_sNumber() {
		return this.sNumber;
	}

	public void set_sNumber(int num) {
		this.sNumber = num;
	}
	
	public String getString(){
		String result = String.format("%s\t\t%15s\t\t%15s", this.get_sNumber(),this.get_Service(),this.get_Cost());
		return result;
	}

}
