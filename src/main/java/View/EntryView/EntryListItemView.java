package View.EntryView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class EntryListItemView extends AnchorPane {
    @FXML
    public Text articleName;

    @FXML
    public Text categoryName;

    @FXML
    public Text costName;

    @FXML
    public Button trashcan;

    public void setFields(final String category, final double amount, final String name) {
        categoryName.setText(category);
        costName.setText(String.valueOf(amount));
        articleName.setText(name);
    }


}
