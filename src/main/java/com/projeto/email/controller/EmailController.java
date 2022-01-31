package com.projeto.email.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.email.model.EmailModel;
import com.projeto.email.modelDto.EmailDto;
import com.projeto.email.service.EmailService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@Transactional
	@PostMapping("/send")
	@ApiOperation(value = "Envia o email e salva no banco de dados")
	public ResponseEntity<EmailModel> send(@RequestBody @Valid EmailDto emailDto) {
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		try {
		emailService.sendEmail(emailModel);
	return new ResponseEntity<>(emailModel, HttpStatus.CREATED);	
	}catch(Exception e) {
		e.getMessage();
	}
		return null;
	}
}
