package com.unl.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

public class Controller implements Initializable {
	final static String student = "Student:";
	@FXML
	private BarChart<String, Number> barChart;
	@FXML
	LineChart<String,Number> lineChart;
	
	

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
       
	}
	
	
	

}
