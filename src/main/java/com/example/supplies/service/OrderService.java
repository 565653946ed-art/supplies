/*注文処理のために、指定された備品を取得・準備するためのサービス
 * 
 */

package com.example.supplies.service;

import com.example.supplies.entity.Item;

public interface OrderService {
	//注文したい備品情報の取得メソッド
	Item prepareOrder(Integer itemId);

}
