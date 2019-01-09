package com.qdu.dao;

import com.qdu.pojo.Question;
import com.qdu.pojo.QuestionId;
import com.qdu.util.HibernateUtil;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QuestionDao {
//查找试题

    public HashMap<Integer, Question> getQuestionsByCourseId(String courseId) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Question where courseId=:cid"); //创建一个HQL查询
        query.setString("cid", courseId); //设置参数cid的值，为字符串类型
        List<Question> list = (List<Question>) query.list();

        if (list.isEmpty()) {
            return null; //如果没有数据，返回null
        }
        HashMap<Integer, Question> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i + 1, list.get(i));
        }

        return map;
    }

    //添加问题
    public void insert(String desc, String A, String B, String C, String D, String key, int credit, int stid, String cid) {
        Question g = new Question();
        QuestionId qid = new QuestionId(stid, cid);
        g.setId(qid);
        g.setQuestionDesc(desc);
        g.setAnswerA(A);
        g.setAnswerB(B);
        g.setAnswerC(C);
        g.setAnswerD(D);
        g.setAnswerKey(key);
        g.setCredit(credit);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(g);
        session.getTransaction().commit();
        session.close();
    }

    //获取所有试题信息
    public List<Question> getAllQuestions() {

        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Question");
        List<Question> list = (List<Question>) query.list();
        if (list.size() != 0) {
            return list;
        }
        if (session != null) {
            session.close();
        }

        return null;
    }

    //删除试题
    public void deleteQuestionById(int qid, String cid) {
        QuestionId questionId = new QuestionId(qid, cid);
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Question question = (Question) session.load(Question.class, questionId);
            session.delete(question);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //更改类别信息
    public void updateQuestion(int qid, String cid, String desc, String A, String B, String C, String D, String key, int credit) {
            Session session = null;
            QuestionId questionId = new QuestionId(qid, cid);
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Question question = (Question) session.load(Question.class, questionId);
            question.setQuestionDesc(desc);
            question.setAnswerA(A);
            question.setAnswerB(B);
            question.setAnswerC(C);
            question.setAnswerD(D);
            question.setAnswerKey(key);
            question.setCredit(credit);
            session.update(question);
            tran.commit();
            if (session != null) {
                session.close();
        }
    }

}
