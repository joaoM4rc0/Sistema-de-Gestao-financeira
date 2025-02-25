package Sistema.service;

public class PessoaFisicaService {
    private static double gastosCalculado = 0;
    private static double salarioCalculado;
    private static double saldo;
    private static double receita;

    public static double adicionaSalario(double salario) {
        if (salario < 0) throw new IllegalArgumentException("o salario nao pode ser menor que zero ");
        salarioCalculado = salario;
        return salario;
    }
    public static double adicionaReceita(double valor) {
        if (valor < 0 ) throw new IllegalArgumentException("receita nao pode ser menor que 0");
        receita += valor;
        return receita;
    }
    public static double calculaGastos(double gastos) {
        if (gastos < 0 ) throw new IllegalArgumentException("gastos nao podem ser negativos");
        gastosCalculado += gastos;
        return gastosCalculado;
    }
    public static double calculaSaldoDaConta() {
       saldo = (receita + salarioCalculado) - gastosCalculado;
       return saldo;
    }
}
