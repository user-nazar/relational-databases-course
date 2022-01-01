package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.DepartmentTypeDAO;
import ua.lviv.iot.model.DepartmentTypeEntity;

import java.util.List;

public class DepartmentTypeService {
    public List<DepartmentTypeEntity> findAll() throws Exception {
        return new DepartmentTypeDAO().findAll();
    }

    public DepartmentTypeEntity findById(String id) throws Exception {
        return new DepartmentTypeDAO().findById(id);
    }

    public void create(DepartmentTypeEntity entity) throws Exception {
        new DepartmentTypeDAO().create(entity);
    }

    public void update(DepartmentTypeEntity entity) throws Exception {
        new DepartmentTypeDAO().update(entity);
    }

    public void delete(String id) throws Exception {
        new DepartmentTypeDAO().delete(id);
    }
}
