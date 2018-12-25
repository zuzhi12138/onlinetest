
package com.qdu.dao;

import com.qdu.pojo.TestApplication;
import com.qdu.pojo.TestApplicationId;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestApplicationDao {
    
    public void updateTestApplication(int sid,String cid,String application){
        TestApplicationId testapplicationId=new TestApplicationId(sid,cid);
        Session session=null;
        try{
            session=HibernateUtil.getSession();
            Transaction tran=session.beginTransaction();
            TestApplication testapplication=(TestApplication)session.load(TestApplication.class,testapplicationId);
            testapplication.setApplication(application);
            session.update(testapplication);
            tran.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    //获取所有申请考试信息
        public List<TestApplication> getAllTestApplication(String application){
        
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from TestApplication where application=:application");
        query.setParameter("application", application);
         List<TestApplication> list=(List<TestApplication>)query.list();
        if(list.size()!=0)
           return list;
        if(session!=null)
            session.close();
        return null;
    }
    
}
