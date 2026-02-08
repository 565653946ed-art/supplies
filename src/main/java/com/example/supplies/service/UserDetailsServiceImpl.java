/**
 * ログイン時にDBかユーザーを取得してSplringに渡す
 */

package com.example.supplies.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.supplies.entity.User;
import com.example.supplies.repository.UserMapper;
import com.example.supplies.security.LoginUser;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UserDetailsServiceImpl implements UserDetailsService {

  
    private final UserMapper userMapper;

    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        //DBから username に一致するユーザーを取得
        User user = userMapper.findByUsername(username);

        //ユーザーが存在しなければログイン失敗
        if (user == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりません");
        }
        return new LoginUser(user);
    }
}
