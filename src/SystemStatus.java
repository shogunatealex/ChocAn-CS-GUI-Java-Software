//David 
/**
 * @author David Glenn Holds status of the system, either interactive or
 *         non-interactive. Toggles status.
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
	public void toggleInteractiveMode() {
		if (this.interactive) {
			this.interactive = false;
		} else
			this.interactive = true;
	}
}
