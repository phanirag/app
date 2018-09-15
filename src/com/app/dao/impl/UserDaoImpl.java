package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUser(User user) {
		return (int) ht.save(user);
	}

	@Override
	public User getUserByNameAndPwd(String userName, String Password) {
		User user=null;
		String hql="from "+User.class.getName()
				+" where (userEmail=? or userContact=?) and userPwd=? ";
		@SuppressWarnings("unchecked")
		List<User> list=ht.find(hql,userName,userName,Password);
		if(list!=null && list.size()>0){
			user=list.get(0);
		}
		return user;
	}
}
