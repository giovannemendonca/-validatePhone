package com.giovanne.SMSVerify.infrastructure;

import com.giovanne.SMSVerify.services.EnviarSmsService;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EnvioSmsTwilioImpl implements EnviarSmsService {

    private final TwilioRestClient twilioRestClient;

    private Logger logger = Logger.getLogger(EnvioSmsTwilioImpl.class.getName());

    @Value("${twilio.phone_number}")
    private String fromNumber;

    public EnvioSmsTwilioImpl(TwilioRestClient twilioRestClient) {
        this.twilioRestClient = twilioRestClient;
    }

    @Override
    public String enviarSms(String telefone, String mensagem, String link) {

        PhoneNumber to = new PhoneNumber(telefone);
        PhoneNumber from = new PhoneNumber(fromNumber);

        try {
            Message.creator(to, from, mensagem).create(twilioRestClient);
            logger.info("Mensagem enviada com sucesso");
            return "Mensagem enviada com sucesso";
        } catch (Exception e) {
            logger.severe("Erro ao enviar mensagem");
            return "Erro ao enviar mensagem";
        }

    }
}
