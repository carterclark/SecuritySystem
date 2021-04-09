package controller.events;

public class PressAway extends SystemEvent {
	private static PressAway instance;

	/**
	 * Private constructor for singleton
	 * 
	 */
	private PressAway() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the only instance
	 */
	public static PressAway instance() {
		if (instance == null) {
			instance = new PressAway();
		}
		return instance;
	}
}
