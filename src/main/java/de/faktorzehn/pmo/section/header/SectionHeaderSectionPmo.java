package de.faktorzehn.pmo.section.header;

import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UILabel;
import org.linkki.core.ui.layout.annotation.SectionHeader;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.framework.ui.dialogs.ConfirmationDialog;
import org.linkki.util.handler.Handler;

@UISection(caption = "SectionHeaderSectionPmo")
public class SectionHeaderSectionPmo {

    @UILabel(position = 10, label = "Text 1")
    public String getText1() {
        return "Text-1";
    }

    @SectionHeader
    @UILabel(position = 20, label = "Text 2")
    public String getText2() {
        return "Text-2";
    }

    @UILabel(position = 30, label = "Text 3")
    public String getText3() {
        return "Text-3";
    }

    @SectionHeader
    @UIButton(position = 40, caption = "Text 4")
    public void text4() {
        new ConfirmationDialog("Thank you!", Handler.NOP_HANDLER).open();
    }

}
