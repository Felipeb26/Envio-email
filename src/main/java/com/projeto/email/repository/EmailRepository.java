package com.projeto.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.email.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
