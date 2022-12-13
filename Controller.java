package ratheror.ratheror;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private Label label_label;

    @FXML
    Button button_q1, button_q2;
    String [] strings;

    public Controller() throws IOException {

   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        String file = "ratheror.txt";
        try {
            String[] strings = loadFileToArray(file);

            for (int k = 0; k < strings.length -1; k++){
                String curr = strings[k];
                String next = strings[k+1];

                label_label.setText(next);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        button_q1.setText("A");
        button_q2.setText("B");


        button_q1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String file = "ratheror.txt";
                try {
                    String[] strings = new String[0];
                    try {
                        strings = loadFileToArray(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Random random = new Random();
                    int index = random.nextInt(strings.length);
                    label_label.setText(strings[index]);
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        button_q2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String file = "ratheror.txt";
                try {
                    String[] strings = new String[0];
                    try {
                        strings = loadFileToArray(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Random random = new Random();
                    int index = random.nextInt(strings.length);
                    label_label.setText(strings[index]);
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }

        });

    }

    public String [] loadFileToArray(String fileName) throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        String[] rr = listOfLines.toArray(new String[0]);

        return rr;

    }
}
