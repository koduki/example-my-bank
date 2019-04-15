/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.mybank;

import java.util.List;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Account Management Service.
 *
 * @author koduki
 */
@ApplicationScoped
public class AccountService {

    @Inject
    EntityManager em;

    @Transactional
    public void create(long amount) {
        Account account = new Account();
        account.setAmount(amount);
        em.persist(account);
    }

    @Transactional
    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM Account a", Account.class)
                .setMaxResults(3)
                .getResultList();
    }

    @Transactional
    public Account deposit(UUID id, long amount) {
        em.createQuery("UPDATE Account SET amount = amount + :amount WHERE id=:id")
                .setParameter("id", id)
                .setParameter("amount", amount)
                .executeUpdate();
        return em.createQuery("SELECT a FROM Account a WHERE id=:id", Account.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public Account withdraw(UUID id, long amount) {
        em.createQuery("UPDATE Account SET amount = amount - :amount WHERE id=:id")
                .setParameter("id", id)
                .setParameter("amount", amount)
                .executeUpdate();
        return em.createQuery("SELECT a FROM Account a WHERE id=:id", Account.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
