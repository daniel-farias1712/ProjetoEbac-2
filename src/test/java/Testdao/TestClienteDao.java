package Testdao;

import dao.ClienteDao;
import model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestClienteDao {

    @Mock
    private ClienteDao clientedaoMock;

    @InjectMocks
    private ClienteDao clientedao;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente("Daniel", 1019203848L, "Paris", "Rua Augusta", "Paraiba", 462, 81999644355L); // Cliente para os testes
    }

    @Test
    public void TestaradicionarCliente() {

        doNothing().when(clientedaoMock).adicionarCliente(cliente);

        clientedao.adicionarCliente(cliente);


        verify(clientedaoMock, times(1)).adicionarCliente(cliente);


        when(clientedaoMock.buscarClientePorNome("Daniel")).thenReturn(cliente);


        Cliente clienteBuscado = clientedao.buscarClientePorNome("Daniel");
        assertEquals(cliente.getNome(), clienteBuscado.getNome());
    }

    @Test
    public void TestarDeletarClientePorNome() {

        doNothing().when(clientedaoMock).adicionarCliente(cliente);


        when(clientedaoMock.buscarClientePorNome("Daniel")).thenReturn(cliente);


        when(clientedaoMock.DeletarClientePorNome("Daniel")).thenReturn(cliente);


        Cliente clienteDeletado = clientedao.DeletarClientePorNome("Daniel");


        assertNotNull(clienteDeletado);
        assertEquals(cliente.getNome(), clienteDeletado.getNome());


        when(clientedaoMock.buscarClientePorNome("Daniel")).thenReturn(null);
        Cliente clienteBuscado = clientedao.buscarClientePorNome("Daniel");
        assertNull(clienteBuscado);
    }
}
