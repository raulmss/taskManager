package com.todo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //Utilizado para sinalizar o Hibernate que essa é a classe a ser mapeada.
@Table(name="Task", schema = "public")
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID será gerado pelo próprio Hibernate no BD Postgres
	private Long id;
	
	@Column(nullable=false)
	private String description;
	private String titulo;
	private String priori;
	private Date deadLine;
	
	
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	private String responsavel;
	@Column(nullable=false)
	private Boolean completedTask;
	
	
	public Task() {
		super();
		this.completedTask = false;
	}
	
	public Task(String description) {
		super();
		this.description = description;
		this.completedTask = false;
	}
	
	public Task(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
		this.completedTask = false;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getCompletedTask() {
		return completedTask;
	}
	
	public void setCompletedTask(Boolean completedTask) {
		this.completedTask = completedTask;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPriori() {
		return priori;
	}

	public void setPriori(String priori) {
		this.priori = priori;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}



}
