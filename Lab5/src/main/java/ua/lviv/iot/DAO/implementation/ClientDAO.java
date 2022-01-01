package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.IClientDAO;
import ua.lviv.iot.model.ClientEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class ClientDAO implements IClientDAO {

    @Override
    public List<ClientEntity> findAll() throws Exception {
        List<ClientEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM ClientEntity");
        for (Object obj : query.list()) {
            allEntities.add((ClientEntity) obj);
        }

        return allEntities;
    }

    @Override
    public ClientEntity findById(Integer id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(ClientEntity.class, id);
    }

    @Override
    public void create(ClientEntity entity) throws Exception {
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
    public void update(ClientEntity entity) throws Exception {
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
        ClientEntity clientEntity = session.get(ClientEntity.class, id);
        if (clientEntity != null) {
            session.delete(clientEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
