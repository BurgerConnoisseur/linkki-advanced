package de.faktorzehn.pmo.section;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.vaadin.component.page.AbstractPage;

import de.faktorzehn.pmo.section.header.ClosableSectionPmo;
import de.faktorzehn.pmo.section.header.SectionHeaderSectionPmo;

public class SectionPageTwo extends AbstractPage {

    private static final long serialVersionUID = 1L;

    private final BindingManager bindingManager = new DefaultBindingManager();

    public SectionPageTwo() {
    }

    @Override
    public void createContent() {
        addSection(new ClosableSectionPmo());
        addSection(new SectionHeaderSectionPmo());
    }

    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }

}
