package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.IAccountDAO;
import ua.lviv.iot.model.AccountEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    @Override
    public List<AccountEntity> findAll() throws Exception {
        List<AccountEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM AccountEntity");
        for (Object obj : query.list()) {
            allEntities.add((AccountEntity) obj);
        }

        return allEntities;
    }

    @Override
    public AccountEntity findById(Integer id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(AccountEntity.class, id);
    }

    @Override
    public void create(AccountEntity entity) throws Exception {
        Session session = SessionManager.getSession();

        if (entity != null) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } else {
            System.out.println("No entity to save");
        }
    }

    @Override
    public void update(AccountEntity entity) throws Exception {
        Session session = SessionManager.getSession();

        if (entity != null) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } else {
            System.out.println("No entity to update");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        Session session = SessionManager.getSession();

        session.beginTransaction();
        AccountEntity accountEntity = session.get(AccountEntity.class, id);
        if (accountEntity != null) {
            session.delete(accountEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
