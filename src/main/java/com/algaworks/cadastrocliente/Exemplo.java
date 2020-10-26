package com.algaworks.cadastrocliente;

import com.algaworks.cadastrocliente.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("Clientes-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*
        * Localizar um cliente.
        * */
//        Cliente cliente = entityManager.find(Cliente.class, 1);
//        System.out.println(cliente.getNome());
//        Cliente cliente = new Cliente();

        /*
        * Inserção de registros. Anotar o id com @GeneratedValue(strategy = GenerationType.IDENTITY).
        * */
//        cliente.setId(2);
//        cliente.setNome("Açougue Patrão");
//        entityManager.getTransaction().begin();
//        entityManager.persist(cliente);
//        entityManager.getTransaction().commit();

        /*
        * Excluir um cliente.
        * */
//        Cliente cliente = entityManager.find(Cliente.class,2);
//        entityManager.getTransaction().begin();
//        entityManager.remove(cliente);
//        entityManager.getTransaction().commit();

        /*
        * Teste do cache
        * */
//        Cliente cliente = entityManager.find(Cliente.class,1);
//        Cliente cliente2 = entityManager.find(Cliente.class, 1);

        /*
        * Atualizar cliente.
        * */
//        Cliente cliente = entityManager.find(Cliente.class, 1); // Objeto gerenciado.
//        entityManager.getTransaction().begin();
//        cliente.setNome(cliente.getNome() + " :: Atualizado");
//        entityManager.getTransaction().commit();

        /* Objeto não gerenciado */
        Cliente cliente = new Cliente();
//        cliente.setId(1);
//        cliente.setNome("Padaria Dom João");

        /**
         * Caso o identificador não tenha sido fornecido o Hibernate entenderá a operação como uma inserção.
         * */
        cliente.setNome("Drogaria Atlas");

        entityManager.getTransaction().begin();
        /*
        * Como o identificador foi especificado, o Hibernate executará uma atualização do cliente.
        * */
        entityManager.merge(cliente); // O Hibernate passa a gerenciar o objeto.
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
