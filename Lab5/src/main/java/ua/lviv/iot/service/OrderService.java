package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.OrderDAO;
import ua.lviv.iot.model.OrderEntity;

import java.util.List;

public class OrderService {
    public List<OrderEntity> findAll() throws Exception {
        return new OrderDAO().findAll();
    }

    public OrderEntity findById(Integer id) throws Exception {
        return new OrderDAO().findById(id);
    }

    public void create(OrderEntity entity) throws Exception {
        new OrderDAO().create(entity);
    }

    public void update(OrderEntity entity) throws Exception {
        new OrderDAO().update(entity);
    }

    public void delete(Integer id) throws Exception {
        new OrderDAO().delete(id);
    }
}
