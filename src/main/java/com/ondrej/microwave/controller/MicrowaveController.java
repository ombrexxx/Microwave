package com.ondrej.microwave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ondrej.microwave.service.MicrowaveService;

@Controller
@RequestMapping("/microwave")
public class MicrowaveController {

	@Autowired
	private MicrowaveService microwaveService;
	
	@RequestMapping("/")
    public String index(Model theModel) {
		theModel.addAttribute("message", "Welcome");
        return "microwave";
    }
	
	@GetMapping("/start")
	public String startMicrowave(Model theModel) {
		theModel.addAttribute("message", microwaveService.start());
		return "microwave";
	}

	@GetMapping("/pause")
	public String pauseMicrowave(Model theModel) {
		theModel.addAttribute("message", microwaveService.pause());
		return "microwave";
	}

	@GetMapping("/resume")
	public String resumeMicrowave(Model theModel) {
		theModel.addAttribute("message", microwaveService.resume());
		return "microwave";
	}

	@GetMapping("/stop")
	public String stopMicrowave(Model theModel) {
		theModel.addAttribute("message", microwaveService.stop());
		return "microwave";
	}

	@GetMapping("/closeDoor")
	public String closeMicrowave(Model theModel) {
		theModel.addAttribute("message", microwaveService.closeDoor());
		return "microwave";
	}

	@GetMapping("/openDoor")
	public String openMicrowave(Model theModel) {
		theModel.addAttribute("message", microwaveService.openDoor());
		return "microwave";
	}

	@PostMapping("/setTime")
	public String setTimerMicrowave(@RequestParam(defaultValue = "0") int time, Model theModel) {
		theModel.addAttribute("message", microwaveService.setTimer(time));
		return "microwave";
	}

	@PostMapping("/heatVeg")
	public String heatVeg(@RequestParam(defaultValue = "1") double weight, Model theModel) {
		theModel.addAttribute("message", microwaveService.heatVeg(weight));
		return "microwave";
	}

	@PostMapping("/heatBread")
	public String heatBread(@RequestParam(defaultValue = "1") double weight, Model theModel) {
		theModel.addAttribute("message", microwaveService.heatBread(weight));
		return "microwave";
	}

	@PostMapping("/heatMeat")
	public String heatMeat(@RequestParam(defaultValue = "1") double weight, Model theModel) {
		theModel.addAttribute("message", microwaveService.heatMeat(weight));
		return "microwave";
	}

	@GetMapping("/quickStart")
	public String quickStart(Model theModel) {
		theModel.addAttribute("message", microwaveService.quickStart());
		return "microwave";
	}

}
