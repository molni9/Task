package college.tusck.App.Model.IntegrationResponse;

public record IntegrationResponse(
        double result,
        String status,
        String errorMessage
) {}
