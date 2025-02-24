package Sistema.service;

public class PessoaFisicaService {
    private static double gastosCalculado = 0;
    public static double adicionaSalario(double salario) {
        if (salario < 0) throw new IllegalArgumentException("o salario nao pode ser menor que zero ");
        return salario;
    }
    public static double calculaGastos(double gastos) {
        if (gastos < 0 ) throw new IllegalArgumentException("gastos nao podem ser negativos");
        gastosCalculado += gastos;
        return gastosCalculado;
    }
}
