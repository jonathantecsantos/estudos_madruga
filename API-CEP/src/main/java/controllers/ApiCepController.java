package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import records.EnderecoRecord;
import services.ConsultaCepService;

@RestController
@RequestMapping("apicep")
public class ApiCepController {

    @Autowired
    private ConsultaCepService consultaCepService;

    @GetMapping("/buscar-cep/{cep}")
    public EnderecoRecord buscarCep(@PathVariable String cep){
        return consultaCepService.buscaEndereco(cep);
    }
}
