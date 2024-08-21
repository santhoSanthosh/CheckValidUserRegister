package com.example.collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionController {
	@Autowired
	private CollectionService collectionService;
	
	//e.g., valid email format, strong password, and age over 18
	
	@PostMapping("/registerUser")
	public ResponseEntity<Users> dataRegister(@RequestBody Users user) {
		try {
			return ResponseEntity.ok(collectionService.dataRegister(user));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}


