package Sistema.service;

import Sistema.dominio.Banco;
import Sistema.dominio.ClienteCadastrado;
import Sistema.repository.BancoRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BancoService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void insertCliente() {
        System.out.println("digite o nome e em seguida o seu cpf");
        String name = SCANNER.nextLine();
        String cpf = SCANNER.nextLine();
        BancoRepository.InsertCliente(name, cpf);
    }
    public static void UpdateClienteSaldo() {
        System.out.println("digite o valor que voce vai adicionar ao banco");
        int valor = SCANNER.nextInt();
        if (valor < 0) throw new IllegalArgumentException("voce nao pode adicionar um valor negativo");
        System.out.println("digite o id que vc quer adicionar esse valor");
        int id = SCANNER.nextInt();
        BancoRepository.updateSaldo(valor, id);
    }
    public static void findById(){
        System.out.println("digite o id que vc quer encontrar");
        int id = SCANNER.nextInt();
        Optional<ClienteCadastrado> cliente = BancoRepository.findById(id);
        Banco banco = new Banco();

    }
}
