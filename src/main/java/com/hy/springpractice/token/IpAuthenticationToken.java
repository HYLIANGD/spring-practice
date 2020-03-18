package com.hy.springpractice.token;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class IpAuthenticationToken extends UsernamePasswordAuthenticationToken {
	
	private String ip;
	
	public IpAuthenticationToken(String ip) {
        super(null, null);
        this.ip = ip;
    }
	
	public IpAuthenticationToken(String ip, Collection<? extends GrantedAuthority> authorities) {
        super("IP_User", "", authorities);
        this.ip = ip;
    }

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.ip;
    }
	
	
}
