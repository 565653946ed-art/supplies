/**ログインを扱うコントロールする
 * 
 */

package com.example.supplies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class LoginController {
	
	//URLからlogin画面表示
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
}
