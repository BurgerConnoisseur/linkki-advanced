package de.faktorzehn.pmo.section;

import org.linkki.core.binding.dispatcher.behavior.PropertyBehavior;
import org.linkki.core.binding.dispatcher.behavior.PropertyBehaviorProvider;
import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.binding.validation.ValidationService;
import org.linkki.core.vaadin.component.page.AbstractPage;

import com.vaadin.flow.component.html.Hr;

import de.faktorzehn.model.Address;
import de.faktorzehn.model.Person;
import de.faktorzehn.pmo.section.doublecolumn.DoubleColumnAddressSectionPmo;
import de.faktorzehn.pmo.section.doublecolumn.DoubleColumnPersonSectionPmo;
import de.faktorzehn.pmo.section.longlabel.LongLabelSectionPmo;
import de.faktorzehn.pmo.section.singlecolumn.AddressSectionPmo;
import de.faktorzehn.pmo.section.singlecolumn.PersonSectionPmo;

public class SectionPageOne extends AbstractPage {

    private static final long serialVersionUID = 1L;

    private final BindingManager bindingManager = new DefaultBindingManager(
            ValidationService.NOP_VALIDATION_SERVICE,
            PropertyBehaviorProvider.with(
                    PropertyBehavior.readOnly()
            )
    );

    public SectionPageOne() {
    }

    @Override
    public void createContent() {
        addSection(new PersonSectionPmo(new Person()));
        addSection(new AddressSectionPmo(new Address()));

        add(new Hr());

        addSection(new DoubleColumnPersonSectionPmo(new Person()));
        addSection(new DoubleColumnAddressSectionPmo(new Address()));

        add(new Hr());

        addSection(new PersonSectionPmo(new Person()));
        addSection(new DoubleColumnPersonSectionPmo(new Person()));
        addSection(new LongLabelSectionPmo());
    }

    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }

}
