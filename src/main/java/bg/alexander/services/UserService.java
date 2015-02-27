package bg.alexander.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.alexander.model.user.Role;
import bg.alexander.model.user.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	public List<User> getAllUsers(){
		return userDao.list();
	}
	
	public User getUser(Integer id){
		return userDao.getById(id);
	}

	public List<User> list() {
		return userDao.list();
	}
	
	public List<Role> listRoles(){
		return roleDao.list();
	}
	
	public User saveOrUpdate(User user){
		return userDao.saveOrUpdate(user);
	}
	//TODO
//	public List<User> getAllUsersBornBefore(Date date){
//		List<User> users = (List<User>)sessionFactory.getCurrentSession().
//				createCriteria(User.class).add(Restrictions.lt("birthDay", new Date(1985,0,0)))
//				.list();
//		return users;
//	}

	public Role getRole(Integer roleId) {
		return roleDao.getById(roleId);
	}
}
