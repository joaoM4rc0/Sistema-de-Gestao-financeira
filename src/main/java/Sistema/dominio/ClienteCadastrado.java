package Sistema.dominio;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class ClienteCadastrado {
    private List<String> cpfCliente = new ArrayList<>(0);
    private String name;
    private Integer id;
    private String cpf;
    public void adicionaCpfCliente(String cpf) {
        cpfCliente.add(cpf);
    }
    public List<String> retornaCpfCliente() {
        return cpfCliente;
    }
}
