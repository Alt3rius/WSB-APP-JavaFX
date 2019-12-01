package App;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.HttpURLConnection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Controller implements Initializable {

    public Label label1;
    public Label label2;
    public ComboBox<String> box1;
    public ComboBox<String> box2;
    public TextField intext;
    public TextField outtext;
    public Button calculateButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {





        ObservableList<String> currencyList =
                FXCollections.observableArrayList(
                        "PLN",
                        "USD",
                        "EUR",
                        "CHF",
                        "GBP"
                );

        box1.setItems(currencyList);
        box2.setItems(currencyList);





    }

    public void calculate(){
        Dictionary<String, Double> currencyValues = new Hashtable<String, Double>();
        currencyValues.put("PLN", 1.0);
        currencyValues.put("EUR", 4.2999);
        currencyValues.put("USD", 3.9039);
        currencyValues.put("CHF", 3.9131);
        currencyValues.put("GBP", 5.0244);
        try{
            double sourceValue = Double.parseDouble(intext.getText());
            double ratio = currencyValues.get(box2.getValue())/currencyValues.get(box1.getValue());
            outtext.setText(String.format("%.2f",sourceValue/ratio));
        }
        catch(Exception e){
            System.out.println("Nieprawidlowa liczba");
        }



    }

}