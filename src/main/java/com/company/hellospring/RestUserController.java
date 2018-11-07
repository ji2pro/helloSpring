package com.company.hellospring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestUserController {
	@Autowired UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<UserDTO> getUsers(UserSearchDTO searchDto) {
		searchDto.setStart(1);
		searchDto.setEnd(5);
		return userService.getUsers(searchDto);
	}
	
	//단건 조회
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public UserDTO getUser(@PathVariable String id, UserDTO dto) {
		dto.setId(id);
		return userService.getUser(dto);
	}
	
	//삭제
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public HashMap<String, Object> deleteUser(@PathVariable String id, UserDTO dto) {
		dto.setId(id);
		userService.deleteUser(dto);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", Boolean.TRUE);
		return map;
	}
	
	//등록	"{"id":"kkk","password":"111","name":"홍지상","role":"admin"}"
	@RequestMapping(value="/users"
			        ,method=RequestMethod.POST
			        ,headers={"Content-type=application/json"})
	public UserDTO insertUser(@RequestBody UserDTO dto) {
		userService.insertUser(dto);
		return dto;
	}
	
	//수정	queryString : uri?id=kkk&password=111&name=홍지상&role=admin
	@RequestMapping(value="/users"
					,method=RequestMethod.PUT
					,consumes="application/json")  //Content-type 지정
	public UserDTO updateUser(@RequestBody UserDTO dto) {
		userService.updateUser(dto);
		return dto;
	}
	
	@RequestMapping(value="/restAPI")
	public Map restAPI() {
		RestTemplate rest = new RestTemplate();
		Map map = rest.getForObject("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20181105", Map.class);
		System.out.println(map);
		return map;
	}
}
