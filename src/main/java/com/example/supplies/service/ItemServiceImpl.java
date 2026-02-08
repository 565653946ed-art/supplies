/*
 * itemに関する処理をまとめたサービスの実装クラス
 */


package com.example.supplies.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.supplies.entity.Item;
import com.example.supplies.repository.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor


public class ItemServiceImpl implements ItemService {
	private final ItemMapper itemMapper;

	@Override
	public List<Item> findAll() {
		
		return itemMapper.findAll();
	}
	
	

	@Override
	public void addItem(Item item) {
		itemMapper.insert(item);
	}

	@Override
	public void deleteItem(Integer id) {
		itemMapper.deleteById(id);
		
	}

	@Override
	public void orderItem(Integer id, Integer quantity) {
		Item item = itemMapper.findById(id);
		if (quantity <= 0) {
			return;
		}
		item.setStock(item.getStock() + quantity);
		itemMapper.update(item);
	}
	
	//使用数仮記録
	@Override
	public void savePendingUsage(Integer itemId, Integer usage) {
		itemMapper.updatePendingUsage(itemId, usage);
	}
	
	//使用数確定
	@Override
	public void confirmAllPendingUsage() {
		List<Item> items = itemMapper.findItemsWithPendingUsage();
		 // 確定処理
        for (Item item : items) {
            int newStock = item.getStock() - item.getPendingUsage();
            itemMapper.confirmUsage(item.getId(), newStock);
        }	
	}
	//使用数仮記録リセット
	@Override
	public void resetAllPendingUsage() {
		itemMapper.resetAllPendingUsage();
	}

	@Override
	public List<Item> findItemsWithPendingUsage() {
		
		return itemMapper.findItemsWithPendingUsage();
	}

}
