package states;

import display.SecurityDisplay;
import events.CheckAllZones;
import events.DigitPressed;
import events.EnterPassword;
import events.IncorrectPassword;
import events.PressAway;
import events.PressCancel;
import events.PressMotion;
import events.PressStay;
import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;
import events.ZoneToggled;
import zones.Zone;

/**
 * The context is an observer for the security system and stores the context
 * info for states
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 * 
 *         Code adapted from Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 */
public class SecurityContext {
	private static SecurityContext instance;
	private Zone[] zones = new Zone[5]; // works for up to 5 zones
	private int zoneCounter = 0;
	private static final String PASSWORD = "1234";
	private String password = "";
	private SecurityState currentState;
	private SecurityDisplay display;

	private SecurityContext() {
		instance = this;
		currentState = Ready.instance();
	}

	public static SecurityContext instance() {
		if (instance == null) {
			instance = new SecurityContext();
		}
		return instance;
	}

	public void setDisplay(SecurityDisplay display) {
		this.display = display;
	}

	public int addZone() {
		zones[zoneCounter] = new Zone();
		zoneCounter++;
		return zoneCounter;
	}

	public void changeState(SecurityState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void handleEvent(DigitPressed event) {
		password = password + DigitPressed.instance().getDigit();
		currentState.handleEvent(event);
		// compares entered password when size is the same
		if (password.length() == PASSWORD.length()) {
			if (password.equalsIgnoreCase(PASSWORD)) {
				handleEvent(EnterPassword.instance());
				clearPassword();
			} else {
				handleEvent(IncorrectPassword.instance());
				clearPassword();
			}
		}
	}

	public void handleEvent(ZoneToggled event) {
		boolean allZonesChecked = true;
		zones[ZoneToggled.instance().getZoneNumber() - 1].toggle();
		for (int index = 0; index < zoneCounter; index++) {
			if (!zones[index].isChecked()) {
				allZonesChecked = false;
				break;
			}
		}
		if (allZonesChecked) {
			handleEvent(CheckAllZones.instance());
		} else {
			handleEvent(UncheckZone.instance());
		}
	}

	public void handleEvent(EnterPassword event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(IncorrectPassword event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(CheckAllZones event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(UncheckZone event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressAway event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressCancel event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressMotion event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressStay event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(TimerTicked event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(TimerRanOut event) {
		currentState.handleEvent(event);
	}

	public void showReady() {
		display.showReady();
	}

	public void showNotReady() {
		display.showNotReady();
	}

	public void showSecondsToAway(int seconds) {
		display.showSecondsToAway(seconds);
	}

	public void showSecondsToStay(int seconds) {
		display.showSecondsToStay(seconds);
	}

	public void showSecondsToBreach(int seconds) {
		display.showSecondsToBreach(seconds);
	}

	public void showSecondsToReady(int seconds) {
		display.showSecondsToReady(seconds);
	}

	public void showAway() {
		display.showAway();
	}

	public void showStay() {
		display.showStay();
	}

	public void showBreach() {
		display.showBreach();
	}

	public void showCancel() {
		display.showCancel();
	}

	public void showPassword() {
		display.showPassword(password);
	}

	public void clearPassword() {
		password = "";
	}

}
