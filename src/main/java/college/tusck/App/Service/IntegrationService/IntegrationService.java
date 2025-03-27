package college.tusck.App.Service.IntegrationService;

import college.tusck.App.Model.IntegrationRequest.IntegrationRequest;
import college.tusck.App.Model.IntegrationResponse.IntegrationResponse;
import college.tusck.App.Service.FunctionFactory.FunctionFactory;

import college.tusck.App.Service.IntegrableFunction.IntegrableFunction;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {
    private final FunctionFactory functionFactory;

    public IntegrationService(FunctionFactory functionFactory) {
        this.functionFactory = functionFactory;
    }

    public IntegrationResponse calculate(IntegrationRequest request) {
        try {
            validateRequest(request);

            IntegrableFunction function = functionFactory.getFunction(request);
            double result = calculateIntegral(
                    function,
                    request.lowerBound(),
                    request.upperBound(),
                    request.intervals()
            );

            return new IntegrationResponse(result, "SUCCESS", null);
        } catch (IllegalArgumentException e) {
            return new IntegrationResponse(0, "ERROR", e.getMessage());
        }
    }

    private double calculateIntegral(IntegrableFunction function,
                                     double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            double xMid = a + h * (i + 0.5);
            sum += function.calculate(xMid);
        }
        return sum * h;
    }

    private void validateRequest(IntegrationRequest request) {
        if (request.intervals() <= 0) {
            throw new IllegalArgumentException("Intervals must be greater than 0");
        }
        if (request.upperBound() <= request.lowerBound()) {
            throw new IllegalArgumentException("Upper bound must be greater than lower bound");
        }
    }
}