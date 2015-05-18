package game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;


public class Main extends Application{
	
	private Button button = null;
	private Group root = null;
	private ImageView bkgrd = null ;
	private Node flappy = null;
	private TranslateTransition jump;
	
    private void addActionEventHandler(){
    	button.setOnAction(new EventHandler<ActionEvent>(){
    		public void handle(ActionEvent event){
    			
    		}
    	});
    }
    
    private void addMouseEventHandler(){
    	bkgrd.onMouseClickedProperty().set(new EventHandler<MouseEvent>(){
    		public void handle(MouseEvent event){
    			
    		}
    	});
    }	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		//TODO 1: add background
		bkgrd = new ImageView("background.png");

		
		
		//TODO 2: add Flappy
		flappy = new ImageView("flappy.png");
		
		
		//TODO 3: add Button
		button = new Button();
		button.setLayoutX(200);
		button.setLayoutY(200);
		
		
		//Create a Group 
		root = new Group( );
		root.getChildren().add(bkgrd );
		
		//TODO 4: add action handler to the button
		addActionEventHandler();

		//TODO 5: add mouse handler to the scene
		addMouseEventHandler();
		
		
		//add Interpolator
		jump = new TranslateTransition(Duration.millis(2000), flappy);
		jump.setCycleCount(Timeline.INDEFINITE);
		jump.setInterpolator(new Interpolator(){
			protected double curve(double t){
				double a = 0.9;
				return a * t * t + (1 - a) * t;
			}
		});
		
		//Create scene and add to stage
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
