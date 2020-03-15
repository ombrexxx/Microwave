package com.ondrej.microwave.functions;

public interface PresetMicrowaveFunctions {
	
	public static final int MEAT_COEFICIENT = 60;
	
	public static final int VEG_COEFICIENT = 80;
	
	public static final int BREAD_COEFICIENT = 100;
	
	/*
	 * Preset meat function, starts microwave with weight and time preset.
	 */
	String heatMeat(double weight);

	/*
	 * Preset veg function, starts microwave with weight and time preset.
	 */
	String heatVeg(double weight);

	/*
	 * Preset bread function, starts microwave with weight and time preset.
	 */
	String heatBread(double weight);
	
}
