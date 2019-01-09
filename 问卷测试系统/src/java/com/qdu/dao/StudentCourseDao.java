
package com.qdu.dao;

import com.qdu.pojo.StudentCourse;
import com.qdu.pojo.StudentCourseId;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentCourseDao {
    
    public List<StudentCourse> findCourseBySid(int sid){
        Session session=null;
        try{
            session=HibernateUtil.getSession();
            Query query=session.createQuery("from StudentCourse where studentId=:studentId ");
            query.setInteger("studentId", sid);
            List<StudentCourse> list=(List<StudentCourse>)query.list();
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
    //删除类别
    public void deleteStudentCourseById(int sid,String cid) {
        StudentCourseId studentId = new StudentCourseId(sid, cid);
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran=session.beginTransaction();
            StudentCourse scourse=(StudentCourse)session.load(StudentCourse.class,studentId);
            session.delete(scourse);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    //获取所有类别信息
        public List<StudentCourse> getAllStudentCourses(String cid){
        
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from StudentCourse where courseId=:courseId");
        query.setParameter("courseId", cid);
         List<StudentCourse> list=(List<StudentCourse>)query.list();
        if(list.size()!=0)
           return list;
        if(session!=null)
            session.close();
        
        return null;
    }
}
