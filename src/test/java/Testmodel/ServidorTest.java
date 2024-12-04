package Testmodel;
import model.Servidor;
import model.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServidorTest {

    @Test
    public void deveAdicionarClienteCorretamente() {

        Servidor servidor = Servidor.getInstance();


        servidor.getClientes().clear();

        Cliente cliente = new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraíba", 462, 81999644355L);
        boolean adicionado = servidor.adicionarCliente(cliente);

        assertTrue(adicionado, "O cliente deve ser adicionado com sucesso.");
        assertEquals(1, servidor.getClientes().size(), "A lista de clientes deve conter 1 cliente.");
        assertEquals("Daniel", servidor.getClientes().get(0).getNome(), "O nome do cliente deve ser 'Daniel'.");
    }

    @Test
    public void naoDeveAdicionarClienteDuplicado() {

        Servidor servidor = Servidor.getInstance();


        servidor.getClientes().clear();

        Cliente cliente1 = new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraíba", 462, 81999644355L);
        Cliente clienteDuplicado = new Cliente("Outro Daniel", 1019203848L, "Londres", "Rua Secundária", "Paraíba", 462, 81999644355L);

        servidor.adicionarCliente(cliente1);
        boolean adicionadoDuplicado = servidor.adicionarCliente(clienteDuplicado);

        assertFalse(adicionadoDuplicado, "O cliente duplicado não deve ser adicionado.");
        assertEquals(1, servidor.getClientes().size(), "A lista de clientes deve conter apenas 1 cliente.");
    }
}
