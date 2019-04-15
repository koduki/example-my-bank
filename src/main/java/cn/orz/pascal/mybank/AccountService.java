/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.mybank;

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
}
