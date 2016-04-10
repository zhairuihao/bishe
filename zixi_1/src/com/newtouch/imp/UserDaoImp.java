package com.newtouch.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newtouch.dao.UserDao;
import com.newtouch.entity.User;

@SuppressWarnings("unchecked")
public class UserDaoImp extends HibernateDaoSupport implements UserDao {

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getSex());
		this.getHibernateTemplate().save(user);
		
	}

	@Override
	public User byUsername(String username) {
		// TODO Auto-generated method stub
		String hql="from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql,username);
		
		if(list.size()==0)  {  return null;}
		else  {return list.get(0);}
	}

	@Override
	public List<User> queryAll(int popedom) {//根据权限查询
		// TODO Auto-generated method stub
		String hql = "from User where popedom = ?";
		List<User> list = this.getHibernateTemplate().find(hql,popedom);
		return list;
	}

	@Override
	public void updateUser(int userId ,int popedom) {//跟新用户权限123
		// TODO Auto-generated method stub
		User user = new User();
		user = (User) getHibernateTemplate().get(User.class, userId);
		user.setPopedom(popedom);
		getHibernateTemplate().save(user);
		
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	@Override
	public void deleteUser(int userId ,int d_delete) {//软删除 跟新d_delete字段0 1
		// TODO Auto-generated method stub	
		User user = new User();
		user = (User) getHibernateTemplate().get(User.class, userId);
		user.setD_delete(d_delete);
		getHibernateTemplate().save(user);

	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from User ";
		List<User> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public User byUsername(String username, String password) {
		// TODO Auto-generated method stub
		String hql="from User where username = ? and password = ?";
		List<User> list = this.getHibernateTemplate().find(hql,new Object[]{username,password});
		if(list.size()==0)    return null;
		else  return list.get(0);
	}


}
