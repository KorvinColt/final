import java.util.Scanner;

// Определение интерфейса для контроллера
interface CalculatorController {
    void performCalculation();
}

// Реализация контроллера
class SimpleCalculatorController implements CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private Scanner scanner;

    public SimpleCalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void performCalculation() {
        System.out.print("Enter operand 1: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Enter operand 2: ");
        double operand2 = scanner.nextDouble();

        System.out.print("Choose operation (+, *, /): ");
        String operation = scanner.next();

        switch (operation) {
            case "+":
                model.setOperation(new Addition());
                break;
            case "*":
                model.setOperation(new Multiplication());
                break;
            case "/":
                model.setOperation(new Division());
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }

        double result = model.performOperation(operand1, operand2);
        view.displayResult(result);
    }
}

// Главный класс приложения
class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new SimpleCalculatorController(model, view);

        controller.performCalculation();
    }
}
