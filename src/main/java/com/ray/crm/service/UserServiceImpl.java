package com.ray.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ray.crm.dao.UserDAO;
import com.ray.crm.entity.Role;
import com.ray.crm.entity.User;


@Service("myUserDetails")
public class UserServiceImpl implements UserDetailsService {
	private final UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found by username: " + username);
		}
		
		Set<Role> roleList = user.getRoles();
		
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		for (Role role : roleList) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			grantedAuthorityList.add(grantedAuthority);
		}
		
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), grantedAuthorityList);
		
		return userDetails;
	}
	
}
