package com.greatlearning.studentmgmtsystem.securityconfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.studentmgmtsystem.model.Role;
import com.greatlearning.studentmgmtsystem.model.User;

public class SecurityDetails implements UserDetails {
	  private User user;
	    
	    public SecurityDetails(User user) {
	        this.user = user;
	    }
	 
	
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        List<Role> roles = user.getRoles();
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	         
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	         
	        return authorities;
	    }
	 
	
	    public String getPassword() {
	        return user.getPassword();
	    }
	 
	   
	    public String getUsername() {
	        return user.getUsername();
	    }
	 

	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	   
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	
	    public boolean isEnabled() {
	        return true;
	    }
	 
}
