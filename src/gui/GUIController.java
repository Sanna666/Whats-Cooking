package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Controller class for GUI. 
 * @author Sofia Larsson
 */
public class GUIController implements Initializable {
		
		@FXML private Button btnAdmin;
		@FXML private Button btnUser;
		
		@FXML private Button btnLogin; 
		@FXML private Label lblLogIn;
		@FXML private Label lblStatus;
		@FXML private Button btnContact;

		@FXML private PasswordField txtPassword;
		@FXML private TextField txtUsername; 
		private DBConnection db;
		@FXML public Button closeButton;
		
		public GUIController(){
			this.btnLogin = new Button();
			this.btnUser = new Button();
			this.btnAdmin = new Button();
			this.btnContact = new Button();
			this.db = new DBConnection();
		}
		/**
		 * Method that is called whenever an event occurs. 
		 * @param event
		 * @throws Exception
		 */
		@FXML
		private void handleButtonAction(ActionEvent event) throws IOException {
			
			btnContact.setOnAction(e -> {
				AlertBox.blueprint("Contact", "Email support at: support@whatscooking.com", "Return to login", 100, 300);
			});
			
			if(event.getSource() == btnAdmin) {
				Parent parentLogin = FXMLLoader.load( getClass().getResource("/gui/Login.fxml"));//Instantiate a parent
				Scene sceneLogin = new Scene(parentLogin);
				Stage window = (Stage)((Node)event.getSource() ).getScene().getWindow();
				closeButton = new Button("Close the window");
				closeButton.setOnAction( e -> window.close() );
				window.setHeight(350);
				window.setWidth(424);
				window.setScene(sceneLogin);
				window.show();
			}
			if(event.getSource() == btnUser) {
				System.out.println("på G");
//				Parent parentClient = FXMLLoader.load( getClass().getResource("/gui/Client.fxml"));//Instantiate a parent
//				Scene sceneClient = new Scene(parentClient);
//				Stage window = (Stage)((Node)event.getSource() ).getScene().getWindow();
//				closeButton = new Button("Close the window");
//				closeButton.setOnAction( e -> window.close() );
//				window.setScene(sceneClient);
//				window.show();
			}

			if(event.getSource() == btnLogin) {
				if(txtUsername.getText().equals(db.getUsername()) && txtPassword.getText().equals(db.getPassword())){
					lblStatus.setTextFill(Color.web("#43af43"));
					lblStatus.setText("Log in successful!");
					db.initiate();
					Parent parentAdminMenu = FXMLLoader.load( getClass().getResource("/gui/AdminMenu.fxml"));//Instantiate a parent
					Scene sceneAdminMenu = new Scene(parentAdminMenu);
					Stage window = (Stage)((Node)event.getSource() ).getScene().getWindow();
					closeButton = new Button("Close the window");
					closeButton.setOnAction( e -> window.close() );
					window.setScene(sceneAdminMenu);
					window.show();
				} else {

			
			if(event.getSource() == btnAdmin) {  

				((Node)(event.getSource())).getScene().getWindow().hide(); 
				Stage stageLogin = new Stage();
				Parent rootLogin = null;
				try {
					rootLogin = FXMLLoader.load( getClass().getResource("/gui/Login.fxml") );
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene sceneLogin = new Scene(rootLogin, Color.TRANSPARENT);
				stageLogin.initStyle(StageStyle.TRANSPARENT);
				stageLogin.setScene(sceneLogin);
				stageLogin.show();
				
			} else if(event.getSource() == btnLogin){
				
					if(txtUsername.getText().equals(db.getUsername()) && txtPassword.getText().equals(db.getPassword()) ){
						lblStatus.setTextFill(Color.web("#43af43"));
						lblStatus.setText("Log in successful!");
						
						((Node)(event.getSource())).getScene().getWindow().hide();
						Stage stageMenu = new Stage();
						Parent rootMenu = null;
						try {
							rootMenu = FXMLLoader.load( getClass().getResource("/gui/Menu.fxml") );
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene sceneMenu = new Scene(rootMenu,Color.TRANSPARENT);
						stageMenu.initStyle(StageStyle.TRANSPARENT);
						stageMenu.setScene(sceneMenu);
						stageMenu.show();
						db.initiate();
					} else {

					txtUsername.clear();
					txtPassword.clear();
					lblStatus.setTextFill(Color.web("#ff6347"));
					lblStatus.setText("Ooops! Try again!");
					}
			  }
				}
			}
		}
			
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO 
			
		}	
			
	}
		
	