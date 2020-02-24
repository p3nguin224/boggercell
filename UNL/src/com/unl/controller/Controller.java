package com.unl.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.unl.da.StudentDA;
import com.unl.dataobject.StudentDO;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class Controller implements Initializable,EventHandler{
	final static String student = "Student:";
	@FXML
	private BarChart<String, Number> barChart;
	@FXML
	LineChart<String,Number> lineChart;
	@FXML
	Hyperlink addStudent;
	
	@FXML
	Hyperlink showSList;
	@FXML
	 BorderPane rootpane;
	    
    @FXML
    private TableView<StudentDO> viewSList;
    @FXML
    private TableColumn<StudentDO, String> name;
    @FXML
    private TableColumn<StudentDO, String> gender;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	

        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data( "2018", 180));
        series1.getData().add(new XYChart.Data( "2019", 280));
        series1.getData().add(new XYChart.Data( "2020", 150));
        barChart.getData().add(series1);
        
        
        
      
         
        
       
        lineChart.setTitle("Course and Student, 2020");
                          
        XYChart.Series series12 = new XYChart.Series();
        series12.setName("OJT");
        
        series12.getData().add(new XYChart.Data("PhP", 23));
        series12.getData().add(new XYChart.Data("Core Java", 14));
        series12.getData().add(new XYChart.Data("J2EE", 15));
        series12.getData().add(new XYChart.Data("Network", 24));
        series12.getData().add(new XYChart.Data("AutoCAD", 34));
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Permanent");
        series2.getData().add(new XYChart.Data("PhP", 33));
        series2.getData().add(new XYChart.Data("Core Java", 34));        
        series2.getData().add(new XYChart.Data("J2EE", 25));
        series2.getData().add(new XYChart.Data("Network", 44));
        series2.getData().add(new XYChart.Data("AutoCAD", 39));
        
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Part Time");
        series3.getData().add(new XYChart.Data("PhP", 44));
        series3.getData().add(new XYChart.Data("Core Java", 35));
        series3.getData().add(new XYChart.Data("J2EE", 36));
        series3.getData().add(new XYChart.Data("Network", 33));
        series3.getData().add(new XYChart.Data("AutoCAD", 31));
        
        
           
        lineChart.getData().addAll(series12, series2, series3);
        addStudent.setOnAction(this);
        showSList.setOnAction(this);
       
	}
	/*@FXML
	public void btn_AddStudent()
	{
		try {
			 Parent loader = FXMLLoader.load(getClass().getResource("/com/unl/main/student.fxml"));
	         
			Scene scene = new Scene(loader,1000,800);
			//Stage stage = new Stage();
			Stage stage=(Stage) (((Hyperlink)addStudent).getScene().getWindow());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		if(event.getSource()==showSList) {
			
			try {
				Parent loader=FXMLLoader.load(getClass().getResource("/com/unl/main/studentList.fxml"));
				rootpane.setCenter(loader);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else
		{
			try {
				Parent loader=FXMLLoader.load(getClass().getResource("/com/unl/main/student.fxml"));
				//rootpane.getChildren().add(loader);
				rootpane.setCenter(loader);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		
	}
	
	
	

}
