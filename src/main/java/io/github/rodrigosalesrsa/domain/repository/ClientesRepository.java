package io.github.rodrigosalesrsa.domain.repository;

import io.github.rodrigosalesrsa.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientesRepository {

     @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente persiste(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente update(Cliente cliente) {
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void delete(Cliente cliente) {
        entityManager.remove(cliente);
    }

    @Transactional
    public void delete(Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }

    @Transactional
    public List<Cliente> listarTodos() {
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

}
