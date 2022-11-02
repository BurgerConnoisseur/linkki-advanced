package de.faktorzehn.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.linkki.framework.ui.component.Headline;
import de.faktorzehn.ui.LinkkiAdvancedLayout;

@PageTitle("Linkki Advanced")
@Route(value = "", layout = LinkkiAdvancedLayout.class)
public class LinkkiAdvancedView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public LinkkiAdvancedView() {
        add(new Headline("Linkki Advanced"));
        setSizeFull();
        LinkkiAdvancedPage page = new LinkkiAdvancedPage();
        page.init();
        add(page);
    }
}