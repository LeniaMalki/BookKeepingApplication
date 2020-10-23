package View.EntryView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
/**
 * @author : Artin Abiri
 * Responsibility: In charge of showing single entries
 * Used by: BudgetChartPageController, EntryListItemController, EntryPageController, RemoveItemObserver,
 *          HomePageController, StatisticsDetailController, StatisticsOverviewController, StatisticsDetailView
 * Uses: JavaFX, AnchorPane
 */
public class EntryListItemView extends AnchorPane {

    //________________________________________________ VARIABLES _______________________________________________________

    @FXML
    public Text articleName;

    @FXML
    public Text categoryName;

    @FXML
    public Text costName;

    @FXML
    public Button trashcan;

    //______________________________________________ METHODS ___________________________________________________________
    /**
     * Method for showing an entries different attributes
     */
    public void setFields(final String category, final double amount, final String name) {
        categoryName.setText(category);
        costName.setText(String.valueOf(amount));
        articleName.setText(name);
    }


}
