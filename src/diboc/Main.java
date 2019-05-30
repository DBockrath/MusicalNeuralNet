package diboc;

//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;

//public class Main extends Application {

public class Main {

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
//        primaryStage.setTitle("Music Generator");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//
//    }

    public static void main(String[] args) {

//        launch(args);

        Pitch pitch = new Pitch(Pitches.B0);
        Note note = new Note(pitch, Length.WHOLE);
        TimeSignature timeSignature = new TimeSignature(20, 4, Length.QUARTER);
        note.play(timeSignature);

    }

}
