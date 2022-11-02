package de.faktorzehn.pmo.layout;

import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.ui.nested.annotation.UINestedComponent;

import de.faktorzehn.model.Person;

@UISection(caption = "NestedSectionPmo")
public class NestedSectionPmo {

    @UITextField(position = 10, label = "Sample:")
    public String getSample() {
        return "some sample text";
    }

    @UINestedComponent(position = 20)
    public HorizontalLayoutSectionPmo getHorizontalLayoutSectionPmo() {
        return new HorizontalLayoutSectionPmo(new Person());
    }
}
