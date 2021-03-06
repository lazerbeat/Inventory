package com.aincorp.inventory;

import com.aincorp.inventory.presentation.mainpage.MainPageView;
import com.airhacks.afterburner.injection.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*
         * Properties of any type can be easily injected.
         */
        LocalDate date = LocalDate.of(4242, Month.JULY, 21);
        Map<Object, Object> customProperties = new HashMap<>();
        customProperties.put("date", date);
        /*
         * any function which accepts an Object as key and returns
         * and return an Object as result can be used as source.
         */
        Injector.setConfigurationSource(customProperties::get);

        System.setProperty("happyEnding", " Enjoy the flight!");
        MainPageView appView = new MainPageView();
        //Надо зделать это окно исчезающим
        //SplashScreen appView = new SplashScreen();
        Scene scene = new Scene(appView.getView());
        stage.setTitle("Инвентаризация");
        final String uri = getClass().getResource("app.css").toExternalForm();
        scene.getStylesheets().add(uri);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Injector.forgetAll();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
