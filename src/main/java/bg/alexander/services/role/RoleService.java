package bg.alexander.services.role;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.alexander.model.user.Role;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public void saveOrUpdate(Role role){
		roleDao.saveOrUpdate(role);
	}
	
	public List<Role> listRoles(){
		return roleDao.list();
	}
}
