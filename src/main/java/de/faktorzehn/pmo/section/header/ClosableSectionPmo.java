package de.faktorzehn.pmo.section.header;

import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UIFormSection;

@UIFormSection(caption = "ClosableSectionPmo", closeable = true)
public class ClosableSectionPmo {

    @UITextField(position = 10, label = "Sample: ")
    public String getSample() {
        return "some sample text";
    }

}
