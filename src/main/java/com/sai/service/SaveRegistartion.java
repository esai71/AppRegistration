package com.sai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sai.repo.SaveRepository;
import com.sai.response.RegResponse;

@Service
public class SaveRegistartion {
	
	@Autowired
	SaveRepository sr;
	
	public String saveRegistrationDetails (RegResponse rr) {
		
		String ssss=rr.getSsn();
		String baseUrl="https://ssa-web-api.herokuapp.com/state/{ssn}";
		WebClient webClient=WebClient.create();
		String b= webClient.get()
		         .uri(baseUrl,ssss)
		         .retrieve()
		         .bodyToMono(String.class)
		         .block();
		

		if(b.equals("Kentucky")) {
		sr.save(rr);
		return "SSN";
		}
		else {
		return "Unable to Save Citizen State Name not Kentucky  ";
		}
		
	}

}
