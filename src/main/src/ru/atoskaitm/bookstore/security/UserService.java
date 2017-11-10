package ru.atoskaitm.bookstore.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.atoskaitm.bookstore.dao.security.IRoleDao;
import ru.atoskaitm.bookstore.dao.security.IUserDao;
import ru.atoskaitm.bookstore.model.security.Role;
import ru.atoskaitm.bookstore.model.security.User;

import java.util.HashSet;
import java.util.Set;

@Transactional
public class UserService implements IUserService {

	private IUserDao userDao;

	private IRoleDao roleDao;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Transactional
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		//role_user
		roles.add(roleDao.getRole(1L));
		user.setRoles(roles);
		userDao.save(user);
	}

	@Transactional
	public User findByUsername(String username) {
		return userDao.getUser(username);
	}
}

