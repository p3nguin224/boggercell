package com.unl.da;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.unl.dataobject.StudentDO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDA {
	
public static boolean addStudent(StudentDO student) throws Exception{
		
		
		String sname = student.getName();
		String gender=student.getGender();
		String sql = "INSERT INTO student(student_id,name, gender) VALUES('" +1+"','"+ sname+"','" + gender+ "')";
		Connection con = ConnectionManager.getDBConnection();
		Statement stmt = con.createStatement();
		int rowsAffected = stmt.executeUpdate(sql);
		boolean isSuccess = rowsAffected > 0;		
		stmt.close();
		con.close();
		return isSuccess;
	}

public static ObservableList<StudentDO> getStudent() throws Exception{
	String sql = "select * from student";
	Connection con = ConnectionManager.getDBConnection();
	Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    ObservableList<StudentDO> slist = FXCollections.observableArrayList();
        
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
    	StudentDO student=new StudentDO();
    	student.setName(rs.getString("name"));
    	student.setGender(rs.getString("gender"));
      slist.add(student);
    }

    return slist;
  }

}
