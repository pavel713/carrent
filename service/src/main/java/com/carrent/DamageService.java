package com.carrent;


import com.carrent.dao.DamageDAO;
import com.carrent.dao.DamageDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class DamageService implements DamageDAO {
    private static final String ADD_DAMAGE_QUERY = "INSERT INTO damage (id) VALUES (?,?,?,?);";
    private static final String FIND_DAMAGE = "SELECT * FROM damage where (id) VALUES (?)";
    private static final String FIND_ALL_DAMAGES = "SELECT * FROM damage";
    private static final String DELETE_DAMAGE = "DELETE FROM damage WHERE (id) VALUES (?)";
    private static DamageService INSTANCE = null;

    private DamageService() {}
    public static DamageService getInstance() {
        if (INSTANCE == null) {
            synchronized (DamageService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DamageService();
                }
            }
        }
        return INSTANCE;
    }






    @Override
    public Damage getByID(int id) {
        DamageDAOImpl.getInstance().getByID(id);

        return null;
    }

    public void update(Damage damage) {
        DamageDAOImpl.getInstance().update(damage);
    }

    public List<Damage> findAllDamages() throws SQLException, ClassNotFoundException {
        return DamageDAOImpl.getInstance().findAllDamages();
    }

    public void delete(Damage damage) {
        DamageDAOImpl.getInstance().delete(damage);
    }
}

