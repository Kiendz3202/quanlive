package com.example.quanlive;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<VeMayBay> table;

    @FXML
    private TableColumn<VeMayBay, String> tenNguoiMuaColumn;

    @FXML
    private TableColumn<VeMayBay, Integer> soCMTColumn;

    @FXML
    private TableColumn<VeMayBay, String> noiDiColumn;

    @FXML
    private TableColumn<VeMayBay, String> noiDenColumn;
    @FXML
    private TableColumn<VeMayBay, Double> quangDuongColumn;
    @FXML
    private TableColumn<VeMayBay, String> ngayGioBayColumn;
    @FXML
    private TableColumn<VeMayBay, String> ngayBanVeColumn;
    @FXML
    private TableColumn<VeMayBay, String> loaiVeColumn;

    private ObservableList<VeMayBay> VeMayBayList;

    @FXML
    private TextField tenNguoiMuaText;

    @FXML
    private TextField soCMTText;

    @FXML
    private TextField noiDiText;

    @FXML
    private TextField noiDenText;

    @FXML
    private TextField quangDuongText;

    @FXML
    private TextField ngayGioBayText;

    @FXML
    private TextField ngayBanVeText;

    @FXML
    private TextField loaiVeText;
    @FXML
    private ComboBox myComboBox;

    @FXML
    private ComboBox selectsearch;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VeMayBayList = FXCollections.observableArrayList(
                new VeMayBay("Nguyen Cong Quyen",21,"Ha Noi","HCM",12.6,"12/2","13/3","Thuong Gia")
        );
        tenNguoiMuaColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("tenNguoiMua"));
        soCMTColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,Integer>("soCMT"));
        noiDiColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("noiDi"));
        noiDenColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("noDen"));
        quangDuongColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,Double>("quangDuong"));
        ngayGioBayColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("ngayGioBay"));
        ngayBanVeColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("ngayBanVe"));
        loaiVeColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("loaiVe"));


        table.setItems(VeMayBayList);
        myComboBox.getItems().add("Thương gia");
        myComboBox.getItems().add("Phổ thông");
        selectsearch.getItems().add("Theo tên");
        selectsearch.getItems().add("Theo nơi đến");
        selectsearch.getItems().add("Theo nơi đi");
        selectsearch.getItems().add("Theo ngày giờ bay");


    }

    // addition function
    public void add (ActionEvent e){
        VeMayBay newVeMayBay = new VeMayBay();
        newVeMayBay.setTenNguoiMua(tenNguoiMuaText.getText());
        newVeMayBay.setSoCMT(Integer.parseInt(soCMTText.getText())); //Chuyen tu String ve Int, vi kieu nhap vao la String
        newVeMayBay.setNoiDi(noiDiText.getText());
        newVeMayBay.setNoiDen(noiDenText.getText());
        newVeMayBay.setQuangDuong(Double.parseDouble(quangDuongText.getText()));// Chuyen tu String ve Double
        newVeMayBay.setNgayGioBay(ngayGioBayText.getText());
        newVeMayBay.setNgayBanVe(ngayBanVeText.getText());

        newVeMayBay.setLoaiVe(myComboBox.getSelectionModel().getSelectedItem()+"\n");

        VeMayBayList.add(newVeMayBay);
    }

    //deletion function
    public void delete (ActionEvent e){
        VeMayBay selected = table.getSelectionModel().getSelectedItem();
        VeMayBayList.remove(selected);
    }

    //edition function
    private VeMayBay vemaybay;
    @FXML
    public void onTableItemSelect(){
        vemaybay = table.getSelectionModel().getSelectedItem();
        if(vemaybay!=null){
            tenNguoiMuaText.setText(vemaybay.getTenNguoiMua());
            soCMTText.setText(String.valueOf(vemaybay.getSoCMT()));//chuyen int ve STring
            noiDiText.setText(vemaybay.getNoiDi());
            noiDenText.setText(vemaybay.getNoiDen());
            quangDuongText.setText(String.valueOf(vemaybay.getQuangDuong()));
            ngayGioBayText.setText(vemaybay.getNgayGioBay());
            ngayBanVeText.setText(vemaybay.getNgayBanVe());
            loaiVeText.setText(vemaybay.getLoaiVe());
        }
    }
    public void edit(ActionEvent e){
        vemaybay.setTenNguoiMua(tenNguoiMuaText.getText());
        vemaybay.setSoCMT(Integer.parseInt(soCMTText.getText()));
        vemaybay.setNoiDi(noiDiText.getText());
        vemaybay.setNoiDen(noiDenText.getText());
        vemaybay.setQuangDuong(Double.parseDouble(quangDuongText.getText()));
        vemaybay.setNgayGioBay(ngayGioBayText.getText());
        vemaybay.setNgayBanVe(ngayBanVeText.getText());
        vemaybay.setLoaiVe(loaiVeText.getText());
    }
}
