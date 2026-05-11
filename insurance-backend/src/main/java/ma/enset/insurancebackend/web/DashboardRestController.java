package ma.enset.insurancebackend.web;

import lombok.AllArgsConstructor;
import ma.enset.insurancebackend.dtos.DashboardDTO;
import ma.enset.insurancebackend.services.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DashboardRestController {
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public DashboardDTO dashboard() {
        return dashboardService.getDashboard();
    }
}
