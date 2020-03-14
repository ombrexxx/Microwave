package com.ondrej.microwave.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.ondrej.microwave.app.Microwave;
import com.ondrej.microwave.app.MicrowaveApplication;
import com.ondrej.microwave.app.State;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MicrowaveApplication.class)
class MicrowaveServiceTest {

	@Autowired
	private MicrowaveService microwaveService;
	
	@Autowired
	private Microwave microwave;
	
	@BeforeEach
    public void executedBeforeEach() {
		ReflectionTestUtils.setField(microwave, "doorClosed", false);
		ReflectionTestUtils.setField(microwave, "state", State.STOPPED);
		ReflectionTestUtils.setField(microwaveService, "weight", 1);
		ReflectionTestUtils.setField(microwaveService, "time", 0);
		ReflectionTestUtils.setField(microwaveService, "message", "Welcome");
    }
	
	@Test
	void testStart() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		ReflectionTestUtils.setField(microwaveService, "time", 50);
		String result = microwaveService.start();
		assertEquals("Microwave started at 50 seconds", result);
	}
	
	@Test
	void testStartWhenNoTimeSet() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.start();
		assertEquals("Set the time", result);
	}
	
	@Test
	void testStartWhenDoorIsOpened() {
		String result = microwaveService.start();
		assertEquals("Door is opened, close the door to start", result);
	}
	
	@Test
	void testStartWhenRunning() {
		ReflectionTestUtils.setField(microwave, "state", State.RUNNING);
		String result = microwaveService.start();
		assertEquals("Microwave is already on", result);
	}

	@Test
	void testStop() {
		String result = microwaveService.stop();
		assertEquals("Can't stop..", result);
	}
	
	@Test
	void testStopWhenRunning() {
		ReflectionTestUtils.setField(microwave, "state", State.RUNNING);
		String result = microwaveService.stop();
		assertEquals("Microwave stopped..", result);
	}

	@Test
	void testResumeWhenStopped() {
		String result = microwaveService.resume();
		assertEquals("Can't resume..", result);
	}

	@Test
	void testPause() {
		String result = microwaveService.pause();
		assertEquals("Can't pause..", result);
	}

	@Test
	void testQuickStart() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.quickStart();
		assertEquals("Microwave started at 60 seconds", result);
	}

	@Test
	void testHeatMeat() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.heatMeat(2.5);
		assertEquals("Microwave started at 150 seconds", result);
	}

	@Test
	void testHeatVeg() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.heatVeg(2.5);
		assertEquals("Microwave started at 200 seconds", result);
	}

	@Test
	void testHeatBread() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.heatBread(2.5);
		assertEquals("Microwave started at 250 seconds", result);
	}

	@Test
	void testSetTimer() {
		String result = microwaveService.setTimer(40);
		assertEquals("Timer set to 40 seconds", result);
	}
	
	@Test
	void testSetTimerIfRunning() {
		ReflectionTestUtils.setField(microwave, "state", State.RUNNING);
		String result = microwaveService.setTimer(40);
		assertEquals("Microwave is already on, can't set time", result);
	}

	@Test
	void testOpenDoorWhenClosed() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.openDoor();
		assertEquals("Door opened", result);
	}
	
	@Test
	void testOpenDoorWhenOpened() {
		String result = microwaveService.openDoor();
		assertEquals("Door already opened", result);
	}

	@Test
	void testCloseDoorWhenOpened() {
		String result = microwaveService.closeDoor();
		assertEquals("Door closed", result);
	}	
	
	@Test
	void testCloseDoorWhenClosed() {
		ReflectionTestUtils.setField(microwave, "doorClosed", true);
		String result = microwaveService.closeDoor();
		assertEquals("Door already closed", result);
	}	

}
