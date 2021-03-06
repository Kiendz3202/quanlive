package com.example.quanlive;


import com.example.quanlive.search.SearchByName;
import com.example.quanlive.search.Searcher;
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

    @FXML
    private TextField textSearch;


    private TicketManager ticketManager = new TicketManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VeMayBayList = FXCollections.observableArrayList(ticketManager.getPlaneTickets());

        tenNguoiMuaColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("tenNguoiMua"));
        soCMTColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,Integer>("soCMT"));
        noiDiColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("noiDi"));
        noiDenColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("noiDen"));
        quangDuongColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,Double>("quangDuong"));
        ngayGioBayColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("ngayGioBay"));
        ngayBanVeColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("ngayBanVe"));
        loaiVeColumn.setCellValueFactory(new PropertyValueFactory<VeMayBay,String>("loaiVe"));


        table.setItems(VeMayBayList);
        myComboBox.getItems().add("Th????ng gia");
        myComboBox.getItems().add("Ph??? th??ng");
        selectsearch.getItems().add("Theo t??n");
        selectsearch.getItems().add("Theo n??i ?????n");
        selectsearch.getItems().add("Theo n??i ??i");
        selectsearch.getItems().add("Theo ng??y gi??? bay");


    }

    // addition function
    public void add(ActionEvent e) {
        VeMayBay newVeMayBay = new VeMayBay(tenNguoiMuaText.getText(), Integer.parseInt(soCMTText.getText()),
                noiDiText.getText(), noiDenText.getText(), Double.parseDouble(quangDuongText.getText()),
                ngayGioBayText.getText(), ngayBanVeText.getText(),
                myComboBox.getSelectionModel().getSelectedItem() + "\n");

        VeMayBayList.add(newVeMayBay);
        ticketManager.addPlaneTicket(newVeMayBay);
    }

    //deletion function
    public void delete (ActionEvent e){
        VeMayBay selected = table.getSelectionModel().getSelectedItem();
        VeMayBayList.remove(selected);
    }
    //edit function
    public void edit(ActionEvent e){
        VeMayBay selected = table.getSelectionModel().getSelectedItem();
        System.out.println(selected);
//        VeMayBayList.remove(selected);

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

    //edition function
//    private VeMayBay vemaybay;
//    @FXML
//    public void onTableItemSelect(ActionEvent e){
//        vemaybay = table.getSelectionModel().getSelectedItem();
//        if(vemaybay!=null){
//            tenNguoiMuaText.setText(vemaybay.getTenNguoiMua());
//            soCMTText.setText(String.valueOf(vemaybay.getSoCMT()));//chuyen int ve STring
//            noiDiText.setText(vemaybay.getNoiDi());
//            noiDenText.setText(vemaybay.getNoiDen());
//            quangDuongText.setText(String.valueOf(vemaybay.getQuangDuong()));
//            ngayGioBayText.setText(vemaybay.getNgayGioBay());
//            ngayBanVeText.setText(vemaybay.getNgayBanVe());
//            loaiVeText.setText(vemaybay.getLoaiVe());
//        }
//    }
//    public void edit(ActionEvent e){
//        vemaybay.setTenNguoiMua(tenNguoiMuaText.getText());
//        vemaybay.setSoCMT(Integer.parseInt(soCMTText.getText()));
//        vemaybay.setNoiDi(noiDiText.getText());
//        vemaybay.setNoiDen(noiDenText.getText());
//        vemaybay.setQuangDuong(Double.parseDouble(quangDuongText.getText()));
//        vemaybay.setNgayGioBay(ngayGioBayText.getText());
//        vemaybay.setNgayBanVe(ngayBanVeText.getText());
//        vemaybay.setLoaiVe(loaiVeText.getText());
//    }

    // TODO: Ch?? th??ch ??? ????y
    // C??c h??m thao t??c v???i giao di???n c??ng c???n tham chi???u l???i cho ticketmanager ?????
    // x??? l?? v?? d??? nh?? t ???? s???a ??? h??m add.

    /**
     * Khi b???m n??t search ch???n searcher th?? ph???i setSearcher cho TicketManager
     */
    public void typeSearch(ActionEvent e){
        SearchByName a = new SearchByName();
        ticketManager.setSearcher(a);
    }

    /**
     * Khi search c??? th??? th?? d??ng h??m search c???a TicketManager
     */
//    public void searching(ActionEvent e){
//        ticketManager.search(textSearch.getText());
//    }
}
