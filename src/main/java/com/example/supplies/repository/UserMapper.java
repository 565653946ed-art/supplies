/*MyBatisを使いDBを扱う
 *Serviceクラスと連携しデータを扱う 
 */

package com.example.supplies.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.supplies.entity.User;

@Mapper
public interface UserMapper {
	//usernemeでユーザー取得(login用)
	User findByUsername(String username);
	//User登録用
	void insertUser(User user);
}
