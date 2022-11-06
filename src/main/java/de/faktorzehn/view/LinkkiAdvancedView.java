package de.faktorzehn.view;

import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.linkki.core.vaadin.component.page.AbstractPage;
import org.linkki.core.vaadin.component.tablayout.LinkkiTabLayout;
import org.linkki.core.vaadin.component.tablayout.LinkkiTabSheet;
import org.linkki.framework.ui.component.Headline;

import de.faktorzehn.annotation.image.ImagePage;
import de.faktorzehn.i18n.I18NPage;
import de.faktorzehn.pmo.section.SectionPageOne;
import de.faktorzehn.pmo.layout.LayoutPage;
import de.faktorzehn.pmo.section.SectionPageTwo;
import de.faktorzehn.pmo.table.TablePage;
import de.faktorzehn.ui.LinkkiAdvancedLayout;

@PageTitle("Linkki Advanced")
@Route(value = "", layout = LinkkiAdvancedLayout.class)
public class LinkkiAdvancedView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public LinkkiAdvancedView() {
        add(new Headline("Linkki Advanced"));
        setSizeFull();

        setPadding(false);
        setSpacing(false);

        var sidebar = LinkkiTabLayout.newSidebarLayout();
        sidebar.addTabSheets(tabSheets());

        add(sidebar);
    }

    public List<LinkkiTabSheet> tabSheets() {
        return pages().stream()
                .peek(AbstractPage::init)
                .map(this::tabSheetOf)
                .collect(Collectors.toList());
    }

    public List<AbstractPage> pages() {
        return List.of(
                new LinkkiAdvancedPage(),
                new SectionPageOne(),
                new SectionPageTwo(),
                new LayoutPage(),
                new TablePage(),
                new ImagePage(),
                new I18NPage()
        );
    }

    public LinkkiTabSheet tabSheetOf(AbstractPage page) {
        return LinkkiTabSheet.builder(page.getClass().getSimpleName())
                .caption(page.getClass().getSimpleName())
                .content(() -> page)
                .build();
    }
}