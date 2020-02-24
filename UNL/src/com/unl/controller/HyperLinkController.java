package com.unl.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.unl.da.StudentDA;
import com.unl.dataobject.StudentDO;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class HyperLinkController implements Initializable,EventHandler {
	
	@FXML
	Hyperlink addStudent;
	@FXML
	Button btn_Save;
	@FXML
	TextField txtName;
	@FXML
	ToggleGroup toggleGender;
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btn_Save.setOnAction(this);
	}


	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		RadioButton rbGender= (RadioButton)toggleGender.getSelectedToggle();
	     String gend=rbGender.getText();
	     String sname=txtName.getText().toString();
		if(((Button)event.getSource()).getText().equals("Save"))
		{
			System.out.println(sname+" is "+gend);
			StudentDO student=new StudentDO();
			student.setName(sname);
			student.setGender(gend);
			
			System.out.println(student.getName()+" is "+gend);
		  try {
			if(StudentDA.addStudent(student))
			  {
				 System.out.println("successfully added") ;
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
}
