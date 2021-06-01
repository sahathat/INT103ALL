
package gui;


import dataaccess.imp.ProductDaoImp;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;

public class OrderGUI extends Application{
    
    Product prod;
    Customer cust=new Customer();
    Order order = new Order();
    TableView<OrderItem> table_orderItemList;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane grid_pane = drawProwductPane();
        
        VBox vb_pane = new VBox(grid_pane);
        Scene scene = new Scene(vb_pane);
        stage.setScene(scene);
        stage.setTitle("Order");
        
        stage.show();
    }
    
    public Pane drawProwductPane() {
        
        GridPane g_pane = new GridPane();
        g_pane.setVgap(10);
        g_pane.setHgap(10);
        g_pane.setPadding(new Insets(10,10,10,10));

        
        //first_row
        Text txt_prodId = new Text("Product Id");
        TextField tf_prodId = new TextField();
        Button btn_search = new Button("Sreach");
        g_pane.add(txt_prodId,0,0);
        g_pane.add(tf_prodId, 1, 0);
        g_pane.add(btn_search, 2, 0);
        
        //second_row
        Text txt_prodName = new Text("Product");
        Label lb_prodName = new Label();
        lb_prodName.setMinHeight(50);
        lb_prodName.setMinWidth(500);
        lb_prodName.setMaxWidth(500);
        g_pane.add(txt_prodName,0,1);
        g_pane.add(lb_prodName,1,1,3,1);
        
        
        tf_prodId.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode().equals(KeyCode.ENTER)){
                    int id = Integer.parseInt(tf_prodId.getText());
                    System.out.println(new ProductDaoImp().findById(id).toString());
                    lb_prodName.setText(new ProductDaoImp().findById(id).toString());
                }
            }
        });
        
        btn_search.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                int id = Integer.parseInt(tf_prodId.getText());
                System.out.println(new ProductDaoImp().findById(id).toString());
                lb_prodName.setText(new ProductDaoImp().findById(id).toString());
            }
        });
        
        return g_pane;
    }
}
