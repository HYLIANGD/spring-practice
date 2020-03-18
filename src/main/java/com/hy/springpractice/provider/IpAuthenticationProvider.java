package com.hy.springpractice.provider;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.hy.springpractice.token.IpAuthenticationToken;

@Component
public class IpAuthenticationProvider implements AuthenticationProvider {
	
	final static Map<String, SimpleGrantedAuthority> ipAuthorityMap = new ConcurrentHashMap<>();
	static {
        ipAuthorityMap.put("127.0.0.1", new SimpleGrantedAuthority("ROLE_STAFF"));
        ipAuthorityMap.put("0:0:0:0:0:0:0:1", new SimpleGrantedAuthority("ROLE_STAFF"));
    }
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("IpAuthenticationProvider開始執行");
		IpAuthenticationToken ipAuthenticationToken = (IpAuthenticationToken) authentication;
        String ip = ipAuthenticationToken.getIp();
        SimpleGrantedAuthority simpleGrantedAuthority = ipAuthorityMap.get(ip);
 
        if (simpleGrantedAuthority == null) {
        	System.out.println("驗證失敗");
            return null;
        } else {
        	System.out.println("驗證成功");
            return new IpAuthenticationToken(ip, Arrays.asList(simpleGrantedAuthority));
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (IpAuthenticationToken.class
                .isAssignableFrom(authentication));
	}

}
