package model;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

    public static Servidor instancia;
    private List<Cliente> clientes;

    private Servidor(){
        this.clientes = new ArrayList<>();

    }

   public static Servidor getInstance() {
       if (instancia == null) {
           instancia = new Servidor();

       }
       return instancia;
   }

   public boolean adicionarCliente(Cliente cliente ){
        for (Cliente c: clientes){
            if (c.getCpf().equals(cliente.getCpf())){
                return false;
            }
        }
        clientes.add(cliente);
        return true;
   }

   public Cliente buscarClientePorPCF(Long cpf){
        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;

   }

   public List<Cliente> getClientes(){
        return clientes;
   }


}
