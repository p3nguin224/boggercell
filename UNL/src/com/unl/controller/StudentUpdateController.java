package com.unl.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class StudentUpdateController implements Initializable,EventHandler{
 @FXML
 TextField txtName;
 @FXML
 RadioButton frb;
 @FXML
 RadioButton mrb;
 @FXML
 Button btn_Update;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	   txtName.setText(StudentListController.data.getName());
	   //RadioButton rbgender=(RadioButton) toggleGender.getSelectedToggle();
	   if(frb.getText().equals(StudentListController.data.getGender()))
	   {
		   frb.setSelected(true);
	   }
	   else
	   {
		   mrb.setSelected(true);
	   }
	}
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		if(event.getSource()==btn_Update)
		{
			
		}
		
	}

}
