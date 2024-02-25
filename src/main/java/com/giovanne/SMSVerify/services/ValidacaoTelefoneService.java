package com.giovanne.SMSVerify.services;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoTelefoneService {

    private final EnviarSmsService enviarSmsService;

    public ValidacaoTelefoneService(EnviarSmsService enviarSmsService) {
        this.enviarSmsService = enviarSmsService;
    }

    public String solicitarValidacaoSms(String telefone) {

        //valida telefone
        //TODO: implementar validação de telefone

        //gera hash

        // cria link com hash

        //envia sms

        var resultado = enviarSmsService.enviarSms("+5585986482308",
                "Clique no link para acessar nosso site: http://localhost:8080/beneficiarios/confirmacao-telefone/sms/504504dsadas5454",
                "");

        //retorna resultado
        return resultado;
    }

    public String validaTelefone(String hash) {

        //valida hash

        return "Telefone confirmado";
    }
}
