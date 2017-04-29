package com.nowakis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nowakis.model.Rsvp;
import com.nowakis.service.RsvpService;

@RestController
@RequestMapping("wedding/rsvp")
public class RsvpController {
	
	@Autowired
	private RsvpService rsvpService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public Rsvp add(@RequestBody Rsvp rsvp, HttpServletRequest request){
    	
    	try {
	    	String ipAddress = request.getHeader("X-FORWARDED-FOR");
	    	if (ipAddress == null) {
	    		   ipAddress = request.getRemoteAddr();
	    	}
	    	
	    	System.out.println("IP Address: " + ipAddress);
	    	System.out.println("Post recebido: " + rsvp.toString());
	    	
	    	rsvp.setIp(ipAddress);
	    	rsvpService.create(rsvp);
    	} catch (Exception e) {
    		System.out.println("Errorrrrr");
    		e.printStackTrace();
    	}
    	
    	return rsvp;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Rsvp get(@PathVariable String id){
    	return rsvpService.find(id);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Rsvp> list(){
    	return rsvpService.findAll();
    }    
}
