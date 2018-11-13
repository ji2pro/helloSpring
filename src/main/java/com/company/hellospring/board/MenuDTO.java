package com.company.hellospring.board;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class MenuDTO {
	@Id
	private Integer menu_no;
	private String menu_name;
	private String program_id;
	
	public Integer getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(Integer menu_no) {
		this.menu_no = menu_no;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getProgram_id() {
		return program_id;
	}
	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}
	
}
