//David 
public class SystemStatus {
	private boolean interactive;
	
	public SystemStatus(){
		interactive = true;
	}
	
	public boolean checkMode(){
		return this.interactive;
	}
	
	public void toggleInteractiveMode(){
		if(this.interactive){
			this.interactive=false;
		}
		else 
			this.interactive=true;
	}
}
