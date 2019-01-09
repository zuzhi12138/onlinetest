
package com.qdu.dao;

import com.qdu.pojo.Manager;
import com.qdu.pojo.Student;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ManagerDao {
    //查询管理员
    public Manager findManagerBymnompwd(int mno,String mpwd){
        Session session=null;
        session=HibernateUtil.getSession();
        Query query=session.createQuery("from Manager where managerNo=:mno and managerPassword=:mpwd");
        query.setInteger("mno", mno);
        query.setString("mpwd", mpwd);
        List<Manager> list=(List<Manager>)query.list();
        if(list.size()!=0)
           return list.get(0);
        if(session!=null)
            session.close();
        
        return null;
    } 
    //管理员修改密码
    public void updateMpwd(int mno,String mpwd){
        Session session=null;
        session=HibernateUtil.getSession();
        Transaction tran=session.beginTransaction();
        Manager manager=(Manager)session.load(Manager.class,mno);
        manager.setManagerPassword(mpwd);
        session.update(manager);
        tran.commit();
        if(session!=null)
            session.close();
    }
    
    
}
