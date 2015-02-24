import ui.elem.*;
import ui.*;

public class WeaponUpgrade extends Stage{
    private Dialog mainDialog;
    private Choice a;
    private Choice b;
    private Choice c;
    private int x = 0;
    private int y = 0;
    
    @Override
    public void choiceClicked(Element elementVar) {
        Choice choiceObject = (Choice)elementVar;
    }
    @Override
    public void taskPerformed() {
    }
    @Override
    public void init() {
        mainDialog = new Dialog("");
        mainDialog.setText("Hi!", "Weapon: ", "Level: ", "Upgradeable: ");
    }
}
