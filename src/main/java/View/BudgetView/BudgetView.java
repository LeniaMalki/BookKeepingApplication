package View.BudgetView;

import View.Interfaces.iPane;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
public class BudgetView implements iPane {

    /**
     * @author : viktoriawelzel
     * Responsibility: In charge of creating/ displaying the BudgetChartPage
     * Uses: iPane
     */
    //________________________________________________ Variables _______________________________________________________

    public MainView parent;
    static BudgetView budgetView;


    @FXML
    public TextField enterIncomeTextField;
    @FXML
    public Button saveButton;
    @FXML
    public Button checkButton;
    @FXML
    public AnchorPane headerAnchorPane;
    @FXML
    public ComboBox previousBudgetComboBox;
    @FXML
    public Label moneyLeft;
    @FXML
    public Label totalMoney;

    @FXML
    public Slider foodSlider;
    @FXML
    public Slider householdSlider;
    @FXML
    public Slider shoppingSlider;
    @FXML
    public Slider transportSlider;
    @FXML
    public Slider otherSlider;
    @FXML
    public Slider savingsSlider;

    @FXML
    public TextField foodTextField;
    @FXML
    public TextField householdTextField;
    @FXML
    public TextField shoppingTextField;
    @FXML
    public TextField transportTextField;
    @FXML
    public TextField otherTextField;
    @FXML
    public TextField savingsTextField;

    @FXML
    public ProgressBar foodProgressBar;
    @FXML
    public ProgressBar householdProgressBar;
    @FXML
    public ProgressBar shoppingProgressBar;
    @FXML
    public ProgressBar transportProgressBar;
    @FXML
    public ProgressBar otherProgressBar;
    @FXML
    public ProgressBar savingsProgressBar;

    //---------------------------------------------------- METHODS -----------------------------------------------------


    /**
     * constructor.
     */
    public BudgetView(){
        budgetView = this;
    }

    /**
     * Method for obtaining the BudgetView instance.
     */
    public static BudgetView getInstance(){
        if (budgetView == null){
            budgetView = new BudgetView();
        }
        return budgetView;
    }

    /**
     * Initializes this pane.
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        stylingSlidersAndProgressBars();

    }

    /**
     * Sets style of sliders and progress bars.
     */
    private void stylingSlidersAndProgressBars() {
        foodSlider.setStyle("-fx-control-inner-background: null");
        foodProgressBar.setStyle("-fx-accent: #F66A80");
        householdSlider.setStyle("-fx-control-inner-background: null");
        householdProgressBar.setStyle("-fx-accent: #F66A80");
        shoppingSlider.setStyle("-fx-control-inner-background: null");
        shoppingProgressBar.setStyle("-fx-accent: #F66A80");
        transportSlider.setStyle("-fx-control-inner-background: null");
        transportProgressBar.setStyle("-fx-accent: #F66A80");
        otherSlider.setStyle("-fx-control-inner-background: null");
        otherProgressBar.setStyle("-fx-accent: #F66A80");
        savingsSlider.setStyle("-fx-control-inner-background: null");
        savingsProgressBar.setStyle("-fx-accent: #F66A80");}

    /**
     * Sets the sliders max to the income.
     */
    public void setSliders(final int income){
        foodSlider.setMax(income);
        householdSlider.setMax(income);
        shoppingSlider.setMax(income);
        transportSlider.setMax(income);
        savingsSlider.setMax(income);
        otherSlider.setMax(income);
    }

    /**
     * Sets the progressbar according to the foodslider/income ratio.
     * @param income value of the income
     * @param foodSlider value of the foodSlider
     * @param houseHoldSlider value of the houseHoldSlider
     * @param shoppingSlider value of the shoppingSlider
     * @param transportSlider value of the transportSlider
     * @param otherSlider value of the otherSlider
     * @param savingsSlider value of the savingsSlider
     */
    public void setProgressBar(final int income, final double foodSlider, final double houseHoldSlider,
                               final double shoppingSlider, final double transportSlider,
                               final double otherSlider, final double savingsSlider){

        foodProgressBar.setProgress(foodSlider / income);
        householdProgressBar.setProgress(houseHoldSlider / income);
        shoppingProgressBar.setProgress(shoppingSlider / income);
        transportProgressBar.setProgress(transportSlider / income);
        otherProgressBar.setProgress(otherSlider / income);
        savingsProgressBar.setProgress(savingsSlider / income);
    }

    /**
     * Updates the sliders.
     * @param foodBudget budget of the food
     * @param houseHoldBudget budget of the houseHold
     * @param shoppingBudget budget of the shopping
     * @param transportBudget budget of the transport
     * @param otherBudget budget of the other
     * @param savingBudget budget of the saving
     * @param incomeBudget budget of the income
     */
    public void updateSlidersWithBudget(final int foodBudget, final int houseHoldBudget, final int shoppingBudget,
                                        final int transportBudget, final int otherBudget, final int savingBudget,
                                        final String incomeBudget){
        foodSlider.setValue(foodBudget);
        householdSlider.setValue(houseHoldBudget);
        shoppingSlider.setValue(shoppingBudget);
        transportSlider.setValue(transportBudget);
        otherSlider.setValue(otherBudget);
        savingsSlider.setValue(savingBudget);
        enterIncomeTextField.setText(incomeBudget);
    }

    /**
     * Sets the totalMoneyLeft Labels text.
     * @param number the amount it should set it to
     */
    public void setTotalMoney(final String number){
        totalMoney.setText(number);
    }

    /**
     * Sets the moneyLeft Labels text.
     * @param number the amount it should set it to
     */
    public void setMoneyLeft(final String number){
        moneyLeft.setText(number);
    }

    /**
     * Sets the MoneyLeft Label to red.
     */
    public void setMoneyLeftToGreen(){
        moneyLeft.setStyle("-fx-text-fill: green");
    }

    /**
     * Sets the MoneyLeft Label to grey.
     */
    public void setMoneyLeftToRed(){
        moneyLeft.setStyle("-fx-text-fill: red");
    }

    /**
     * Shows the BudgetChartPage.
     */
    public void showBudgetChartPage(){
        parent.showBudgetCharPage();
    }

    /**
     * Sets the incomeTextField red.
     */
    public void setIncomeToRed() {
        enterIncomeTextField.setStyle(" -fx-border-color: Red");
    }

    /**
     * Sets the incomeTextField grey.
     */
    public void setIncomeToGrey() {
        enterIncomeTextField.setStyle(" -fx-border-color: Grey");

    }
}
