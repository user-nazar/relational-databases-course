package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.IDepartmentTypeDAO;
import ua.lviv.iot.model.DepartmentTypeEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class DepartmentTypeDAO implements IDepartmentTypeDAO {

    @Override
    public List<DepartmentTypeEntity> findAll() throws Exception {
        List<DepartmentTypeEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM DepartmentTypeEntity");
        for (Object obj : query.list()) {
            allEntities.add((DepartmentTypeEntity) obj);
        }

        return allEntities;
    }

    @Override
    public DepartmentTypeEntity findById(String id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(DepartmentTypeEntity.class, id);
    }

    @Override
    public void create(DepartmentTypeEntity entity) throws Exception {
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
    public void update(DepartmentTypeEntity entity) throws Exception {
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
        DepartmentTypeEntity departmentTypeEntity = session.get(DepartmentTypeEntity.class, id);
        if (departmentTypeEntity != null) {
            session.delete(departmentTypeEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
