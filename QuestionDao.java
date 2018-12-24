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
}
