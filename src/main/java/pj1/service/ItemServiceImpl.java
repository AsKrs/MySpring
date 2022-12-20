package pj1.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pj1.dto.ItemDto;
import pj1.mapper.ItemMapper;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<ItemDto> selectItemList() throws Exception {
		return itemMapper.selectItemList();
	}
	
	@Override
	public List<ItemDto> selectItemTop() throws Exception {
		return itemMapper.selectItemTop();
	}
	
	@Override
	public ItemDto selectItemDetail(String itemNum) throws Exception {
		return itemMapper.selectItemDetail(itemNum);
	}

	@Override
	public int itemWrite(ItemDto itemDto) throws Exception {

		
		return itemMapper.itemWrite(itemDto);
	}

	@Override
	public List<ItemDto> selectItemCategory(String categoryName) throws Exception {
		return itemMapper.selectItemCategory(categoryName);
	}

	@Override
	public List<ItemDto> selectItemOrgans(String itemOrgans) throws Exception {
		
		return itemMapper.selectItemOrgans(itemOrgans);
	}

	@Override
	public int itemUpdate(ItemDto itemDto) throws Exception {
		return itemMapper.itemUpdate(itemDto);
	}




}
