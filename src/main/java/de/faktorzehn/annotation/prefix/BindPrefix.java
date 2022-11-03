package de.faktorzehn.annotation.prefix;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.linkki.core.binding.descriptor.aspect.Aspect;
import org.linkki.core.binding.descriptor.aspect.LinkkiAspectDefinition;
import org.linkki.core.binding.descriptor.aspect.annotation.AspectDefinitionCreator;
import org.linkki.core.binding.descriptor.aspect.annotation.LinkkiAspect;
import org.linkki.core.binding.descriptor.aspect.base.ModelToUiAspectDefinition;
import org.linkki.core.binding.wrapper.ComponentWrapper;
import org.linkki.util.Consumers;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.HasPrefixAndSuffix;

@Target({ ElementType.METHOD, ElementType.TYPE, })
@Retention(RetentionPolicy.RUNTIME)
@LinkkiAspect(BindPrefix.BindPrefixAspectDefinitionCreator.class)
public @interface BindPrefix {

    String value() default StringUtils.EMPTY;

    PrefixType prefixType() default PrefixType.AUTO;

    enum PrefixType {
        AUTO,
        STATIC,
        DYNAMIC
    }

    class BindPrefixAspectDefinitionCreator implements AspectDefinitionCreator<BindPrefix> {


        @Override
        public LinkkiAspectDefinition create(BindPrefix annotation) {
            return new PrefixAspectDefinition(annotation.prefixType(), annotation.value());
        }
    }

    class PrefixAspectDefinition extends ModelToUiAspectDefinition<String> {

        public static final String NAME = "prefix";

        private final PrefixType type;
        private final String prefix;

        public PrefixAspectDefinition(PrefixType type, String prefix) {
            this.type = type;
            this.prefix = prefix;
        }

        @Override
        public Aspect<String> createAspect() {
            switch (type) {
                case DYNAMIC:
                    return Aspect.of(NAME);
                case AUTO:
                    if (StringUtils.isEmpty(prefix)) {
                        return Aspect.of(NAME);
                    } else {
                        return Aspect.of(NAME, prefix);
                    }
                case STATIC:
                    return Aspect.of(NAME, prefix);
                default:
                    throw new IllegalStateException("Unknown " + NAME + " type: " + type);
            }
        }

        @Override
        public Consumer<String> createComponentValueSetter(ComponentWrapper componentWrapper) {
            Object component = componentWrapper.getComponent();

            if (component instanceof HasPrefixAndSuffix) {
                HasPrefixAndSuffix field = (HasPrefixAndSuffix)component;
                return text -> field.setPrefixComponent(new Div(new Text(text)));
            } else {
                return Consumers.nopConsumer();
            }
        }
    }

}
