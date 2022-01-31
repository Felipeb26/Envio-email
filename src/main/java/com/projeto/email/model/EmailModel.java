package com.projeto.email.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projeto.email.enums.Result;

import lombok.Data;

@Data
@Entity
@Table(name = "email")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeRef;
	private String  remetente;
	private String destinatario;
	private String assunto;
	@Column(columnDefinition = "TEXT")
	private String texto;
	private String dataDeEnvio;
	private Result padrao;
	
}
