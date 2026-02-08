/*ユーザー登録処理のサービス
 * 
 */

package com.example.supplies.service;

import com.example.supplies.entity.User;

public interface UserRegisterService {
	//ユーザー情報を取得して登録
	void register(User user);
	

}
