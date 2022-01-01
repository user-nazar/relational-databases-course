package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.ClientDAO;
import ua.lviv.iot.model.ClientEntity;

import java.util.List;

public class ClientService {
    public List<ClientEntity> findAll() throws Exception {
        return new ClientDAO().findAll();
    }

    public ClientEntity findById(Integer id) throws Exception {
        return new ClientDAO().findById(id);
    }

    public void create(ClientEntity entity) throws Exception {
        new ClientDAO().create(entity);
    }

    public void update(ClientEntity entity) throws Exception {
        new ClientDAO().update(entity);
    }

    public void delete(Integer id) throws Exception {
        new ClientDAO().delete(id);
    }
}
