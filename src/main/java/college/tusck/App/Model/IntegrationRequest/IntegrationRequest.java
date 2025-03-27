package college.tusck.App.Model.IntegrationRequest;

import college.tusck.App.Model.FunctionType.FunctionType;

public record IntegrationRequest(
        FunctionType functionType,
        double lowerBound,
        double upperBound,
        int intervals,
        String customFunction // Для FunctionType.CUSTOM
) {}
