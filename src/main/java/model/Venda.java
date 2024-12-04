package model;

import dao.ClienteDao;
import dao.ProdutoDao;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private ClienteDao clienteDao = ClienteDao.getInstance();
    private ProdutoDao produtoDao = new ProdutoDao();

    public NotaFiscal realizarVenda(String nomeCliente, List<String> codigosProdutos) {
        Cliente cliente = clienteDao.buscarClientePorNome(nomeCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        List<ItemNotaFiscal> itens = new ArrayList<>();

        for (String codigoProduto : codigosProdutos) {
            Produto produto = produtoDao.buscarProdutoPorCodigo(codigoProduto);
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado: Código " + codigoProduto);
            }
            ItemNotaFiscal item = new ItemNotaFiscal(produto.getDescricao(), 1, produto.getPreco());
            itens.add(item);
        }

        return new NotaFiscal("NF-" + System.currentTimeMillis(), cliente, itens);
    }
}
