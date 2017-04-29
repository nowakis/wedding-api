package com.nowakis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nowakis.model.Gift;
import com.nowakis.service.GiftCategoryEnum;
import com.nowakis.service.GiftService;

@RestController
@RequestMapping("wedding/gift")
public class GiftController {
	
	@Autowired
	private GiftService giftService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public Gift add(@RequestBody Gift gift, HttpServletRequest request){
    	
    	try {
	    	giftService.create(gift);
    	} catch (Exception e) {
    		System.out.println("Errorrrrr");
    		e.printStackTrace();
    	}
    	
    	return gift;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Gift get(@PathVariable String id){
    	return giftService.find(id);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Gift> list(){
    	return giftService.findAll();
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public List<Gift> search(@RequestParam(value="category") String category){
    	return giftService.findByCategory(GiftCategoryEnum.from(category).toString());
    }    
}
