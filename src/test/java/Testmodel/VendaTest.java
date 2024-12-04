package Testmodel;

import dao.ClienteDao;
import dao.ProdutoDao;
import model.Cliente;
import model.NotaFiscal;
import model.Produto;
import model.Venda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class VendaTest {

    private ClienteDao clienteDao;
    private ProdutoDao produtoDao;
    private Venda venda;

    @BeforeEach
    public void setUp() {
        clienteDao = ClienteDao.getInstance();
        produtoDao = new ProdutoDao();
        venda = new Venda();

        clienteDao.adicionarCliente(new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraíba", 462, 81999644355L));
        produtoDao.adicionarProduto(new Produto("Produto A", 50.0, "A123"));
        produtoDao.adicionarProduto(new Produto("Produto B", 100.0, "B456"));
    }

    @Test
    public void testRealizarVenda() {
        List<String> codigosProdutos = new ArrayList<>();
        codigosProdutos.add("A123");
        codigosProdutos.add("B456");

        NotaFiscal notaFiscal = venda.realizarVenda("Daniel", codigosProdutos);

        assertNotNull(notaFiscal);
        assertEquals("Produto A", notaFiscal.getItens().get(0).getDescricao());
        assertEquals("Produto B", notaFiscal.getItens().get(1).getDescricao());
        assertEquals(2, notaFiscal.getItens().size());
    }
}
