/*注文処理のために、指定された備品を取得・準備するためのサービスの実装
 * 
 */

package com.example.supplies.service;

import org.springframework.stereotype.Service;

import com.example.supplies.entity.Item;
import com.example.supplies.repository.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {
	private final ItemMapper itemMapper;
	//注文したい備品情報の取得メソッド
	@Override
	public Item prepareOrder(Integer itemId) {
		//itemIdを使用しDBからitem情報取得
		Item item = itemMapper.findById(itemId);
		
		
		return item;
	}

}
