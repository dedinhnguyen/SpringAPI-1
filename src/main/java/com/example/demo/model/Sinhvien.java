package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="sinhvien")
public class Sinhvien {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="email")
	private String email;
	
		public Long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		  public Lophoc getLophoc() {
			return lophoc;
		}
		public void setLophoc(Lophoc lophoc) {
			this.lophoc = lophoc;
		}
		@ManyToOne
		  @JoinColumn(name = "lophoc_id", nullable = false)
		  private Lophoc lophoc;
	}
