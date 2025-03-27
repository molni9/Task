package college.tusck.App.Controller.IntegrationController;

import college.tusck.App.Model.IntegrationRequest.IntegrationRequest;
import college.tusck.App.Model.IntegrationResponse.IntegrationResponse;
import college.tusck.App.Service.IntegrationService.IntegrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrationController {
    private final IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @PostMapping("/api/integrate")
    public IntegrationResponse integrate(@RequestBody IntegrationRequest request) {
        return integrationService.calculate(request);
    }
}
