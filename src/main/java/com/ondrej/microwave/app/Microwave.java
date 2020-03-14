package com.ondrej.microwave.app;

import org.springframework.stereotype.Component;

@Component
public class Microwave {

	private State state;

	private boolean doorClosed;

	public Microwave() {
		state = State.STOPPED;
		doorClosed = false;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isDoorClosed() {
		return doorClosed;
	}

	public void setDoorClosed(boolean doorClosed) {
		this.doorClosed = doorClosed;
	}

}
