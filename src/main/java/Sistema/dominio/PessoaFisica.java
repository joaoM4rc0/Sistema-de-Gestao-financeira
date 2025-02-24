package Sistema.dominio;

import Sistema.modelPessoa.Pessoa;
import Sistema.service.PessoaFisicaService;

public class PessoaFisica extends Pessoa {
    private double salario;
    private double saldoBanco;
    private double gastos;
    private double despesas;
    private double receitas;
    public PessoaFisica(String name, int idade, String dataDeNascimento, String cpf) {
        super(name, idade, dataDeNascimento, cpf);
    }

    public void adiconaSalario(double salario) {
        this.salario = PessoaFisicaService.adicionaSalario(salario);
    }
    public void calculaGastos(double gastos) {
        double gastosCalculados = PessoaFisicaService.calculaGastos(gastos);
        this.gastos = gastosCalculados;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getSaldoBanco() {
        return saldoBanco;
    }

    public void setSaldoBanco(double saldoBanco) {
        this.saldoBanco = saldoBanco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getReceitas() {
        return receitas;
    }

    public void setReceitas(double receitas) {
        this.receitas = receitas;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }
}
