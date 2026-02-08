/**ユーザー登録用
 * 
 */

package com.example.supplies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.supplies.entity.User;
import com.example.supplies.service.UserRegisterService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserRegisterController {
	private final UserRegisterService userRegisterService;
	//URL→登録画面へ
	@GetMapping("/register")
	public String registerForm(Model model) {
		//空オブジェクト作成
		model.addAttribute("user", new User());
		return "register";
	}
	//ユーザー登録処理
	@PostMapping("/register")
	public String register(User user,Model model) {
		userRegisterService.register(user);
		return "redirect:/login";
	}
	

}
