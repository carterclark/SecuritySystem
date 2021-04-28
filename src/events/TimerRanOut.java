package events;

/**
 * The class TimerRanOut is invoked when the Time runs out.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class TimerRanOut extends SecurityEvent {
	private static TimerRanOut timerRanOut;

	/**
	 * A singleton representing the event Timer Ran Out.
	 * 
	 * @param value the amount of time left
	 */
	private TimerRanOut() {

	}

	/**
	 * Creates a new instance of the TimerRanOut() object.
	 * 
	 * @return instance returns the instance of TimerRanOut
	 */
	public static TimerRanOut instance() {
		if (timerRanOut == null) {
			timerRanOut = new TimerRanOut();
		}
		return timerRanOut;
	}
}
