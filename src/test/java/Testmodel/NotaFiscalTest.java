package Testmodel;

import model.Cliente;
import model.ItemNotaFiscal;
import model.NotaFiscal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotaFiscalTest {

    @Test
    public void DevecalcularOvalorTotalCorretamente(){
        Cliente cliente = new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraíba", 462, 81999644355L);

        List<ItemNotaFiscal> itens = new ArrayList<>();

        itens.add(new ItemNotaFiscal("Produto A", 2, 50.0)); // 2 x 50 = 100
        itens.add(new ItemNotaFiscal("Produto B", 1, 100.0)); // 1 x 100 = 100
        itens.add(new ItemNotaFiscal("Produto C", 5, 20.0)); // 5 x 20 = 100

        NotaFiscal notaFiscal = new NotaFiscal("NF-001", cliente, itens);
    }

    @Test
    public void RetornarOClienteCorretamente(){

        Cliente cliente = new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraíba", 462, 81999644355L);

        List<ItemNotaFiscal> itens = new ArrayList<>();
        itens.add(new ItemNotaFiscal("Produto A ", 2,50));

        NotaFiscal notaFiscal = new NotaFiscal("NF-003", cliente, itens);

        Cliente clienteAssociado = notaFiscal.getCliente();

        assertNotNull(clienteAssociado, "O cliente associado à nota fiscal não deve ser nulo.");
        assertEquals("Daniel", clienteAssociado.getNome(), "O nome do cliente deve ser 'Daniel'.");


    }
    @Test
    public void DeveRetornarOsItensCorreamente(){

        Cliente cliente = new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraíba", 462, 81999644355L);
        List<ItemNotaFiscal> itens = new ArrayList<>();
        itens.add(new ItemNotaFiscal("Produto A", 2, 50.0));
        itens.add(new ItemNotaFiscal("Produto B", 1, 100.0));

        NotaFiscal notaFiscal = new NotaFiscal("NF-004", cliente, itens);

        List<ItemNotaFiscal> itenNota = notaFiscal.getItens();


        assertNotNull(itenNota, "A lista não deve ser nula");
        assertEquals(2,itenNota.size() ,"A lista deve conter 2 itens");
        assertEquals("Produto A", itenNota.get(0).getDescricao() ,"O primeiro item deve ser 'Produto A'.");
    }
}
