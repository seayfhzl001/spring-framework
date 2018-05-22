package com.jll.pay;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl
  extends HibernateDaoSupport
  implements PaymentDao
{
  @Autowired
  public void setSuperSessionFactory(SessionFactory sessionFactory)
  {
    super.setSessionFactory(sessionFactory);
  }
  
  public long queryDepositTimes(String userName)
  {
    String sql = "select count(*) from TbBankback where userName=? and (backType='存款' or (backType='收入' and backTypeText='用户存款'))";
    Query query = getSessionFactory().getCurrentSession().createQuery(sql);
    query.setParameter(0, userName);
    
    long count = ((Number)query.iterate().next()).longValue();
    return count;
  }
}
