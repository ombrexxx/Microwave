package com.ondrej.microwave.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ondrej.microwave.app.Microwave;
import com.ondrej.microwave.app.State;
import com.ondrej.microwave.dao.MicrowaveStateRepository;
import com.ondrej.microwave.entity.MicrowaveState;
import com.ondrej.microwave.functions.PresetMicrowaveFunctions;
import com.ondrej.microwave.functions.StandardMicrowaveFunctions;

@Service
public class MicrowaveServiceImpl implements MicrowaveService {

	private double weight;

	private int time;

	String message;

	@Autowired
	private Microwave microwave;

	@Autowired
	private MicrowaveStateRepository microwaveStateRepository;

	private static final Logger logger = LoggerFactory.getLogger(MicrowaveServiceImpl.class);

	public MicrowaveServiceImpl() {
		weight = 1.0;
		message = "Welcome";
	}

	@Override
	public String start() {
		if (microwave.getState() == State.RUNNING) {
			message = "Microwave is already on";
		} else if (!microwave.isDoorClosed()) {
			message = "Door is opened, close the door to start";
		} else if (time <= 0) {
			message = "Set the time";
		} else {
			message = String.format("Microwave started at %s seconds", time);
			microwave.setState(State.RUNNING);
			saveStateOfMicrowave(microwave.getState(), microwave.isDoorClosed(), time, weight);
		}
		
		return message;

	}

	@Scheduled(fixedRate = 1000)
	void executingRun() {
		if (microwave.getState() == State.RUNNING && time >= 0) {
			logger.info(String.format("Remaining time is %s seconds", time));
			time--;
			if (time <= 0)
				microwave.setState(State.STOPPED);
		}
	}

	@Override
	public String stop() {
		if (microwave.getState() == State.STOPPED) {
			message = "Can't stop..";
		} else {
			message = "Microwave stopped..";
			microwave.setState(State.STOPPED);
			saveStateOfMicrowave(microwave.getState(), microwave.isDoorClosed(), time, weight);
		}

		resetValues();
		return message;
	}

	private void resetValues() {
		weight = 1;
		time = 0;
	}

	@Override
	public String resume() {
		if (microwave.getState() != State.PAUSED) {
			message = "Can't resume..";
		} else {
			message = String.format("Resumed at %s seconds", time);
			microwave.setState(State.RUNNING);
			saveStateOfMicrowave(microwave.getState(), microwave.isDoorClosed(), time, weight);
		}

		return message;
	}

	@Override
	public String pause() {
		if (microwave.getState() != State.RUNNING) {
			message = "Can't pause..";
		} else {
			message = String.format("Paused at %s seconds", time);
			microwave.setState(State.PAUSED);
			saveStateOfMicrowave(microwave.getState(), microwave.isDoorClosed(), time, weight);
		}

		return message;
	}

	@Override
	public String quickStart() {
		if (microwave.getState() != State.STOPPED) {
			message = "Microwave is already on";
		} else if (!microwave.isDoorClosed()) {
			message = "Door is opened, close the door to start";
		} else {
			time = StandardMicrowaveFunctions.QUICK_START_PRESET_TIME;
			microwave.setState(State.RUNNING);
			message = String.format("Microwave started at %s seconds", time);
			saveStateOfMicrowave(microwave.getState(), microwave.isDoorClosed(), time, weight);
		}

		return message;
	}

	@Override
	public String heatMeat(double weight) {
		extractedFromPreset(weight, PresetMicrowaveFunctions.MEAT_COEFICIENT);

		resetWeight();
		return message;
	}

	@Override
	public String heatVeg(double weight) {
		extractedFromPreset(weight, PresetMicrowaveFunctions.VEG_COEFICIENT);

		resetWeight();
		return message;
	}

	@Override
	public String heatBread(double weight) {
		extractedFromPreset(weight, PresetMicrowaveFunctions.BREAD_COEFICIENT);

		resetWeight();
		return message;
	}

	private void extractedFromPreset(double weight, int coeficient) {
		if (microwave.getState() != State.STOPPED) {
			message = "Microwave is already on";
		} else if (!microwave.isDoorClosed()) {
			message = "Door is opened, close the door to start";
		} else {
			this.weight = weight;
			time = (int) (coeficient * weight);
			microwave.setState(State.RUNNING);
			message = String.format("Microwave started at %s seconds", time);
			saveStateOfMicrowave(microwave.getState(), microwave.isDoorClosed(), time, weight);
		}
	}

	private void resetWeight() {
		weight = 1;
	}

	@Override
	public String setTimer(int time) {
		if (microwave.getState() != State.STOPPED) {
			message = "Microwave is already on, can't set time";
		} else {
			this.time = time;
			message = String.format("Timer set to %s seconds", time);
		}

		return message;
	}

	@Override
	public String openDoor() {
		if (microwave.getState() != State.STOPPED) {
			message = "Microwave running/paused, can't open door";
		} else if (!microwave.isDoorClosed()) {
			message = "Door already opened";
		} else {
			message = "Door opened";
			microwave.setDoorClosed(false);
		}

		return message;
	}

	@Override
	public String closeDoor() {
		if (microwave.isDoorClosed()) {
			message = "Door already closed";
		} else {
			message = "Door closed";
			microwave.setDoorClosed(true);
		}

		return message;
	}

	@Override
	public void saveStateOfMicrowave(State currentState, boolean doorClosed, int time, double weight) {
		MicrowaveState microwaveState = new MicrowaveState();
		microwaveState.setCurrentStateOfMicrowave(currentState);
		microwaveState.setDoorClosed(doorClosed);
		microwaveState.setTimeOnTheTimer(time);
		microwaveState.setWeightOfFood(weight);
		microwaveStateRepository.save(microwaveState);
	}

}
