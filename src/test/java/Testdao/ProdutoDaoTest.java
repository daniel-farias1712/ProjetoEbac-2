package Testdao;

import dao.ProdutoDao;
import model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoDaoTest {

    private ProdutoDao produtoDao;
    private Produto produto1;
    private Produto produto2;


    @BeforeEach
    public void setUp() {
        produtoDao = new ProdutoDao();
        produto1 = new Produto("001", "Produto A", 50.0);
        produto2 = new Produto("002", "Produto B", 100.0);

        produtoDao.adicionarProduto(produto1);
        produtoDao.adicionarProduto(produto2);
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto("003", "Produto C", 150.0);
        produtoDao.adicionarProduto(produto);

        Produto produtoBuscado = produtoDao.buscarProdutoPorCodigo("003");
        assertNotNull(produtoBuscado, "O produto deve ser adicionado com sucesso");
        assertEquals("Produto C", produtoBuscado.getDescricao(), "O nome do produto deve ser 'Produto C'");
    }

    @Test
    public void testBuscarProdutoPorCodigo() {
        Produto produtoBuscado = produtoDao.buscarProdutoPorCodigo("001");
        assertNotNull(produtoBuscado, "O produto com código 001 deve ser encontrado");
        assertEquals("Produto A", produtoBuscado.getDescricao(), "O nome do produto deve ser 'Produto A'");
    }

    @Test
    public void testAtualizarProduto() {
        produto1.setPreco(55.0);  // Atualiza o preço de produto1
        produtoDao.atualizarProduto(produto1);

        Produto produtoAtualizado = produtoDao.buscarProdutoPorCodigo("001");
        assertNotNull(produtoAtualizado, "O produto com código 001 deve ser encontrado");
        assertEquals(55.0, produtoAtualizado.getPreco(), "O preço do produto deve ser 55.0");
    }

    @Test
    public void testDeletarProdutoPorCodigo() {
        boolean resultado = produtoDao.deletarProdutoPorCodigo("002");
        assertTrue(resultado, "O produto com código 002 deve ser deletado");

        Produto produtoDeletado = produtoDao.buscarProdutoPorCodigo("002");
        assertNull(produtoDeletado, "O produto com código 002 não deve existir após ser deletado");
    }

    @Test
    public void testListarProdutos() {
        assertEquals(2, produtoDao.listarProdutos().size(), "Deve haver 2 produtos cadastrados");

        Produto produtoBuscado = produtoDao.listarProdutos().get(0);
        assertEquals("Produto A", produtoBuscado.getDescricao(), "O primeiro produto deve ser 'Produto A'");
    }
}
