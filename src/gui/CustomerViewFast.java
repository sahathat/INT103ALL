package gui;

import model.Customer;
import dataaccess.CustomerDao;
import dataaccess.imp.CustomerDaoImp;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerViewFast extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        CustomerDao custDao = new CustomerDaoImp();
        ArrayList<Customer> customers = (ArrayList) custDao.getAll();
        int rowPerPage = 100;
        int pages = (int) Math.ceil(((double) customers.size()) / rowPerPage);

        TableView tableViewCustomer = new TableView();
        drawCustomerTable(tableViewCustomer);

        Pagination pagination = new Pagination();
        pagination.setPageCount(pages);
        pagination.setCurrentPageIndex(0);
        pagination.setMaxPageIndicatorCount(10);
        pagination.setPageFactory((pageIndex) -> {
            tableViewCustomer.getItems().clear();
            updateDataInTable(tableViewCustomer, customers, rowPerPage, pageIndex);
            return new VBox(tableViewCustomer);
        });

        VBox vbox = new VBox(pagination);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("All Customer");

        primaryStage.show();
    }

    private void drawCustomerTable(TableView localTableView) {

        TableColumn<Customer, String> column0 = new TableColumn<>("ID");
        column0.setCellValueFactory(new PropertyValueFactory<>("customer_id"));

        TableColumn<Customer, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("customer_fname"));

        TableColumn<Customer, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("customer_lname"));

        TableColumn<Customer, String> column3 = new TableColumn<>("Email");
        column3.setCellValueFactory(new PropertyValueFactory<>("customer_email"));

        TableColumn<Customer, String> column4 = new TableColumn<>("State");
        column4.setCellValueFactory(new PropertyValueFactory<>("customer_state"));

        localTableView.getColumns().add(column0);
        localTableView.getColumns().add(column1);
        localTableView.getColumns().add(column2);
        localTableView.getColumns().add(column3);
        localTableView.getColumns().add(column4);

        TableView.TableViewSelectionModel<Customer> selectionModel = localTableView.getSelectionModel();

        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        ObservableList<Customer> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<Customer>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Customer> change) {
                if (change.getList().isEmpty()) {
                    return;
                }
                System.out.println("Selection changed: " + change.getList().get(0));
            }
        });
    }


    private void updateDataInTable(TableView tableViewCustomer, ArrayList<Customer> customers, int rowPerPage, Integer pageIndex) {
        int first_row = pageIndex * rowPerPage;
        int last_row = pageIndex * rowPerPage+rowPerPage;
        if (first_row >= customers.size()) {
            return;
        }
        if (last_row > customers.size()) {
            last_row = customers.size();
        }
        for (int i = first_row; i < last_row; i++) {
            tableViewCustomer.getItems().add(customers.get(i));
        }
    }

}
