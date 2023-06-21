package ua.kyiv.informer.ui;

import org.springframework.web.bind.annotation.ModelAttribute;

public interface CoreController {

    @ModelAttribute("nameFragment")
    public String getNameFragment();

}
