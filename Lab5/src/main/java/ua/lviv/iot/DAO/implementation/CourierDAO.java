package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.ICourierDAO;
import ua.lviv.iot.model.CourierEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class CourierDAO implements ICourierDAO {

    @Override
    public List<CourierEntity> findAll() throws Exception {
        List<CourierEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM CourierEntity");
        for (Object obj : query.list()) {
            allEntities.add((CourierEntity) obj);
        }

        return allEntities;
    }

    @Override
    public CourierEntity findById(Integer id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(CourierEntity.class, id);
    }

    @Override
    public void create(CourierEntity entity) throws Exception {
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
    public void update(CourierEntity entity) throws Exception {
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
        CourierEntity courierEntity = session.get(CourierEntity.class, id);
        if (courierEntity != null) {
            session.delete(courierEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
