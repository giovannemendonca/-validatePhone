package com.giovanne.SMSVerify.services;

import org.springframework.stereotype.Service;

@Service
public interface EnviarSmsService {

    public String enviarSms(String telefone, String mensagem, String link);
}
