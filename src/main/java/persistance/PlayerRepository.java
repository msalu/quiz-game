package persistance;

import model.DifficultyLevel;
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

    public Player getLastEntry(){
        String sql = "FROM Player p ORDER BY p.playerId DESC";

        return entityManager.createQuery(sql, Player.class).setMaxResults(1).getSingleResult();
    }

    public void update(Player player){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(player);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
