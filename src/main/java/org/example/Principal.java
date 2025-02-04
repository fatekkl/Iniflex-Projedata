package org.example;

import org.example.data.Banco;
import org.example.data.FuncionariosDAO;
import org.example.models.Funcionario;
import org.example.models.Pessoa;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class Principal {
    public static void main(String[] args) {
        Pessoa pessoa;
        Funcionario funcionario;


        BigDecimal salario_maria = BigDecimal.valueOf( 2009.44 );
        BigDecimal salario_joao = BigDecimal.valueOf( 2284.38 );
        BigDecimal salario_caio = BigDecimal.valueOf( 9836.14 );
        BigDecimal salario_miguel = BigDecimal.valueOf( 19119.88 );
        BigDecimal salario_alice = BigDecimal.valueOf( 2234.68 );
        BigDecimal salario_heitor = BigDecimal.valueOf( 1582.72 );
        BigDecimal salario_arthur = BigDecimal.valueOf( 4071.84 );
        BigDecimal salario_laura = BigDecimal.valueOf( 3017.45 );
        BigDecimal salario_heloisa = BigDecimal.valueOf( 1606.85 );
        BigDecimal salario_helena = BigDecimal.valueOf( 2799.93 );


        Funcionario maria = new Funcionario( "Maria", LocalDate.of( 2000, 10, 18 ), salario_maria, "Operador" );
        Funcionario joao = new Funcionario( "Joao", LocalDate.of( 1990, 5, 12 ), salario_joao, "Operador" );
        Funcionario caio = new Funcionario( "Caio", LocalDate.of( 1961, 5, 2 ), salario_caio, "Coordenador" );
        Funcionario miguel = new Funcionario( "Miguel", LocalDate.of( 1988, 10, 14 ), salario_miguel, "Diretor" );
        Funcionario alice = new Funcionario( "Alice", LocalDate.of( 1995, 1, 5 ), salario_alice, "Recepcionista" );
        Funcionario heitor = new Funcionario( "Heitor", LocalDate.of( 1999, 11, 19 ), salario_heitor, "Operador" );
        Funcionario arthur = new Funcionario( "Arthur", LocalDate.of( 1993, 3, 31 ), salario_arthur, "Contador" );
        Funcionario laura = new Funcionario( "Laura", LocalDate.of( 1994, 7, 19 ), salario_laura, "Gerente" );
        Funcionario heloisa = new Funcionario( "Heloisa", LocalDate.of( 2003, 5, 24 ), salario_heloisa, "Eletricista" );
        Funcionario helena = new Funcionario( "Helena", LocalDate.of( 1996, 9, 2 ), salario_helena, "Gerente" );

        Funcionario[] funcionariosArray = {maria, joao, caio, miguel, alice, heitor, arthur, laura, heloisa, helena};

        SessionFactory sessionFactory = Banco.getSessionFactory();

        FuncionariosDAO funcionariosDAO = new FuncionariosDAO( sessionFactory );


        /* ADICIONA TODOS OS FUNCIONARIOS NA LISTA */


        for (Funcionario funcionarioAtual : funcionariosArray) {
            funcionariosDAO.adicionar( funcionarioAtual );
        }

        funcionariosDAO.remover( joao.getId() );

        /* CAPTURA TODOS OS FUNCIONARIOS NA ORDEM DE INSERÇÃO */

        List funcionarios = funcionariosDAO.getFuncionarios();

        /* ATUALIZA O SALARIO DE CADA FUNCIONARIO EM MAIS 10% */


        BigDecimal salarioAtualizado_maria = salario_maria.add(maria.getPorcentagem( 0.10 ));
        BigDecimal salarioAtualizado_caio = salario_caio.add( caio.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_miguel = salario_miguel.add( miguel.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_alice = salario_alice.add( alice.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_heitor = salario_heitor.add( heitor.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_arthur = salario_arthur.add( arthur.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_laura = salario_laura.add( laura.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_heloisa = salario_heloisa.add( heloisa.getPorcentagem( 0.10 ) );
        BigDecimal salarioAtualizado_helena = salario_helena.add( helena.getPorcentagem( 0.10 ) );


        funcionariosDAO.atualizarSalario( 1, salarioAtualizado_maria );
        funcionariosDAO.atualizarSalario( 3, salarioAtualizado_caio );
        funcionariosDAO.atualizarSalario( 4, salarioAtualizado_miguel );
        funcionariosDAO.atualizarSalario( 5, salarioAtualizado_alice );
        funcionariosDAO.atualizarSalario( 6, salarioAtualizado_heitor );
        funcionariosDAO.atualizarSalario( 7, salarioAtualizado_arthur );
        funcionariosDAO.atualizarSalario( 8, salarioAtualizado_laura );
        funcionariosDAO.atualizarSalario( 9, salarioAtualizado_heloisa );
        funcionariosDAO.atualizarSalario( 10, salarioAtualizado_helena );

        /* FAZ O MAP COM A LISTA DE FUNCIONARIOS OPERADORES */

        List funcionariosPorFuncao = funcionariosDAO.getPorFuncao( "Operador" );

        Map<String, List> map = funcionariosDAO.toMap( funcionariosPorFuncao, "Operador" );

        System.out.println("Funcionarios por função(Usei Operador como exemplo):" + map);

        /* CAPTURA POR FUNÇÃO */


        /* CAPTURA TODOS QUE NASCERAM NOS MESES 10 E 12 */

        List<Funcionario> meses = funcionariosDAO.getPorMesesNascimento( 10, 12 );

        System.out.println("Todos que nasceram nos meses 10 e 12:" + meses);

        /* CAPTURA FUNCIONARIO MAIS VELHO */

        Map<String, Integer> funcionarioMaisVelho = funcionariosDAO.getMaisVelho();

        System.out.println("Funcionario mais veleho:" + funcionarioMaisVelho);


        /* CAPTURA OS FUNCIONARIOS POR ORDEM ALFABETICA */

        String funcionariosAlfabetica = funcionariosDAO.getFuncionariosAlfabetica();

        System.out.println(funcionariosAlfabetica);

        BigDecimal salarioTotal = funcionariosDAO.getSalarioTotal();

        System.out.println(salarioTotal);

        for (Object o : funcionarios) {
            Funcionario f = (Funcionario) o;
            System.out.println(f.getNome() + " - Salários Mínimos: " + f.getSalariosMinimos());
        }

        sessionFactory.close();

    }

}