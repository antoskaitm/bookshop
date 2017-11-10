package ru.atoskaitm.bookstore.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.atoskaitm.bookstore.dao.security.IUserDao;
import ru.atoskaitm.bookstore.model.security.Role;
import ru.atoskaitm.bookstore.model.security.User;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUser(username);

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
