package com.unl.main;
	
import javafx.geometry.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.collections.*;

import javax.swing.LayoutStyle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;



public class Main extends Application {
	 Parent root;
	 Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			 root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
			 
			Scene scene = new Scene(root,1000,800);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
