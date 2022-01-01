package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.CourierDAO;
import ua.lviv.iot.model.CourierEntity;

import java.util.List;

public class CourierService {
    public List<CourierEntity> findAll() throws Exception {
        return new CourierDAO().findAll();
    }

    public CourierEntity findById(Integer id) throws Exception {
        return new CourierDAO().findById(id);
    }

    public void create(CourierEntity entity) throws Exception {
        new CourierDAO().create(entity);
    }

    public void update(CourierEntity entity) throws Exception {
        new CourierDAO().update(entity);
    }

    public void delete(Integer id) throws Exception {
        new CourierDAO().delete(id);
    }
}
