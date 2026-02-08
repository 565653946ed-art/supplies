/*ユーザー登録処理のサービスの実装
 * 
 */

package com.example.supplies.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.supplies.entity.User;
import com.example.supplies.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService {
	
	 private final UserMapper userMapper;//Userテーブル操作
	 private final PasswordEncoder passwordEncoder;//password暗号化

	@Override
	public void register(User user) {
		//ユーザー名の重複確認
		 if (userMapper.findByUsername(user.getUsername()) != null) {
	            throw new IllegalArgumentException("このユーザー名は既に使われています");
	        }
		//パスワード暗号化
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//role設定
		user.setRole("ROLE_USER");
		//DBに保存
		userMapper.insertUser(user);

	}

	

}
