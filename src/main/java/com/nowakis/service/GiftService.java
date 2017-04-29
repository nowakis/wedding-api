package com.nowakis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.nowakis.dao.GiftRepository;
import com.nowakis.model.Gift;

@Component
@Transactional
public class GiftService {

	private final GiftRepository giftRepository;

	public GiftService(GiftRepository giftRepository) {
		this.giftRepository = giftRepository;
	}

	public List<Gift> findAll() {
		List<Gift> rsvps = new ArrayList<>();
		for (Gift rsvp : giftRepository.findAll()) {
			rsvps.add(rsvp);
		}
		return rsvps;
	}
	
	public List<Gift> findByCategory(String category) {
		return giftRepository.findByCategoria(category);
	}	

	public Gift find(String id) {
		return giftRepository.findOne(id);
	}

	public Gift create(Gift rsvp) {
		rsvp.setId(UUID.randomUUID().toString());
		this.save(rsvp);
		return rsvp;
	}

	public void save(Gift rsvp) {
		giftRepository.save(rsvp);
	}

	public void delete(String id) {
		giftRepository.delete(id);
	}
}
