package Sistema.service;

public class PessoaFisicaService {
    private static double gastosCalculado = 0;
    private static double salarioCalculado;
    private static double saldo;
    private static double receita;

    public static double adicionaSalario(double salario) {
        returnsAnExceptionIfValueIsLessThanZero(salario);
        salarioCalculado = salario;
        return salario;
    }
    public static double adicionaReceita(double valor) {
        returnsAnExceptionIfValueIsLessThanZero(valor);
        receita += valor;
        return receita;
    }
    public static double calculaGastos(double gastos) {
        returnsAnExceptionIfValueIsLessThanZero(gastos);
        gastosCalculado += gastos;
        return gastosCalculado;
    }
    public static double calculaSaldoDaConta() {
       saldo = (receita + salarioCalculado) - gastosCalculado;
       return saldo;
    }
    private static void returnsAnExceptionIfValueIsLessThanZero(double valor) {
        if (valor < 0 ) throw new IllegalArgumentException("receita nao pode ser menor que 0");
    }
}
