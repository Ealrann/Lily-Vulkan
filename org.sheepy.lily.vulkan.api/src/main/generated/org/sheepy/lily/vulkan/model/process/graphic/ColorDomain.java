package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.ColorDomainBuilder;
import org.sheepy.vulkan.model.enumeration.EColorSpace;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface ColorDomain extends LMObject {
  static Builder builder() {
    return new ColorDomainBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EFormat format();
  EColorSpace colorSpace();
  void format(final EFormat format);
  void colorSpace(final EColorSpace colorSpace);

  interface FeatureIDs {
    int FORMAT = 1507291217;
    int COLOR_SPACE = -31214915;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EFormat, EFormat, Listener<EFormat>, Features<?>> FORMAT = new AttributeBuilder<EFormat, EFormat, Listener<EFormat>, Features<?>>().name("format").defaultValue("B8G8R8A8_UNORM").id(ColorDomain.FeatureIDs.FORMAT).datatype(() -> EnumerationModelDefinition.Enums.E_FORMAT).build();
    Attribute<EColorSpace, EColorSpace, Listener<EColorSpace>, Features<?>> COLOR_SPACE = new AttributeBuilder<EColorSpace, EColorSpace, Listener<EColorSpace>, Features<?>>().name("colorSpace").defaultValue("SRGB_NONLINEAR_KHR").id(ColorDomain.FeatureIDs.COLOR_SPACE).datatype(() -> EnumerationModelDefinition.Enums.E_COLOR_SPACE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FORMAT, COLOR_SPACE);
  }

  interface Builder extends IFeaturedObject.Builder<ColorDomain> {
    Builder format(EFormat format);
    Builder colorSpace(EColorSpace colorSpace);
  }
}
