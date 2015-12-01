//David 
/**
 * Holds status of the system, either interactive or non-interactive. Toggles
 * status.
 * 
 * @author David Glenn
 */
public class SystemStatus {
	private boolean interactive;

	public SystemStatus() {
		interactive = true;
	}

	/**
	 * @return systemStatus
	 */
	public boolean checkMode() {
		return this.interactive;
	}

	/**
	 * Toggle system status.
	 */
	public void setInteractiveMode(boolean mode) {
        interactive = mode;
	}
}
