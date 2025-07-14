package com.example.abc_company.controller;

import com.example.abc_company.entity.Heading;
import com.example.abc_company.repository.HeadingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*") // Allow React Frontend
public class HeadingController {
	
	private final HeadingRepository repo;
	
	public HeadingController(HeadingRepository repo) {
		this.repo = repo;
	}
	
	//	@PostMapping("/heading")
	//	public Map<String, String> save(@RequestBody Map<String, String> request){
	//		String text = request.get("text");
	//		repo.save(new Heading(text));
	//		return Map.of("message", "Saved successfully");
	//	}
	@PostMapping("/heading")
	public Map<String, String> save(@RequestBody Map<String, String> request) {
	    String text = request.get("text");

	    // Always update the record with ID 0
	    Heading heading = repo.findById(0L).orElse(new Heading(text));
	    heading.setText(text); // Update the text
	    repo.save(heading);

	    return Map.of("message", "Saved successfully");
	}
	
	@GetMapping("/heading")
	public Map<String, String> get() {
		Heading latest = repo.findTopByOrderByIdDesc();
		String DefaultHeading = "Hyper boost your Revenue Management, Marketing and Commercial Functions with Business Ready AI";
		return Map.of("text", latest != null ? latest.getText() : DefaultHeading);
	}
}
