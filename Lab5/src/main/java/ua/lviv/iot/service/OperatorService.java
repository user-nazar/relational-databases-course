package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.OperatorDAO;
import ua.lviv.iot.model.OperatorEntity;

import java.util.List;

public class OperatorService {
    public List<OperatorEntity> findAll() throws Exception {
        return new OperatorDAO().findAll();
    }

    public OperatorEntity findById(Integer id) throws Exception {
        return new OperatorDAO().findById(id);
    }

    public void create(OperatorEntity entity) throws Exception {
        new OperatorDAO().create(entity);
    }

    public void update(OperatorEntity entity) throws Exception {
        new OperatorDAO().update(entity);
    }

    public void delete(Integer id) throws Exception {
        new OperatorDAO().delete(id);
    }
}
