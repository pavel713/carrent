package com.carrent;


import com.carrent.dao.ClientDAO;
import com.carrent.dao.ClientDAOImpl;

import java.util.List;


public class ClientService implements ClientDAO {

    private static final String FIND_CLIENT = "SELECT * FROM client where name=?";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE id=?";
    private static ClientService INSTANCE = null;

    private ClientService() {
    }

    public static ClientService getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientService();
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public Client getByID(long id) {
        ClientDAOImpl.getInstance().getByID(id);

        return null;
    }


    @Override
    public void addClient(Client client) {
        ClientDAOImpl.getInstance().addClient(client);
    }


    @Override
    public List<Client> findAllClients() {
        return ClientDAOImpl.getInstance().findAllClients();
    }


    @Override
    public void delete(Client client) {
        ClientDAOImpl.getInstance().delete(client);
    }


}




