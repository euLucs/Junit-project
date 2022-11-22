package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteSalarioService {
    public void modifica(Funcionario funcionario, Desempenho desempenho) {
        funcionario.modificaSalario(funcionario
                .getSalario()
                .multiply(desempenho.reajustePercentual()));
    }
}
