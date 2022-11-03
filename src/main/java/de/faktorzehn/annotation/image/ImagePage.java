package de.faktorzehn.annotation.image;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

public class ImagePage extends AbstractPage {

    private static final long serialVersionUID = 1L;

    private final BindingManager bindingManager = new DefaultBindingManager();

    public ImagePage() {
    }

    @Override
    public void createContent() {
        addSection(new ImagePmo(new RandomImageProvider()::get));
    }

    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }


}