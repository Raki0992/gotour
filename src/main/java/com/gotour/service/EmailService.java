package com.gotour.service;

import com.gotour.dto.EmailDTO;

public interface EmailService {

	void sendMail(EmailDTO dto, String message);
}
