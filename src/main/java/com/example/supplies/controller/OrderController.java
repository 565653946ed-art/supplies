/**注文用
 * 
 */

package com.example.supplies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.supplies.entity.Item;
import com.example.supplies.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor

public class OrderController {
	private final OrderService orderService;

	//URL→order画面
	@GetMapping("/order/{id}")
	public String order(@PathVariable("id") Integer itemId, Model model) {
		//指定されたIDの商品を取得
		Item item = orderService.prepareOrder(itemId);
		//商品情報を画面へ
		model.addAttribute("item", item);
		return "order";

	}

}
