package Sistema.dominio;

import java.util.*;

public class Banco {
    private List<Integer> idCliente = new ArrayList<>();
    private double saldo;
    private double receita;
    private double gastos;
    public void adicionaIdDosClientes(Integer id) {
        idCliente.add(id);
    }
    public List<Integer> retornaClientes() {
        System.out.println(idCliente.get(1));
        return new ArrayList<>(idCliente);
    }
}