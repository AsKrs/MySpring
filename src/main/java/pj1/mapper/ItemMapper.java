package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import pj1.dto.ItemDto;

@Mapper
public interface ItemMapper {
	List<ItemDto> selectItemList() throws Exception;
	
	List<ItemDto> selectItemTop() throws Exception;
	
	ItemDto selectItemDetail(String itemNum) throws Exception;
	
	int itemWrite(ItemDto itemDto) throws Exception;
	
	int itemUpdate(ItemDto itemDto) throws Exception;
	
	List<ItemDto> selectItemCategory(String categoryName) throws Exception;
	
	List<ItemDto> selectItemOrgans(String itemOrgans) throws Exception;
	

	
}
