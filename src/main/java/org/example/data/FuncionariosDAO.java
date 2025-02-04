package org.example.data;

import org.example.models.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;

public class FuncionariosDAO {

    private final SessionFactory sessionFactory;

    public FuncionariosDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List getFuncionarios() {

        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery( "FROM Funcionario", Funcionario.class );

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void adicionar(Funcionario funcionario) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save( funcionario );

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery( "delete from Funcionario where id = :id" );
            query.setParameter( "id", id );
            query.executeUpdate();

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarSalario(int id, BigDecimal novoSalario) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery( "update Funcionario set salario = :novoSalario where id = :id" );
            query.setParameter( "novoSalario", novoSalario );
            query.setParameter( "id", id );
            int result = query.executeUpdate();
            transaction.commit();

            session.close();
            if (result > 0) {
                System.out.println( "Salário atualizado" );
            } else {
                System.out.println( "Nenhum funcionário encontrado com o ID fornecido" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Funcionario> getPorFuncao(String funcao) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(
                    "FROM Funcionario WHERE funcao = :funcao", Funcionario.class );

            query.setParameter( "funcao", funcao );

            return query.getResultList();
        }
    }

    public Map<String, List> toMap(List lista, String funcao) {
        try (Session session = sessionFactory.openSession()) {
            HashMap<String, List> map = new HashMap<>();

            map.put( funcao, lista );

            session.close();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Funcionario> getPorMesesNascimento(int mes1, int mes2) {

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(
                    "FROM Funcionario WHERE MONTH(dataNascimento) IN (:mes1, :mes2)",
                    Funcionario.class
            );

            query.setParameter( "mes1", mes1 );
            query.setParameter( "mes2", mes2 );


            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Map<String, Integer> getMaisVelho() {

        try (Session session = sessionFactory.openSession();) {
            Query query = session.createQuery(
                    "FROM Funcionario ORDER BY dataNascimento ASC",
                    Funcionario.class
            );

            query.setMaxResults( 1 );

            List<Funcionario> funcionarios = query.getResultList();

            Funcionario funcionario = funcionarios.get( 0 );

            Map<String, Integer> map = new HashMap<>();

            map.put( funcionario.getNome(), funcionario.getIdade() );

            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getFuncionariosAlfabetica() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(
                    "FROM Funcionario f ORDER BY f.nome ASC",
                    Funcionario.class
            );
            return query.getResultList().toString();
        }
    }

    public BigDecimal getSalarioTotal() {
        try (Session session = sessionFactory.openSession()) {
            org.hibernate.query.Query<?> query;
            query = session.createQuery(
                    "SELECT SUM(f.salario) FROM Funcionario f",
                    BigDecimal.class
            );
            BigDecimal somaSalarios = (BigDecimal) query.uniqueResult();
            return somaSalarios;
        }

    }
}
