package de.faktorzehn.pmo.layout;

import org.linkki.core.ui.aspects.annotation.BindSuffix;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.ui.nested.annotation.UINestedComponent;

import de.faktorzehn.annotation.prefix.BindPrefix;
import de.faktorzehn.model.Person;

@UISection(caption = "NestedSectionPmo")
public class NestedSectionPmo {

    private String sample = "some sample text";

    @BindSuffix("(╯‵□′)╯︵┻━┻")
    @BindPrefix("o((>ω< ))o")
    @UITextField(position = 10, label = "Sample:")
    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @UINestedComponent(position = 20)
    public HorizontalLayoutSectionPmo getHorizontalLayoutSectionPmo() {
        return new HorizontalLayoutSectionPmo(new Person());
    }
}
