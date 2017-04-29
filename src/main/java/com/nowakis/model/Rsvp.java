package com.nowakis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "rsvp")
public class Rsvp {

	@Id
	private String id;
	private String nome;
	private String telefone;
	private String email;
	private String convidados;
	private String mensagem;
	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConvidados() {
		return convidados;
	}

	public void setConvidados(String convidados) {
		this.convidados = convidados;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Rsvp [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", convidados="
				+ convidados + ", mensagem=" + mensagem + ", ip=" + ip + "]";
	}
}
