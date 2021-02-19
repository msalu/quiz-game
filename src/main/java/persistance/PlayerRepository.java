package persistance;

import model.Player;
import util.DBUtil;

import javax.persistence.EntityManager;

public class PlayerRepository {
    private EntityManager entityManager;

    public PlayerRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Player player){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
