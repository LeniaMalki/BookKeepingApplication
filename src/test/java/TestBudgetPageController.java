import Model.BudgetLogic.Budget;
import javafx.scene.control.Slider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBudgetPageController {

Budget budget;
Slider slider;

    @BeforeEach
    public void setUp() {
        budget = new Budget(200,200,200,200, 200, 200, "1200");
    }

    @Test
    public void setMaxOnSliderTest(){
        slider.setMax(1200);
    }

    @Test
    public void updatingMoneyLeftTest (){

    }
}
