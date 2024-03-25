package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.produto.repositorio.*;
import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RepostaModelo;

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

    //Filtrar produtos 
    @RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo){
        return acoes.findByCodigo(codigo);
    }

    //Alterar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }

    //Remover produtos
    @RequestMapping(value ="/produtos/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody RepostaModelo remove(@PathVariable Integer codigo) {

        RepostaModelo resposta = new RepostaModelo();
        try{
            ProdutoModelo produto = filtrar(codigo);
            this.acoes.delete(produto);
            resposta.setMensagem("Produto removido com sucesso");    
        }catch(Exception erro){
            resposta.setMensagem("Falha ao remover: " +erro.getMessage());
        }
        return resposta;
    }
}
