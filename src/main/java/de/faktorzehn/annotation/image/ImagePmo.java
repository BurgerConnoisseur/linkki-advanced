package de.faktorzehn.annotation.image;

import java.util.function.Supplier;

import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.layout.annotation.SectionHeader;
import org.linkki.core.ui.layout.annotation.UISection;

import com.vaadin.flow.component.icon.VaadinIcon;

@UISection(caption = "ImagePmo")
public class ImagePmo {

    private final Supplier<String> imageUrlSupplier;

    public ImagePmo(Supplier<String> imageUrlSupplier) {
        this.imageUrlSupplier = imageUrlSupplier;
    }

    @SectionHeader
    @UIButton(position = 0, caption = "Trigger BindingContext update", icon = VaadinIcon.REFRESH, showIcon = true)
    public void button() {
        // do nothing
    }

    @UIImage(position = 10, width = "500px")
    public String getImage() {
        return imageUrlSupplier.get();
    }
}
