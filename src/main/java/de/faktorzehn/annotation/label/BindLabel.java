package de.faktorzehn.annotation.label;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Consumer;

import org.linkki.core.binding.descriptor.aspect.Aspect;
import org.linkki.core.binding.descriptor.aspect.LinkkiAspectDefinition;
import org.linkki.core.binding.descriptor.aspect.annotation.AspectDefinitionCreator;
import org.linkki.core.binding.descriptor.aspect.annotation.LinkkiAspect;
import org.linkki.core.binding.descriptor.aspect.base.StaticModelToUiAspectDefinition;
import org.linkki.core.binding.wrapper.ComponentWrapper;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@LinkkiAspect(BindLabel.BindLabelAspectDefinitionCreator.class)
public @interface BindLabel {

    class BindLabelAspectDefinitionCreator implements AspectDefinitionCreator<BindLabel> {

        @Override
        public LinkkiAspectDefinition create(BindLabel annotation) {
            return new BindLabelAspectDefinition();
        }
    }

    class BindLabelAspectDefinition extends StaticModelToUiAspectDefinition<String> {

        public static final String NAME = "label";

        @Override
        public Aspect<String> createAspect() {
            return Aspect.of(NAME);
        }

        @Override
        public Consumer<String> createComponentValueSetter(ComponentWrapper componentWrapper) {
            return componentWrapper::setLabel;
        }

    }
}
