package Object;

import com.jfoenix.controls.JFXButton;

import javafx.scene.layout.AnchorPane;

public class Border extends AnchorPane{
    JFXButton button;
    public JFXButton getButton() {
        return button;
    }
    public void setButton(JFXButton button) {
        this.button = button;
    }
    public Border() {
        button=new JFXButton("Começar");
        this.getChildren().add(button);
    }
}
