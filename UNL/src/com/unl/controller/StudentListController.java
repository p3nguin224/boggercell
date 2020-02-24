package com.unl.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.unl.da.StudentDA;
import com.unl.dataobject.StudentDO;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class StudentListController implements Initializable {
	@FXML
		TableView viewSList;
	ObservableList<StudentDO> slist;
	@FXML
		TextField txtName;
	@FXML
	GridPane listGrid;
	@FXML
	BorderPane listpane;
	static String sid;
	static StudentDO data;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			slist = StudentDA.getStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(StudentDO s:slist)
		{
			System.out.println(s.getName());
		}
		
		ObservableList<TableColumn<StudentDO, ?>> columns = viewSList.getColumns();
		columns.get(0).setCellValueFactory(new PropertyValueFactory("name")); // asumming this column is the corresponding to firstName, you can also set an id to the column an refer to it with @FXML property
		columns.get(1).setCellValueFactory(new PropertyValueFactory("gender"));
		
		viewSList.setItems(slist);
		
		addButtonToTable();
	}
	private void addButtonToTable() {
        TableColumn<StudentDO, Void> colBtn = new TableColumn("Actions");

        Callback<TableColumn<StudentDO, Void>, TableCell<StudentDO, Void>> cellFactory = new Callback<TableColumn<StudentDO, Void>, TableCell<StudentDO, Void>>() {
           
            public TableCell<StudentDO, Void> call(final TableColumn<StudentDO, Void> param) {
                final TableCell<StudentDO, Void> cell = new TableCell<StudentDO, Void>() {

                    private final Button btnUpdate = new Button("Update");

                    {
                        btnUpdate.setOnAction((ActionEvent event) -> {
                            data = getTableView().getItems().get(getIndex());
                           
                            try {
                            	//sid=data.getName();
                				Parent loader=FXMLLoader.load(getClass().getResource("/com/unl/main/studentUpdate.fxml"));
                				listpane.setCenter(loader);
                				
                				System.out.println(data.getName() + "in controller");
                			} catch (IOException e) {
                				// TODO Auto-generated catch block
                				e.printStackTrace();
                			} catch (Exception e) {
                				// TODO Auto-generated catch block
                				e.printStackTrace();
                			}
                            
                        });
                    }
                    private final Button btnDelete = new Button("Delete");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            StudentDO data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data.getName()
                            );
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                        	HBox pane = new HBox(btnUpdate, btnDelete);
                        	setGraphic(pane);
                            
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        viewSList.getColumns().add(colBtn);

    }

}
