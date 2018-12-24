
package com.qdu.dao;

import com.qdu.pojo.Course;
import com.qdu.util.HibernateUtil;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDao {
    
    public HashMap getCourses(){
        
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("select courseId,courseName from Course");
        List<Object[]> list=(List<Object[]>)query.list();
        
        if(list.isEmpty()) return null;//如果list没有数据，直接返回null
        
        HashMap map=new HashMap(); //实例化一个HashMap集合
        
        for(Object[] x:list){ 
            map.put(x[1],x[0]); //将课程名称和课程编号放入Map集合
        }
        
        return map; //返回Map集合
        
    }
    //获取所有课程信息
        public List<Course> getAllCourses(){
        
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Course");
         List<Course> list=(List<Course>)query.list();
        if(list.size()!=0)
           return list;
        if(session!=null)
            session.close();
        
        return null;
    }
    
    //删除课程
    public void deleteCourseById(String cid) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran=session.beginTransaction();
            Course course=(Course)session.load(Course.class,cid);
            session.delete(course);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    //更改课程信息
    public void updateCourse(String cid,String cname,int credit,String cmodule) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran=session.beginTransaction();
            Course course=(Course)session.load(Course.class, cid); 
            course.setCourseName(cname);
            course.setCredit(credit);
            course.setCmodule(cmodule);
            session.update(course);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    //添加课程信息
    public int insert(Course course) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(course);
            tran.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    
}
