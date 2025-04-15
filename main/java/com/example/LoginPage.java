package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Login");

        // 布局
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // 组件
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button loginBtn = new Button("Login");

        // 登录验证
        loginBtn.setOnAction(e -> {
            if (authenticate(userField.getText(), passField.getText())) {
                showMainPage();
                primaryStage.close();
            }
        });

        // 添加组件
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginBtn, 1, 2);

        // 场景
        Scene scene = new Scene(new VBox(grid), 350, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 简单验证逻辑（示例用户名/密码：admin/admin）
    private boolean authenticate(String user, String pass) {
        return "admin".equals(user) && "admin".equals(pass);
    }

    // 显示主界面
    private void showMainPage() {
        Stage mainStage = new Stage();
        MainPage mainApp = new MainPage();
        mainApp.start(mainStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}