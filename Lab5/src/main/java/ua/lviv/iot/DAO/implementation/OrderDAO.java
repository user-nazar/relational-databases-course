package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.IOrderDAO;
import ua.lviv.iot.model.OrderEntity;
import ua.lviv.iot.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    @Override
    public List<OrderEntity> findAll() throws Exception {
        List<OrderEntity> allEntities = new LinkedList<>();

        Session session = SessionManager.getSession();
        Query query = session.createQuery("FROM OrderEntity");
        for (Object obj : query.list()) {
            allEntities.add((OrderEntity) obj);
        }

        return allEntities;
    }

    @Override
    public OrderEntity findById(Integer id) throws Exception {
        Session session = SessionManager.getSession();
        return session.get(OrderEntity.class, id);
    }

    @Override
    public void create(OrderEntity entity) throws Exception {
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
    public void update(OrderEntity entity) throws Exception {
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
        OrderEntity orderEntity = session.get(OrderEntity.class, id);
        if (orderEntity != null) {
            session.delete(orderEntity);
        } else {
            System.out.println("No entity to delete");
        }
        session.getTransaction().commit();
    }
}
