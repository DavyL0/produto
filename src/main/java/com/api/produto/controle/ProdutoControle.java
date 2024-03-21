package com.api.produto.controle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoControle {
    // inicio
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String inicio() {
        return "BEm vindo a API de produtos!";
    }

    // sobre
    @RequestMapping(value = "/sobre", method = RequestMethod.GET)
    public @ResponseBody String sobre() {
        return "Sobre a API...";
    }

    // contato
    @RequestMapping(value = "/contato", method = RequestMethod.GET)
    public @ResponseBody String contato() {
        return "Fale Conosco!";
    }
}
