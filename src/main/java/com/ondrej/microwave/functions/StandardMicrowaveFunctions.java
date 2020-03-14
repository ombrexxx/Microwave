package com.ondrej.microwave.functions;

public interface StandardMicrowaveFunctions {

	public static final int QUICK_START_PRESET_TIME = 60;
	
	/*
	 * Set the timer.
	 */
	String setTimer(int time);

	/*
	 * Start the microwave with preset time.
	 */
	String quickStart();

	/*
	 * Start the microwave.
	 */
	String start();

	/*
	 * Pause the microwave.
	 */
	String pause();

	/*
	 * Resume the start of the microwave.
	 */
	String resume();

	/*
	 * Stop the microwave.
	 */
	String stop();

}