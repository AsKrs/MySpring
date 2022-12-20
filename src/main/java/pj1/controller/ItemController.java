package pj1.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.ItemDto;
import pj1.service.ItemService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "목록 조회", notes = "등록된 아이템 목록을 조회")
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public List<ItemDto> openItemList() throws Exception {
		return itemService.selectItemList();
	}

	@ApiOperation(value = "카페고리 아이템 조회", notes = "카테고리별 아이템 조회")
	@RequestMapping(value = "/itemlist/{categoryName}", method = RequestMethod.GET)
	public List<ItemDto> openItemCategoryList(
			@Parameter(description = "분류 이름", required = true, example = "기능별") @PathVariable("categoryName") String categoryName) throws Exception {
		return itemService.selectItemCategory(categoryName);
	}
	
	@ApiOperation(value = "카페고리 아이템 분류 조회", notes = "카테고리별 아이템 분류 조회")
	@RequestMapping(value = "/item/organs/{itemOrgans}", method = RequestMethod.GET)
	public List<ItemDto> openItemOrgansList(
			@Parameter(description = "분류 이름", required = true, example = "장") @PathVariable("itemOrgans") String itemOrgans) throws Exception {
		
		return itemService.selectItemOrgans(itemOrgans);
	}
	
	

	
	

	@ApiOperation(value = "상품 상세 조회", notes = "등록된 상품 상세 조회")
	@RequestMapping(value = "/item/{itemNum}", method = RequestMethod.GET)
	public ResponseEntity<ItemDto> openItemDetail(
			@Parameter(description = "상품 번호", required = true, example = "1") @PathVariable("itemNum") String itemNum)
			throws Exception {
		ItemDto itemDto = itemService.selectItemDetail(itemNum);
		if (itemDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			// return ResponseEntity.status(HttpStatus.OK).body(boardDto);
			return ResponseEntity.ok(itemDto);
		}
	}

	@ApiOperation(value = "아이템 등록", notes = "아이템 등록")
	@RequestMapping(value = "/admin/item/write", method = RequestMethod.POST)
	public ResponseEntity<Object> insertItem(MultipartFile itemThumb,MultipartFile itemDetailImg, String itemsDto) throws Exception {

		ItemDto itemDto = new ObjectMapper().readValue(itemsDto, ItemDto.class); // String to Object

		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

		UUID uuid = UUID.randomUUID();

		String fileName = uuid + "_" + itemThumb.getOriginalFilename();
		String fileName1 = uuid + "_" + itemDetailImg.getOriginalFilename();

		File saveFile = new File(projectPath, fileName);
		File saveFile1 = new File(projectPath, fileName1);

		itemThumb.transferTo(saveFile);
		itemDetailImg.transferTo(saveFile1);

		itemDto.setItemDetailImgName(fileName1);
		itemDto.setItemThumbName(fileName);

		itemDto.setItemDetailImg("/files/" + fileName1);
		itemDto.setItemThumb("/files/" + fileName);

		System.out.println("itemDto= " + itemDto);

		int success = itemService.itemWrite(itemDto);

		if (success > 0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}

	}
	
	@ApiOperation(value = "아이템 등록", notes = "아이템 등록")
	@RequestMapping(value = "/admin/item/update", method = RequestMethod.POST)
	public ResponseEntity<Object> updateItem(MultipartFile itemThumb,MultipartFile itemDetailImg, String itemsDto) throws Exception {

		ItemDto itemDto = new ObjectMapper().readValue(itemsDto, ItemDto.class); // String to Object

		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

		UUID uuid = UUID.randomUUID();

		String fileName = uuid + "_" + itemThumb.getOriginalFilename();
		String fileName1 = uuid + "_" + itemDetailImg.getOriginalFilename();

		File saveFile = new File(projectPath, fileName);
		File saveFile1 = new File(projectPath, fileName1);

		itemThumb.transferTo(saveFile);
		itemDetailImg.transferTo(saveFile1);

		itemDto.setItemDetailImgName(fileName1);
		itemDto.setItemThumbName(fileName);

		itemDto.setItemDetailImg("/files/" + fileName1);
		itemDto.setItemThumb("/files/" + fileName);

		System.out.println("itemDto= " + itemDto);

		int success = itemService.itemUpdate(itemDto);

		if (success > 0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}

	}

}
