package college.tusck.App.Service.FunctionFactory;


import college.tusck.App.Model.IntegrationRequest.IntegrationRequest;
import college.tusck.App.Service.IntegrableFunction.IntegrableFunction;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngineManager;

@Service
public class FunctionFactory {
    public IntegrableFunction getFunction(IntegrationRequest request) {
        return switch (request.functionType()) {
            case SIN -> x -> Math.sin(x);
            case COS -> x -> Math.cos(x);
            case SQUARE -> x -> x * x;
            case EXP -> Math::exp;
            case LN -> Math::log;
            case CUSTOM -> createCustomFunction(request.customFunction());
        };
    }

    private IntegrableFunction createCustomFunction(String expression) {
        // Реализация парсинга пользовательской функции
        return x -> {
            try {
                return Double.parseDouble(new ScriptEngineManager()
                        .getEngineByName("JavaScript")
                        .eval(expression.replace("x", String.valueOf(x)))
                        .toString());
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid function expression");
            }
        };
    }
}
