package dao;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDao {

    private List<Produto> produtos;


    public ProdutoDao() {
        this.produtos = new ArrayList<>();
    }


    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }


    public Produto buscarProdutoPorCodigo(String codigo) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst();
        return produto.orElse(null);
    }


    public void atualizarProduto(Produto produto) {
        Produto produtoExistente = buscarProdutoPorCodigo(produto.getCodigo());
        if (produtoExistente != null) {
            produtoExistente.setDescricao(produto.getDescricao());
            produtoExistente.setPreco(produto.getPreco());
        }
    }


    public boolean deletarProdutoPorCodigo(String codigo) {
        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }


    public List<Produto> listarProdutos() {
        return produtos;
    }
}
