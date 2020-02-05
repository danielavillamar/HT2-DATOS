package application;

import java.io.File;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;

public class MainController {
	
	@FXML
	private TextField pathTextField;
	@FXML
	private Label result;
	@FXML	
	private FlowPane resultFlowPane;
	
	//Implementacion Stack 
	private Stack<Integer> stack;
	//objeto de la clase que implementa Calculator
	private Calculator calculator;
	// Se almacena la informacion leida en el archivo txt
	private Scanner s;
	
	// Acción para leer archivo txt
	public void read() {
		// Verificación de errores y si no hay ningun error o algo que le impida seguir puede leer el archivo.
		if(verifyPath()) {
			//Revision total del archivo.
			String line = "";
			while (s.hasNextLine()) {
				line = s.nextLine()+ " ";
				// Arreglo strings
				String[] text = line.split(" ");
				// Revisión linea archivo txt a utilizar
				for (int i = 0; i < text.length; i++) {
					String value = text[i];
					// Guarda valor en Stack
					try {
						// Prueba conversion int
						Integer intValue = Integer.parseInt(value);
						stack.push(intValue);
					} catch (Exception e) {
						// Si no es = int es operando, se efectua la operacion. Agarra la operación y sus ambos operandos
						String operacion = value;
						int operando2 = stack.pop();
						int operando1 = stack.pop();
						// Proceso de operación
						int resultado = calculator.Calculate(operando1, operando2, operacion);
						//Guarda resultado en primera linea del stack
						stack.push(resultado);
					}
				}
				Label label = new Label("Resultado: "+stack.pop());
				Region p = new Region();
				p.setPrefSize(347.0, 4.0);
				Line linee = new Line(0, 0, 350, 0);
				Region p1 = new Region();
				p1.setPrefSize(347.0, 4.0);
				//Flowplane
				resultFlowPane.getChildren().add(label);
				resultFlowPane.getChildren().add(p);
				resultFlowPane.getChildren().add(linee);
				resultFlowPane.getChildren().add(p1);
			}
		}
	}
	
	//Verificacion path = correcto
	public boolean verifyPath() {
		try {
			//Leer archivo
			s = new Scanner(new File(pathTextField.getText()));
			return true;
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en datos ingresado");
			alert.setContentText("Verifica la dirección del archivo ingresado sea correcta");
			alert.showAndWait();
			return false;
		}
	}
	
	@FXML
    public void initialize() {
		stack = new Stack();
		calculator = new ImpCalculadora();
    }
	
}
