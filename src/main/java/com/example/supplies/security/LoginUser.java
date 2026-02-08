/*DBのUserを、Spring Securityが使える“ログインユーザー情報”に変換するクラス
 * 
 */

package com.example.supplies.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.supplies.entity.User;

public class LoginUser implements UserDetails {
	// ↑ Spring Security用のログインユーザー

	private final User user;
	//DBのUser保持

	public LoginUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//ユーザーの権限
		return List.of(new SimpleGrantedAuthority(user.getRole()));
	}

	@Override
	public String getUsername() {
		//ログインID
		return user.getUsername();
	}

	@Override
	public String getPassword() {
		//BCrypt化されたパスワード
		return user.getPassword();
	}
	public User getUser() {
		//HTML,Controllerなど使用するためのUser
	    return user;
	}

	// ↓ 今回は全部「問題なし」扱い
	@Override public boolean isAccountNonExpired() { return true; } //有効期限 ok
	@Override public boolean isAccountNonLocked() { return true; } //ロック 
	@Override public boolean isCredentialsNonExpired() { return true; } //password期限 ok
	@Override public boolean isEnabled() { return true; } //有効ユーザー
}
