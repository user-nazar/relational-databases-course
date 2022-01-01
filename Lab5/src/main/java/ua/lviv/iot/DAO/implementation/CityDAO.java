package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.ICityDAO;
import ua.lviv.iot.model.CityEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class CityDAO implements ICityDAO {
    @Override
    public List<CityEntity> findAll() throws Exception {
        List<CityEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM CityEntity");
        for (Object obj : query.list()) {
            allEntities.add((CityEntity) obj);
        }

        return allEntities;
    }

    @Override
    public CityEntity findById(String id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(CityEntity.class, id);    }

    @Override
    public void create(CityEntity entity) throws Exception {
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
    public void update(CityEntity entity) throws Exception {
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
    public void delete(String id) throws Exception {
        Session session = SessionManager.getSession();

        session.beginTransaction();
        CityEntity cityEntity = session.get(CityEntity.class, id);
        if (cityEntity != null) {
            session.delete(cityEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
