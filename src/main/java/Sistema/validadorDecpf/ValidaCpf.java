package Sistema.validadorDecpf;

public class ValidaCpf {
    public static boolean validaCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() < 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        //A expressão regular (\\d)\\1{10} verifica se todos os dígitos são iguais (por exemplo, 111.111.111-11).
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }
        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }
        //    O primeiro dígito verificador é calculado multiplicando
        //    cada um dos 9 primeiros dígitos por um peso decrescente (de 10 a 2) e somando os resultados.
        //    O segundo dígito verificador é calculado de forma semelhante mas inclui o primeiro dígito verificador no cálculo.
        // Verifica se os dígitos calculados são iguais aos dígitos do CPF*
        return Character.getNumericValue(cpf.charAt(9)) == primeiroDigito &&
                Character.getNumericValue(cpf.charAt(10)) == segundoDigito;
        //Exemplos de CPFs Válidos e Inválidos:
        //    Válidos:
        //
        //        123.456.789-09
        //
        //        529.982.247-25
        //
        //        111.444.777-35
        //    Inválidos:

        //        123.456.789-00 (dígitos verificadores incorretos)
        //
        //        111.111.111-11 (sequência repetida)
        //
        //        123 (tamanho incorreto)
    }
}
