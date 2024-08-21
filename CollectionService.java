package com.example.collections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class CollectionService {
    public Users dataRegister(Users user) {
		try {
			Boolean checkAge = user.getAge() > 18;
			Boolean checkPassword = user.getPassword().matches("[\\d\\w!@#$%^&*]{6,15}$");
			Boolean checkDOB = false;
			try {
			    Date dob = user.getDob();
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    String dobString = dateFormat.format(dob);
			    dateFormat.parse(dobString);
			    checkDOB = true;
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
			Boolean checkEmail = user.getEmail().matches("^[\\w.+-]+@[\\w.-]+\\.[\\w]{2,3}$");
			System.out.println(checkPassword + "  "+ checkEmail);
			
			if(checkAge && checkEmail && checkPassword && checkDOB) {
               	System.out.println("User Register");
               	return user;
               	//userRepo.save(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
    
}
