package A12_109403020;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {
	@FXML
	private ImageView img;

	
	@FXML
    private RadioButton RbYes;

    @FXML
    private ToggleGroup rb;

    @FXML
    private RadioButton RbNo;

    @FXML
    private Button btn;
    Image myimg = new Image(getClass().getResourceAsStream("ton2.png"));
    Image another = new Image(getClass().getResourceAsStream("ton1.png"));

    @FXML
    public void handler()
    {
    	if(RbYes.isSelected())
    	{
    		img.setImage(myimg); 
    	}
    	else if(RbNo.isSelected())
    	{
    		img.setImage(another);
    	}
    }
}
