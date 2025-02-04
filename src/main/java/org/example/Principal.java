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

        // Salários dos funcionários
        BigDecimal salario_maria = BigDecimal.valueOf(2009.44);
        BigDecimal salario_joao = BigDecimal.valueOf(2284.38);
        BigDecimal salario_caio = BigDecimal.valueOf(9836.14);
        BigDecimal salario_miguel = BigDecimal.valueOf(19119.88);
        BigDecimal salario_alice = BigDecimal.valueOf(2234.68);
        BigDecimal salario_heitor = BigDecimal.valueOf(1582.72);
        BigDecimal salario_arthur = BigDecimal.valueOf(4071.84);
        BigDecimal salario_laura = BigDecimal.valueOf(3017.45);
        BigDecimal salario_heloisa = BigDecimal.valueOf(1606.85);
        BigDecimal salario_helena = BigDecimal.valueOf(2799.93);

        // Criação dos funcionários
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), salario_maria, "Operador");
        Funcionario joao = new Funcionario("Joao", LocalDate.of(1990, 5, 12), salario_joao, "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), salario_caio, "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), salario_miguel, "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), salario_alice, "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), salario_heitor, "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), salario_arthur, "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 19), salario_laura, "Gerente");
        Funcionario heloisa = new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), salario_heloisa, "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), salario_helena, "Gerente");

        Funcionario[] funcionariosArray = {maria, joao, caio, miguel, alice, heitor, arthur, laura, heloisa, helena};

        SessionFactory sessionFactory = Banco.getSessionFactory();
        FuncionariosDAO funcionariosDAO = new FuncionariosDAO(sessionFactory);

        System.out.println("\n===============================");
        System.out.println("📌 Adicionando funcionários...");
        System.out.println("===============================\n");

        for (Funcionario funcionarioAtual : funcionariosArray) {
            funcionariosDAO.adicionar(funcionarioAtual);
            System.out.println("✅ Adicionado: " + funcionarioAtual.getNome());
        }

        funcionariosDAO.remover(joao.getId());
        System.out.println("\n🚫 João foi removido da lista.\n");

        System.out.println("===============================");
        System.out.println("📌 Atualizando salários (+10%)");
        System.out.println("===============================\n");

        for (Funcionario f : funcionariosArray) {
            BigDecimal novoSalario = f.getSalario().add(f.getPorcentagem(0.10));
            funcionariosDAO.atualizarSalario(f.getId(), novoSalario);
            System.out.printf("💰 %s: Novo salário: R$ %.2f\n", f.getNome(), novoSalario);
        }

        System.out.println("\n===============================");
        System.out.println("📌 Listando funcionários");
        System.out.println("===============================\n");

        List<Funcionario> funcionarios = funcionariosDAO.getFuncionarios();
        for (Funcionario f : funcionarios) {
            System.out.printf("👤 Nome: %-10s | Cargo: %-15s | Salário: R$ %.2f\n",
                    f.getNome(), f.getFuncao(), f.getSalario());
        }

        System.out.println("\n===============================");
        System.out.println("📌 Funcionários em ordem alfabética");
        System.out.println("===============================\n");

        List<Funcionario> funcionariosOrdenados = funcionariosDAO.getFuncionariosAlfabetica();

        if (funcionariosOrdenados.isEmpty()) {
            System.out.println("❌ Nenhum funcionário encontrado.");
        } else {
            System.out.printf("┌──────┬───────────┬────────────┬──────────────┬────────────┐\n");
            System.out.printf("│ %-4s │ %-9s │ %-10s │ %-12s │ %-10s │\n", "ID", "Nome", "Nascimento", "Salário", "Função");
            System.out.printf("├──────┼───────────┼────────────┼──────────────┼────────────┤\n");

            for (Funcionario f : funcionariosOrdenados) {
                System.out.printf("│ %-4d │ %-9s │ %-10s │ R$ %-10.2f │ %-10s │\n",
                        f.getId(),
                        f.getNome(),
                        f.getDataNascimento(),
                        f.getSalario(),
                        f.getFuncao());
            }

            System.out.printf("└──────┴───────────┴────────────┴──────────────┴────────────┘\n");
        }

        System.out.println("\n===============================");
        System.out.println("📌 Salário total da empresa");
        System.out.println("===============================\n");

        BigDecimal salarioTotal = funcionariosDAO.getSalarioTotal();
        System.out.printf("💰 Salário total de todos os funcionários: R$ %.2f\n", salarioTotal);

        System.out.println("\n===============================");
        System.out.println("📌 Quantidade de salários mínimos");
        System.out.println("===============================\n");

        for (Funcionario f : funcionarios) {
            System.out.printf("📊 %s - Salários Mínimos: %.2f\n", f.getNome(), f.getSalariosMinimos());
        }

        sessionFactory.close();
    }
}
