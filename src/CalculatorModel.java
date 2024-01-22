// Определение интерфейса для операций
interface Operation {
    double calculate(double operand1, double operand2);
}

// Реализация сложения
class Addition implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }
}

// Реализация умножения
class Multiplication implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 * operand2;
    }
}

// Реализация деления
class Division implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return operand1 / operand2;
    }
}

// Класс, представляющий калькулятор (Модель)
class CalculatorModel {
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double performOperation(double operand1, double operand2) {
        if (operation == null) {
            throw new IllegalStateException("Operation not set");
        }
        return operation.calculate(operand1, operand2);
    }
}

