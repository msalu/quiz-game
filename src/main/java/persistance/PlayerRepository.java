package persistance;

import model.Player;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    public Player findByName(String name){
        String sql = "FROM Player AS p WHERE p.name = :name";
        return (Player) entityManager.createQuery(sql).setParameter("name", name);
    }

    public List<Player> getLastEntry(){
        String sql = "FROM Player p ORDER BY p.playerId DESC";

        return entityManager.createQuery(sql).setMaxResults(1).getResultList();
    }
}
