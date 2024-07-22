package com.example.groupproject;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        import java.io.IOException;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.*;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.image.Image;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextField;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.text.Text;

        import java.io.IOException;

        import static com.example.groupproject.DbConnection.dbConnection;

/**
 *
 * @author Ashish Alton
 */
public class FXMLDocumentController implements Initializable {


    @FXML
    private Label label;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField pw;


    private Connection conn;
    private PreparedStatement pst=null;
    private ObservableList<NameList> data;
    private ResultSet rs=null;
    @FXML
    private Button button;
    @FXML
    private TableColumn<NameList, String> data_id;
    @FXML
    private TableColumn<NameList, String> data_name;
    @FXML
    private TableColumn<NameList, Double> data_pw;
    @FXML
    private TableView<NameList> data_table;
    @FXML
    private TextField qtys;
    @FXML
    private TableColumn<NameList, Integer> stocks;
    @FXML
    private TextField search;
    @FXML
    private Button update;

    @FXML
    public void backToOverview(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("overview.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }




    @FXML
    private void handleButtonAction(ActionEvent event) {
        String data1=id.getText();
        String data2=name.getText();
        double data3= Double.parseDouble(pw.getText());
        int data4=Integer.parseInt(qtys.getText());
        try {
            pst=conn.prepareStatement("INSERT INTO `stock`(`product_id`, `p_name`, `price`,`quantity`) VALUES (?,?,?,?)");
            pst.setString(1, data1);
            pst.setString(2, data2);
            pst.setDouble(3, data3);
            pst.setInt(4,data4);
            int i= pst.executeUpdate();
            if(i==1){
                AlertDialog.display("Info", "Datas are successfully inserted !");
                id.clear();
                pw.clear();
                name.clear();
                qtys.clear();
                setCellTable();
                loadTableData();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn= dbConnection();

        data=FXCollections.observableArrayList();
        searchProduct();
        setCellTable();
        loadTableData();
        setValueFromTable();

    }
    private void setCellTable(){


        data_id.setCellValueFactory(new PropertyValueFactory<NameList,String>("pid"));
        data_name.setCellValueFactory(new PropertyValueFactory<NameList,String>("pw"));
        stocks.setCellValueFactory(new PropertyValueFactory<NameList,Integer>("qty"));
        data_pw.setCellValueFactory(new PropertyValueFactory<NameList,Double>("price"));




//
//


    }
    private void loadTableData(){
        try {
            data.clear();
            pst=conn.prepareStatement("select * from `stock`");
            rs=pst.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString("username"));
                data.add(new NameList(rs.getString("product_id"),rs.getString("p_name"),rs.getInt("quantity"),rs.getDouble("price")));
            }
            data_table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    private void searchProduct(){

        search.setOnKeyReleased(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
                try {
                    if(search.getText().isEmpty()){
                        loadTableData();
                    }
                    else{
                        data.clear();
                        String sql="select * from stock where product_id like '%"+search.getText()+"%' "+"UNION select * from stock where p_name like '%"+search.getText()+"%'";
                        pst=conn.prepareStatement(sql);
                        rs=pst.executeQuery();
                        while(rs.next()){
                            data.add(new NameList(rs.getString("product_id"),rs.getString("p_name"),rs.getInt("quantity"),rs.getDouble("price")));
                        }

                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        });


    }

    private void setValueFromTable(){
        data_table.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                NameList list=data_table.getItems().get(data_table.getSelectionModel().getSelectedIndex());
                id.setText(list.getPid());
                qtys.setText(list.getQty()+"");
                pw.setText(list.getPrice()+"");
                name.setText(list.getPw());
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {
        try {
            String data1=id.getText();
            String data2=name.getText();
            double data3= Double.parseDouble(pw.getText());
            int data4=Integer.parseInt(qtys.getText());

            String stmt="update stock set p_name=?,price=?,quantity=? where product_id=?";
            pst=conn.prepareStatement(stmt);
            pst.setString(1, data2);
            pst.setDouble(2, data3);
            pst.setInt(3, data4);
            pst.setString(4,data1);

            int i=pst.executeUpdate();
            if(i==1){
                System.out.println("Updated");
                loadTableData();
            }



        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}


//       
//        

