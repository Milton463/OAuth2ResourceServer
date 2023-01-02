package com.milton.auth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milton.auth2.model.Utility;
import com.milton.auth2.service.UtilityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UtilityResourceController {

	@Autowired
	private UtilityService utilityService;
	
	@PostMapping(value="/utilities")
	public ResponseEntity<String> saveUtility(@RequestBody Utility utility ) {
		
		utilityService.save(utility);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	@PutMapping(value="/utilities/{utilityId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utility> updateUtility(@RequestBody Utility utility ,@PathVariable ("utilityId") int utilityId) {
		
		Utility s = utilityService.update(utilityId,utility).get();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(s,headers,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value="/utilities/{utilityId}")
	public ResponseEntity<Utility> deleteUtility(@PathVariable ("utilityId") int utilityId) {
		
		utilityService.delete(utilityId);
		
		return new ResponseEntity<Utility>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping(value="/utilities", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Utility>> getAllUtilitys(Authentication auth) {
		
		System.out.println("auth "+auth.getName());
		return new ResponseEntity<List<Utility>>(utilityService.getUtilities(), HttpStatus.FOUND);
		
	}
	
	@GetMapping(value="/utilities/{utilityId}")
	public ResponseEntity<Utility> getUtilityById(@PathVariable ("utilityId") int utilityId) {
		
		log.info("inside getbyid");
		Utility utility=utilityService.getUtilityById(utilityId).get();
			
		if(utility==null) {
			return new ResponseEntity<Utility>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Utility>(utility,HttpStatus.OK);
	}
}
