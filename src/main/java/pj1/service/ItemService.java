package pj1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pj1.dto.ItemDto;

public interface ItemService {
	
	public List<ItemDto> selectItemList() throws Exception;
	public List<ItemDto> selectItemTop() throws Exception;
	public ItemDto selectItemDetail(String itemNum) throws Exception;
	public int itemWrite(ItemDto itemDto) throws Exception;
	
	public int itemUpdate(ItemDto itemDto) throws Exception;
	
	public List<ItemDto> selectItemCategory(String categoryName) throws Exception;
	
	public List<ItemDto> selectItemOrgans(String itemOrgans) throws Exception;
	
}
