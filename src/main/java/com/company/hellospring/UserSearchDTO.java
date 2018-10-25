package com.company.hellospring;

import java.util.Arrays;

public class UserSearchDTO extends UserDTO {
	//검색 조건
	private String searchCondition;
	private String searchKeyword;
	//페이징
	private Integer start;
	private Integer end;
	//foreach
	private String[] ids;
	//정렬 기준
	private String sort;
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "UserSearchDTO [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", start="
				+ start + ", end=" + end + ", ids=" + Arrays.toString(ids) + ", sort=" + sort + "]";
	}
}
