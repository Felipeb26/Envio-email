package com.projeto.email.modelDto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {
	
	@NotBlank
	private String nomeRef;
	@NotBlank
	private String  remetente;
	@NotBlank
	private String destinatario;
	@NotBlank
	private String assunto;
	@NotBlank
	private String texto;
}
