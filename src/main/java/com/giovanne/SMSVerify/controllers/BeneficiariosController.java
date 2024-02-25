package com.giovanne.SMSVerify.controllers;

import com.giovanne.SMSVerify.services.ValidacaoTelefoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiariosController {

    private final ValidacaoTelefoneService validacaoTelefoneService;

    public BeneficiariosController(ValidacaoTelefoneService validacaoTelefoneService) {
        this.validacaoTelefoneService = validacaoTelefoneService;
    }


    @PostMapping("/validacao/sms/{telefone}")
    public String solicitarValidacaoSms(@PathVariable String telefone) {
        return validacaoTelefoneService.solicitarValidacaoTelefone(telefone);
    }

    @GetMapping("/confirmacao-telefone/sms/{hash}")
    public String validaTelefone(@PathVariable String hash) {
        return validacaoTelefoneService.validaTelefone(hash);
    }
}
