package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.produto.repositorio.*;
import com.api.produto.modelo.ProdutoModelo;

@RestController
@RequestMapping("/api")
public class ProdutoControle {
    //acoes 
    @Autowired
    private ProdutoRepositorio acoes;


    // Lista produtos 
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo> listar() {
        return acoes.findAll();
    }

    //Cadastro de Produto
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }
}
