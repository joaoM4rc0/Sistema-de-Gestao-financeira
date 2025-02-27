package Sistema.service;

import Sistema.repository.BancoRepository;

import java.util.Scanner;

public class BancoService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void insertCliente() {
        System.out.println("digite o nome e em seguida o seu cpf");
        String name = SCANNER.nextLine();
        String cpf = SCANNER.nextLine();
        BancoRepository.InsertCliente(name, cpf);
    }
}
