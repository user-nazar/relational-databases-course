package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.AccountDAO;
import ua.lviv.iot.model.AccountEntity;

import java.util.List;

public class AccountService {
    public List<AccountEntity> findAll() throws Exception {
        return new AccountDAO().findAll();
    }

    public AccountEntity findById(Integer id) throws Exception {
        return new AccountDAO().findById(id);
    }

    public void create(AccountEntity entity) throws Exception {
        new AccountDAO().create(entity);
    }

    public void update(AccountEntity entity) throws Exception {
        new AccountDAO().update(entity);
    }

    public void delete(Integer id) throws Exception {
        new AccountDAO().delete(id);
    }
}
