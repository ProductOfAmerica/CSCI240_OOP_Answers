package Interpreter.Main;

import Interpreter.Lexer.Lexer;
import Interpreter.Lexer.Token.Token;
import Interpreter.Parser.Parser;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main extends Application implements Initializable{
    private Stage stage;
    @FXML private TextArea outputArea;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml")); //Set the root fxml source file
        stage = primaryStage;
        stage.setTitle("Lee's Main"); //Set the title-bar
        stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight())); //Set the dimensions
        stage.setResizable(false); //Make sure the user can't resize the screen
        stage.show(); //Set it's visibility to true
        stage.toFront(); //Bring the frame to the front
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        outputArea.setEditable(false); //Make sure the user can't type in the TextArea;
        outputArea.setStyle("-fx-font-family: monospace"); //Formatting style for the javafx TextArea

        new Output(outputArea); //Re-route the console output (errors) to |outputArea|
    }


    @FXML
    private void exitButtonPressed(){
        System.exit(1); //Close menu, stop script.
    }


    @FXML
    private void fileButtonPressed() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(initFileChooser())); //Using a scanner to look through file contents
        clear(); //Clear output screen
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().replaceAll(" ", "");
            if (!inputLine.startsWith("#")) {
                String answerLine = scanner.nextLine().replaceAll(" ", "");
                if (scanner.hasNextLine() && !answerLine.startsWith("#")) {
                    interpret(inputLine, answerLine);
                } else {
                    System.err.println("Second expression not found.");
                }
            }
        }
        scanner.close(); //Done with the scanner, close it
    }


    @FXML
    private void expressionButtonPressed(){
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Interpreter",
                new ArrayList<String>(){{add("Interpreter"); add("Evaluation");}});
        choiceDialog.setTitle("Choose Input Type");
        choiceDialog.setHeaderText("Select your input type");
        choiceDialog.initStyle(StageStyle.UTILITY);

        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Input expression into dialogue box below.");
        dialog.initStyle(StageStyle.UTILITY);

        Optional<String> result = choiceDialog.showAndWait();
        if(result.isPresent()) {
            clear(); //Clear the output screen
            Optional<String> input;
            switch (result.get()) {
                case "Interpreter":
                    dialog.setTitle("Interpreter Input"); //Set the title
                    input = dialog.showAndWait(); //Make it appear, wait for input
                    input.ifPresent(s -> interpret(s, true)); //Interpret the answer
                    break;
                case "Evaluation":
                    dialog.setTitle("Evaluation Input");
                    input = dialog.showAndWait();
                    input.ifPresent(s -> interpret(s, false));
                    break;
            }
        }
    }


    /**
     * Initializes the file chooser. Returns a string of the chosen file location.
     * @return A string location of the chosen file.
     */
    private String initFileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Input file (.in)", "*.in"));

        return fileChooser.showOpenDialog(stage).getPath();
    }


    /**
     * This method simply takes in two inputs, and outputs their corresponding answer
     * @param input The input we're parsing
     * @param answer The answer we're looking for
     */
    private void interpret(String input, String answer){
        try {
            Parser parser = new Parser(new Lexer(input).getTokenList());
            double parsedValue = parser.parse();
            if(eqpisolnEquals(parsedValue, Double.parseDouble(answer))){
                System.out.printf("Correct: '%s' == %.4f", input, parsedValue);
            }else{
                System.out.print("Unsupported: " + input);
            }
        } catch (ParseException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println();
    }


    /**
     * Compares the two doubles and checks to see if they are within 2 trillionths of each other
     * @param one Input variable one
     * @param two Input variable two
     * @return True if within range
     */
    private boolean eqpisolnEquals(double one, double two){
        return ((one - two) < 0.000000000001);
    }


    /**
     * Lexes the input. If an exception is thrown, the output is caught and printed to the screen.
     * @param input The input we're going to lex
     * @param lexer Whether or not we're parsing or lexing. True = lexing
     */
    private void interpret(String input, boolean lexer){
        System.out.print("The expression '" + input + (lexer ? "':\n" : "' has value "));

        try {
            if(lexer){
                System.out.println(String.format("%-22s%-17s%-17s\n%s", "Token Type", "Lexeme", "Value",
                        "============================================"));
                for(Token token : new Lexer(input).getTokenList()){
                    System.out.println(token.toString()); //For all of the tokens in the list, print them out (formatted)
                }
            }else {
                Parser parser = new Parser(new Lexer(input).getTokenList());
                System.out.println(parser.parse());
            }

        }catch (NumberFormatException e){
            System.out.println("Eval error: Lex failed: '" + e.getMessage()
                    + "' on exception java.lang.NumberFormatException: multiple points");
        } catch (NoSuchFieldException e) {
            Character badChar = getBadChar(e.getMessage(), "!@#$%^&*()_+=-/\\");
            if(badChar != null)
                System.out.println("Eval error: Lex failed on this character: '" + badChar
                        + "' with this String remaining: " + e.getMessage().substring(e.getMessage().indexOf(badChar)));
        }catch (ParseException e){
            System.out.println("\nParse error: " + e.getMessage());
        }
    }


    /**
     * Clears the output area.
     */
    private void clear(){
        outputArea.clear();
    }


    /**
     * Returns the "bad" character from the list provided |badChars| if there is a bad character in |str|
     * @param str The string we're searching for "bad characters" in
     * @param badChars The list of characters we're searching for as bad
     * @return The first bad character (if one exists) else null is returned
     */
    private Character getBadChar(String str, String badChars){
        for(Character c : str.toCharArray()){
            for (Character c2 : badChars.toCharArray()){
                if(c2 == c)
                    return c;
            }
        }
        return null;
    }


    /**
     * This class will be used to re-route the System console output
     * to the Main class's output TextArea.
     */
    private static class Output extends OutputStream{
        private TextArea textArea;

        public Output(TextArea textArea) {
            this.textArea = textArea;

            PrintStream ps = new PrintStream(this, true); //Set output destination, and auto-flush to true
            System.setOut(ps); //Set the output stream
            System.setErr(ps); //Set the output error stream
        }

        @Override
        public void write(int b) throws IOException {
            textArea.appendText(String.valueOf((char) b)); //Write all of the outputs to the console
        }
    }
}