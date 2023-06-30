
package com.sb.java.reposotary;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.java.connection.ConnectDatabase;
import com.sb.java.entity.MyEntity;

import io.micronaut.data.annotation.Repository;
@Service
@Repository
public class MyRepository {

	private ConnectDatabase connectDatabase;

public Connection insert(MyEntity myEntity) {
	{
		try(Connection con =connectDatabase.connect()){
			PreparedStatement pt=con.prepareStatement("insert into  data2 (Id , Name , Sal)values(? ,? ,?)");
			pt.setInt(1, myEntity.getId());
			pt.setNString(2, myEntity.getName());
			pt.setDouble(3, myEntity.getSal());
			int k=pt.executeUpdate();
			if (k>0) {
				System.out.println("Data Inserted");
			} else {
				System.out.println("Data Not Inserted");

			}
		} catch (Exception e) {
			
			System.out.println(e);
		}
	
	}
	return null;

}
public List<MyEntity>  fetch() {
	
	List<MyEntity> entities = new ArrayList<>();
	{
		try(Connection con =connectDatabase.connect()) {

			PreparedStatement pt=con.prepareStatement("select * from data2");
			  ResultSet rs = pt.executeQuery();
			  while(rs.next())
			  {
				  int Id = rs.getInt("Id");
	                String Name = rs.getString("Name");
	                double Sal= rs.getDouble("Sal");
	                MyEntity entity = new MyEntity(Id, Name, Sal);
	                
	                entities.add(entity);
			  }
					} catch (Exception e) {
			
			System.out.println(e);
		}
		
	}
	return entities;

}
	public MyEntity update(MyEntity myEntity) throws SQLException
	{
		try(Connection con =connectDatabase.connect()){
			
			  PreparedStatement pt = con.prepareStatement("UPDATE data2 SET Name=?, Sal=? WHERE id=?");
  		    pt.setString(1, myEntity.getName());
  		    pt.setDouble(2, myEntity.getSal());
  		    pt.setInt(3, myEntity.getId());

  		    int update = pt.executeUpdate();
  		    if (update > 0) {
  		        System.out.println("Data Updated");
  		    } else {
  		        System.out.println("Data Not Updated");
  		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return myEntity;
		
	}
	
	public void delete (int id) throws SQLException
	{
		try(Connection con =connectDatabase.connect()) {
		
			  PreparedStatement pt = con.prepareStatement("DELETE FROM data2 WHERE ID=?");
			  pt.setInt(1, id);
			  int k=pt.executeUpdate();
			  if (k>0) {
				  System.out.println("Your Id Deleted");
			  }
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
