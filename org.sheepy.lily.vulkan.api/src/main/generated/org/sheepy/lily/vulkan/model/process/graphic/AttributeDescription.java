package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttributeDescriptionBuilder;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface AttributeDescription extends LNamedElement {
  static Builder builder() {
    return new AttributeDescriptionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EFormat format();
  int offset();
  void format(final EFormat format);
  void offset(final int offset);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FORMAT = 1379238218;
    int OFFSET = 1628237286;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EFormat, EFormat, Listener<EFormat>, Features<?>> FORMAT = new AttributeBuilder<EFormat, EFormat, Listener<EFormat>, Features<?>>().name("format").id(AttributeDescription.FeatureIDs.FORMAT).datatype(() -> EnumerationModelDefinition.Enums.E_FORMAT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSET = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offset").id(AttributeDescription.FeatureIDs.OFFSET).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FORMAT, OFFSET);
  }

  interface Builder extends IFeaturedObject.Builder<AttributeDescription> {
    Builder name(String name);
    Builder format(EFormat format);
    Builder offset(int offset);
  }
}
