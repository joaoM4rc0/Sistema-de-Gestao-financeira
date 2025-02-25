package Sistema.test;

import Sistema.dominio.PessoaFisica;

import java.text.DecimalFormat;

public class PessoaTest01 {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica("joao marco", 18, "26/02/2005", "111.177.555.08");
        pessoaFisica.adiconaSalario(4520.80);
        pessoaFisica.calculaGastos(3000);
        pessoaFisica.calculaGastos(500);
        pessoaFisica.calculaGastos(500);
        pessoaFisica.adicionaReceitas(50);
        pessoaFisica.saldoDoBanco();
        System.out.println(pessoaFisica.getSalario());
        System.out.println(pessoaFisica.getGastos());
        System.out.println(new DecimalFormat("#.00").format(pessoaFisica.getSaldoBanco()));

    }
}
