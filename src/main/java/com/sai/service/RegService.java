package com.sai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sai.repo.RegRepository;

@Service
public class RegService {
	@Autowired
	RegRepository regRepository;
	
	
	public String getCountryName(String ssn)
	{
		
		String baseUrl="https://ssa-web-api.herokuapp.com/state/{ssn}";
		WebClient webClient=WebClient.create();
		String b= webClient.get()
		         .uri(baseUrl,ssn)
		         .retrieve()
		         .bodyToMono(String.class)
		         .block();
		
		return b;
		
		
		
		

	}

}
