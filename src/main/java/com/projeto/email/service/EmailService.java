package com.projeto.email.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.projeto.email.enums.Result;
import com.projeto.email.model.EmailModel;
import com.projeto.email.repository.EmailRepository;
import com.projeto.email.teste.Conecxao;

@Service
public class EmailService {

	Conecxao conec;
	
	EntityManager em = conec.createEntityManager();
	
	@Autowired
	EmailRepository emailRepository;

	@Autowired
	private JavaMailSender emailSender;

	@SuppressWarnings("finally")
	public EmailModel sendEmail(EmailModel emailModel) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
		Calendar calendar = Calendar.getInstance();

		emailModel.setDataDeEnvio(sdf.format(calendar.getTime()));
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getRemetente());
			message.setTo(emailModel.getDestinatario());
			message.setSubject(emailModel.getAssunto());
			message.setText(emailModel.getTexto());
			emailSender.send(message);

			emailModel.setPadrao(Result.funcionando);
			System.out.println("email enviado");
		} catch (MailException e) {
			emailModel.setPadrao(Result.erro);
			System.out.println(e.getMessage());
		} finally {
			return emailRepository.save(emailModel);
		}
	}
	
}