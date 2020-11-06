package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ImageView logoView = new ImageView();

        Image image = new Image(getResourceStream("itstep-logo.png"));

        logoView.setImage(image);
        logoView.setPreserveRatio(true);
        logoView.setFitWidth(100);

        playAnimation(logoView);

        Scene scene = new Scene(new StackPane(logoView), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Simple application in JavaFX");
        stage.show();
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    private InputStream getResourceStream(String filename) {
        return App.class.getClassLoader().getResourceAsStream(filename);
    }

    public static void main(String[] args) {
        launch();
    }

}