package com.consumer.apicep;

import records.EnderecoRecord;
import services.ConsultaCepService;

public class Principal {
    public static void main(String[] args) {
        ConsultaCepService consultaCepService = new ConsultaCepService();
        EnderecoRecord novoEndereco = consultaCepService.buscaEndereco("58404084");
        System.out.println(novoEndereco);
    }
}
