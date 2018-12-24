
package com.qdu.dao;

import com.qdu.pojo.Student;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentDao {
    //查
    public Student findStudentBystidspwd(int stId,String spwd){
        Session session=null;
        session=HibernateUtil.getSession();
        Query query=session.createQuery("from Student where studentId=:stId and studentPassword=:spwd");
        query.setInteger("stId", stId);
        query.setString("spwd", spwd);
        List<Student> list=(List<Student>)query.list();
        if(list.size()!=0)
           return list.get(0);
        if(session!=null)
            session.close();
        
        return null;
    } 
    //修改密码
    public void updateSpwd(int sid,String spwd){
        Session session=null;
        session=HibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        Student student=(Student)session.load(Student.class,sid);
        student.setStudentPassword(spwd);
        session.update(student);
        tran.commit();
        if(session!=null)
            session.close();
    }
    //修改年龄和手机
    public void updateSInfo(int sid,int sage,String smobile){
        Session session=null;
        session=HibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        Student student=(Student)session.load(Student.class,sid);
        student.setStudentAge(sage);
        student.setStudentMobile(smobile);
        session.update(student);
        tran.commit();
        if(session!=null)
            session.close();
    }
    //保存学生注册信息
    public int insert(Student student) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(student);
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
