package com.company.hellospring;

import java.io.IOException;

import com.company.hellospring.board.CommentsVO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SplitTest {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String src = "{\"seq\": 4, \"name\": \"David\", \"content\": \"댓글 잘 되나요??\\r\\nㅇㅎㅇㅎ\", \"boardSeq\": \"19\", \"regdate\": \"2018-11-06 11:38:02\"}";
		
		//String -> Object
		ObjectMapper mapper = new ObjectMapper();
		CommentsVO vo = mapper.readValue(src, CommentsVO.class);
		System.out.println(vo);
		
		//Object -> String(JSON)
		String des = mapper.writeValueAsString(vo);
		System.out.println("JSON" + des);
	}
}
