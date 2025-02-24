package Sistema.dominio;

import Sistema.modelPessoa.Pessoa;

public class PessoaFisica extends Pessoa {
    private double salario;
    private double saldoBanco;
    private double despesas;
    private double receitas;
    public PessoaFisica(String name, int idade, String dataDeNascimento, String cpf) {
        super(name, idade, dataDeNascimento, cpf);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "saldoBanco=" + saldoBanco +
                ", salario=" + salario +
                ", receitas=" + receitas +
                ", despesas=" + despesas +
                '}';
    }
    public void adiconaSalario(double salario) {

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
