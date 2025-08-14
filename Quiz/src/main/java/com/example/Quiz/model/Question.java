package com.example.Quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String q_title;
	private String o1;
	private String o2;
	private String o3;
	private String o4;
    private String r_a;
    private String d_l;
    private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getO1() {
		return o1;
	}
	public void setO1(String o1) {
		this.o1 = o1;
	}
	public String getO2() {
		return o2;
	}
	public void setO2(String o2) {
		this.o2 = o2;
	}
	public String getO3() {
		return o3;
	}
	public void setO3(String o3) {
		this.o3 = o3;
	}
	public String getO4() {
		return o4;
	}
	public void setO4(String o4) {
		this.o4 = o4;
	}
	public String getR_a() {
		return r_a;
	}
	public void setR_a(String r_a) {
		this.r_a = r_a;
	}
	public String getD_l() {
		return d_l;
	}
	public void setD_l(String d_l) {
		this.d_l = d_l;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    

}
