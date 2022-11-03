package de.faktorzehn.annotation.image;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.linkki.core.binding.descriptor.aspect.Aspect;
import org.linkki.core.binding.descriptor.aspect.LinkkiAspectDefinition;
import org.linkki.core.binding.descriptor.aspect.annotation.AspectDefinitionCreator;
import org.linkki.core.binding.descriptor.aspect.annotation.LinkkiAspect;
import org.linkki.core.binding.descriptor.aspect.base.ModelToUiAspectDefinition;
import org.linkki.core.binding.descriptor.property.annotation.BoundPropertyCreator;
import org.linkki.core.binding.descriptor.property.annotation.LinkkiBoundProperty;
import org.linkki.core.binding.uicreation.LinkkiComponent;
import org.linkki.core.binding.uicreation.LinkkiComponentDefinition;
import org.linkki.core.binding.wrapper.ComponentWrapper;
import org.linkki.core.uicreation.ComponentDefinitionCreator;
import org.linkki.core.uicreation.LinkkiPositioned;

import com.vaadin.flow.component.html.Image;


@Retention(RetentionPolicy.RUNTIME)                                                     // (1)
@Target(ElementType.METHOD)                                                             // (1)
@LinkkiBoundProperty(BoundPropertyCreator.SimpleMemberNameBoundPropertyCreator.class)   // (1)
@LinkkiComponent(UIImage.ImageComponentDefinitionCreator.class)                         // (1)
@LinkkiAspect(UIImage.ImageAspectDefinitionCreator.class)                               // (2)
@LinkkiPositioned                                                                       // (1)
public @interface UIImage {                                                             // (1)

    @LinkkiPositioned.Position                                                          // (1)
    int position();                                                                     // (1)

    String url() default StringUtils.EMPTY;                                             // (1)

    String alternativeText() default StringUtils.EMPTY;                                 // (1)

    UrlType contentType() default UrlType.AUTO;                                         // (2)

    String width() default "auto";                                                      // (3)
    String height() default "auto";                                                     // (3)

    class ImageComponentDefinitionCreator implements ComponentDefinitionCreator<UIImage> {  // (1)

        @Override
        public LinkkiComponentDefinition create(UIImage annotation, AnnotatedElement annotatedElement) {
            return pmo -> {
                var image = new Image(annotation.url(), annotation.alternativeText());
                image.setWidth(annotation.width());
                image.setHeight(annotation.height());

                return image;
            };
        }

    }


    /**
     * Creates the instances of {@link LinkkiAspectDefinition}.
     */
    class ImageAspectDefinitionCreator implements AspectDefinitionCreator<UIImage> {        // (2)

        @Override
        public LinkkiAspectDefinition create(UIImage annotation) {
            return new ContentAspectDefinition(annotation.contentType(), annotation.url());
        }
    }

    /**
     * The {@link LinkkiAspectDefinition} controls
     */
    class ContentAspectDefinition extends ModelToUiAspectDefinition<String> {               // (2)

        private final UrlType urlType;
        private final String url;

        public ContentAspectDefinition(UrlType urlType, String url) {
            this.urlType = urlType;
            this.url = url;
        }

        @Override
        public Aspect<String> createAspect() {
            switch (urlType) {
                case DYNAMIC:
                    return Aspect.of(VALUE_ASPECT_NAME);
                case AUTO:
                    return StringUtils.isEmpty(url)
                            ? Aspect.of(VALUE_ASPECT_NAME)
                            : Aspect.of(VALUE_ASPECT_NAME, url);
                case STATIC:
                    return Aspect.of(VALUE_ASPECT_NAME, url);
                default:
                    throw new IllegalStateException("Unknown content type: " + urlType);
            }
        }

        @Override
        public Consumer<String> createComponentValueSetter(ComponentWrapper componentWrapper) {
            return currentUrl -> {
                var component = componentWrapper.getComponent();

                if (component instanceof Image) {
                    ((Image)component).setSrc(currentUrl);
                }
            };
        }
    }

    enum UrlType {                                                                              // (2)
        STATIC,
        DYNAMIC,
        AUTO
    }

}
