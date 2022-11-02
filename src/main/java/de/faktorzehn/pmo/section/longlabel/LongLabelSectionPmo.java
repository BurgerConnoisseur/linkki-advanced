package de.faktorzehn.pmo.section.longlabel;

import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UIFormSection;

@UIFormSection(caption = "LongLabelSectionPmo")
public class LongLabelSectionPmo {

    @UITextField(position = 10, label = "This is an element that has a very long label")
    public String getLongLabel() {
        return "🍔🍔";
    }
}
