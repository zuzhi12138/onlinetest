
package com.qdu.dao;

import com.qdu.pojo.Grade;
import com.qdu.pojo.GradeId;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class GradeDao {
    //提交成绩
    public void submitGrade(int studentId,String courseId,int grade,String date){
        Grade g=new Grade();
        GradeId gid=new GradeId(studentId,courseId);
        g.setGradeId(gid);
        g.setStudentGrade(grade);
        g.setFinishDate(date);
        
        Session session=HibernateUtil.getSession();
        session.beginTransaction();
        session.save(g);
        session.getTransaction().commit();
        session.close();
    }
    
    //获取所有成绩
        public List<Grade> getAllGrades(){
        
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Grade");
         List<Grade> list=(List<Grade>)query.list();
        if(list.size()!=0)
           return list;
        if(session!=null)
            session.close();
        return null;
    }

    
public List<Grade> findGradeBySid(int sid) {
        Session session=null;
        try{
            session=HibernateUtil.getSession();
            Query query=session.createQuery("from Grade where studentId=:studentId ");
            query.setInteger("studentId", sid);
            List<Grade> list=(List<Grade>)query.list();
            if(list.size()!=0) 
                return list; 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session!=null)
                session.close();
        }
        return null;
    }

}
