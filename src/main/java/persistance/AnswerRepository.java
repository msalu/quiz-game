package persistance;

import model.Answer;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AnswerRepository {
    private EntityManager entityManager;

    public AnswerRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Answer answer){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(answer);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Answer> answersWhereQuestionIdIsSame(int id){
        String sql = "FROM Answer WHERE Answer.question.questionId = :id";
        return entityManager.createQuery(sql).setParameter("id", id).getResultList();
    }
}
