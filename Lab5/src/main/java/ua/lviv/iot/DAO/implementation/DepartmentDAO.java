package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.IDepartmentDAO;
import ua.lviv.iot.model.DepartmentEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class DepartmentDAO implements IDepartmentDAO {

    @Override
    public List<DepartmentEntity> findAll() throws Exception {
        List<DepartmentEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM DepartmentEntity");
        for (Object obj : query.list()) {
            allEntities.add((DepartmentEntity) obj);
        }

        return allEntities;
    }

    @Override
    public DepartmentEntity findById(Integer id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(DepartmentEntity.class, id);
    }

    @Override
    public void create(DepartmentEntity entity) throws Exception {
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
    public void update(DepartmentEntity entity) throws Exception {
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
        DepartmentEntity departmentEntity = session.get(DepartmentEntity.class, id);
        if (departmentEntity != null) {
            session.delete(departmentEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
