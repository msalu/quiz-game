package persistance;

import model.Question;
import util.DBUtil;

import javax.persistence.EntityManager;

public class QuestionRepository {
    private EntityManager entityManager;

    public QuestionRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Question question){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(question);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
