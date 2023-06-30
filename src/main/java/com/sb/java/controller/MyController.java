package com.sb.java.controller;

import java.sql.SQLException;
import java.util.List;

import com.sb.java.entity.MyEntity;
import com.sb.java.reposotary.MyRepository;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
@Controller("/output")
public class MyController {
	
	@Inject
	private MyRepository myRepository;
	@Post("/add")
	public MyEntity addDATA (MyEntity myEntity)throws SQLException 
	{
		//myRepository.connect();
		myRepository.insert(myEntity);
		return myEntity;
		
	}
	@Get("/get")
	public List<MyEntity> showData()
	{
		
		return myRepository.fetch();

	}
	
	@Put("/update")
	public MyEntity updateData(MyEntity entity) throws SQLException
	{
		
		return myRepository.update(entity);
		
	}
	@Delete("/delete/{Id}")
	public String deleteData(int Id) throws SQLException
	{
		 myRepository.delete(Id);
		 return "Your Id is Deleted";
		
	}
	
	
}
