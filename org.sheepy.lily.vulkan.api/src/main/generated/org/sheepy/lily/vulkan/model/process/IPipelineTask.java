package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface IPipelineTask extends LNamedElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean enabled();
  void enabled(final boolean enabled);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = -2133740362;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("enabled").defaultValue("true").id(IPipelineTask.FeatureIDs.ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED);
  }
}
