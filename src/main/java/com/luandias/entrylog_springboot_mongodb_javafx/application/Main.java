package com.luandias.entrylog_springboot_mongodb_javafx.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/luandias/entrylog_springboot_mongodb_javafx/gui/MainView.fxml"));
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Entry Log System");
			primaryStage.show();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
