package br.ifsul.bdii.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UILogin extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("primary"));
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(UILogin.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	// /**
	//  * Create the frame.
	//  */
	// public UILogin() {
	// 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	setBounds(100, 100, 450, 300);
	// 	contentPane = new JPanel();
	// 	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	// 	setContentPane(contentPane);
	// }

}
