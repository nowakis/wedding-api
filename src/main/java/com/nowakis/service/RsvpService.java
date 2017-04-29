package com.nowakis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nowakis.dao.RsvpRepository;
import com.nowakis.model.Rsvp;

@Component
@Transactional
public class RsvpService {
	
	private final RsvpRepository rsvpRepository;

	public RsvpService(RsvpRepository rsvpRepository) {
		this.rsvpRepository = rsvpRepository;
	}
	
	public List<Rsvp> findAll(){
		List<Rsvp> rsvps = new ArrayList<>();
		for(Rsvp rsvp : rsvpRepository.findAll()){
			rsvps.add(rsvp);
		}
		return rsvps;
	}
	
	public Rsvp find(String id){
		return rsvpRepository.findOne(id);
	}
	
	public Rsvp create(Rsvp rsvp)  {
		rsvp.setId(UUID.randomUUID().toString());
		this.save(rsvp);
		
		try {
			
			String subject = "RSVP: Confirmação de presença o/";
			String message = "<p>Olá noivos</p>"
					+ "<p>Mais uma confirmação de presença! A festa vai bombar! :)</p>"
					+ "<p><b>Nome:</b> " + rsvp.getNome() + "<br />"
					+ "<b>Email:</b> " + rsvp.getEmail()  + "<br />"
					+ "<b>Telefone:</b> " + rsvp.getTelefone()  + "<br />"
					+ "<b>Convidados:</b> " + rsvp.getConvidados()  + "<br />"
					+ "<b>Mensagem:</b> " + rsvp.getMensagem()  + "</p>"
					+ "<p>Boa festa!</p>";
			
			SendMailApi.generateAndSendEmail(subject, message);
		} catch (AddressException e) {
	    	System.out.println("Erro ao enviar email: " + e.getMessage());
		} catch (MessagingException e) {
			System.out.println("Erro ao enviar mensagem de email: " + e.getMessage());
		}
		
		return rsvp;
	}
	
	public void save(Rsvp rsvp){
		rsvpRepository.save(rsvp);
	}
	
	public void delete(String id){
		rsvpRepository.delete(id);
	}
}
