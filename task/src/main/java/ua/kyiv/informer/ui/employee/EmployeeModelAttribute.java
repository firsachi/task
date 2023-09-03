package ua.kyiv.informer.ui.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.PhoneService;
import ua.kyiv.informer.logic.service.PositionService;
import ua.kyiv.informer.logic.service.RoomService;

import java.util.HashSet;

@Component
public class EmployeeModelAttribute {

    @Autowired
    private PositionService positionService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private RoomService roomService;

    public void getAttributes(Model model) {
        model.addAttribute("allPhone", phoneService.getAll("allPhone"));
        model.addAttribute("positions", positionService.getPositions());
        model.addAttribute("companies", new HashSet<>(companyService.all(false)));
        model.addAttribute("allRoom", roomService.all("allRooms"));
    }
}
