package com.sb.java.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Where;

@MappedEntity
@Where("@.enabled = true") // (1)

   

public class MyEntity {
	 @GeneratedValue
	    @io.micronaut.data.annotation.Id
	private int Id ;

	private String Name;

	private double Sal;

	public MyEntity() {
		super();
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSal() {
		return Sal;
	}
	public void setSal(double sal) {
		Sal = sal;
	}
	public MyEntity(int id, String name, double sal) {
		super();
		Id = id;
		Name = name;
		Sal = sal;
	}
	
	

}
