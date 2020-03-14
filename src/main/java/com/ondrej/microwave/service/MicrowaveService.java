package com.ondrej.microwave.service;

import com.ondrej.microwave.app.State;
import com.ondrej.microwave.functions.DoorFunctions;
import com.ondrej.microwave.functions.PresetMicrowaveFunctions;
import com.ondrej.microwave.functions.StandardMicrowaveFunctions;

public interface MicrowaveService extends StandardMicrowaveFunctions, PresetMicrowaveFunctions, DoorFunctions {

	/*
	 * Saving state of microwave to the database.
	 */
	void saveStateOfMicrowave(State currentState, boolean doorClosed, int time, double weight);
	
}