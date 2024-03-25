package com.api.produto.repositorio;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.api.produto.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer> {
    // lista de todos os produtos
    List<ProdutoModelo> findAll();

    // Pesquisar por código
    ProdutoModelo findByCodigo(int código);

    // Remover produto
    void delete(ProdutoModelo produto);

    // Cadastrar/Alterar produto
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);
}
