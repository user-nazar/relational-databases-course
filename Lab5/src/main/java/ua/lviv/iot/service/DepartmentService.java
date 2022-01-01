package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.DepartmentDAO;
import ua.lviv.iot.model.DepartmentEntity;

import java.util.List;

public class DepartmentService {
    public List<DepartmentEntity> findAll() throws Exception {
        return new DepartmentDAO().findAll();
    }

    public DepartmentEntity findById(Integer id) throws Exception {
        return new DepartmentDAO().findById(id);
    }

    public void create(DepartmentEntity entity) throws Exception {
        new DepartmentDAO().create(entity);
    }

    public void update(DepartmentEntity entity) throws Exception {
        new DepartmentDAO().update(entity);
    }

    public void delete(Integer id) throws Exception {
        new DepartmentDAO().delete(id);
    }
}
