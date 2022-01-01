package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.IOperatorDAO;
import ua.lviv.iot.model.OperatorEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class OperatorDAO implements IOperatorDAO {

    @Override
    public List<OperatorEntity> findAll() throws Exception {
        List<OperatorEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM OperatorEntity");
        for (Object obj : query.list()) {
            allEntities.add((OperatorEntity) obj);
        }

        return allEntities;
    }

    @Override
    public OperatorEntity findById(Integer id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(OperatorEntity.class, id);
    }

    @Override
    public void create(OperatorEntity entity) throws Exception {
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
    public void update(OperatorEntity entity) throws Exception {
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
        OperatorEntity operatorEntity = session.get(OperatorEntity.class, id);
        if (operatorEntity != null) {
            session.delete(operatorEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
