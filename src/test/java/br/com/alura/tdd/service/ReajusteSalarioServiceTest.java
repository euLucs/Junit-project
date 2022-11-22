package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteSalarioServiceTest {

    private Funcionario funcionario;
    private ReajusteSalarioService reajusteSalario;

    @BeforeEach
    public void inicializar() {
        this.funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal("1000"));
        this.reajusteSalario = new ReajusteSalarioService();
    }

    @Test
    void defineSeOSalarioFoiAjustado3PorcentoSeODesempenhoForADesejar() {
        reajusteSalario.modifica(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void defineSeOSalarioFoiAjustado15PorcentoSeODesempenhoForBom() {
        reajusteSalario.modifica(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void defineSeOSalarioFoiAjustado20PorcentoSeODesempenhoForOtimo() {
        reajusteSalario.modifica(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
