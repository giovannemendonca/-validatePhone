package com.giovanne.SMSVerify.services;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoTelefoneService {

    private final EnviarSmsService enviarSmsService;

    public ValidacaoTelefoneService(EnviarSmsService enviarSmsService) {
        this.enviarSmsService = enviarSmsService;
    }

    public String solicitarValidacaoTelefone(String telefone) {

        //valida telefone
        var telefoneFormatado = formatarTelefone(telefone);

        //gera hash

        // cria link com hash

        //envia sms

       /* var resultado = enviarSmsService.enviarSms("+5585986482308",
                "Clique no link para acessar nosso site: http://localhost:8080/beneficiarios/confirmacao-telefone/sms/504504dsadas5454",
                "");*/

        //retorna resultado
        return telefoneFormatado;
    }

    public String validaTelefone(String hash) {
        return "Telefone validado com sucesso!";
    }


    private String formatarTelefone(String telefone) {
        var numeroLimpo = telefone.replaceAll("[^0-9]", ""); //remove caracteres especiais

        if (numeroLimpo.length() < 11) {
            throw new RuntimeException("Telefone inválido");
        }
        if (numeroLimpo.length() == 11) {
            return String.format("+55%s", numeroLimpo);
        }
        if (numeroLimpo.length() == 13) {
            return String.format("+%s", numeroLimpo);
        }
        throw new RuntimeException("Telefone inválido");
    }
}
