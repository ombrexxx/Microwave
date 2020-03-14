package com.ondrej.microwave.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ondrej.microwave.app.State;

@Entity
@Table(name = "microwaveState")
public class MicrowaveState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "door_closed")
	private boolean doorClosed;
	
	@Column(name = "weight_of_food")
	private double weightOfFood;
	
	@Column(name = "time_on_the_timer")
	private int timeOnTheTimer;
	
	@Column(name = "current_time_and_date")
	private LocalDateTime currentTimeAndDate = LocalDateTime.now();
	
	@Column(name = "current_state_of_microwave")
	@Enumerated(EnumType.STRING)
	private State currentStateOfMicrowave;
	
	public MicrowaveState() {	
	}
	
	public MicrowaveState(boolean doorClosed, double weightOfFood, int timeOnTheTimer, State currentStateOfMicrowave) {
		this.doorClosed = doorClosed;
		this.weightOfFood = weightOfFood;
		this.timeOnTheTimer = timeOnTheTimer;
		this.currentStateOfMicrowave = currentStateOfMicrowave;
	}

	public void setDoorClosed(boolean doorClosed) {
		this.doorClosed = doorClosed;
	}

	public void setWeightOfFood(double weightOfFood) {
		this.weightOfFood = weightOfFood;
	}

	public void setTimeOnTheTimer(int timeOfTimer) {
		this.timeOnTheTimer = timeOfTimer;
	}

	public void setCurrentStateOfMicrowave(State currentStateOfMicrowave) {
		this.currentStateOfMicrowave = currentStateOfMicrowave;
	}

}
