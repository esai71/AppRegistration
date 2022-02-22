package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.response.RegResponse;
import com.sai.service.RegService;
import com.sai.service.SaveRegistartion;

@RestController
public class RegController {
	@Autowired
	RegService regService;
	
	@Autowired
	SaveRegistartion saveRegistartion;
	
	@GetMapping("/get/{ssn}")
	public ResponseEntity<String> getStates( @PathVariable String ssn)
	{
		//System.out.println("h1");
		ResponseEntity<String> res=null;
		try {
			String body=regService.getCountryName(ssn);
			res=new ResponseEntity<String>(body,HttpStatus.OK);
		}
		catch(Exception e){
			res=new ResponseEntity<String>("unable to get state",HttpStatus.OK);
		}
		return res;
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveReg( @RequestBody RegResponse rrs)
	{
		//System.out.println("saveopertaion");
		ResponseEntity<String> res=null;
		try {
			
			{  
				int min = 50000;  
				int max = 100000;  
				int randomNumber = (int)(Math.random()*(max-min+1)+min);  
			String body=saveRegistartion.saveRegistrationDetails(rrs);
			res=new ResponseEntity<>(body+randomNumber,HttpStatus.OK);
		}
		}
		catch(Exception e){
			res=new ResponseEntity<String>("unable to save",HttpStatus.OK);
		}
		return res;
		
	}
	
	
	

}
