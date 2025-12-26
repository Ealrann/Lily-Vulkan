package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EPrimitiveTopology;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.InputAssemblyBuilder;

public interface InputAssembly extends LMObject {
  static Builder builder() {
    return new InputAssemblyBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean primitiveRestartEnabled();
  EPrimitiveTopology primitiveTopology();
  void primitiveRestartEnabled(final boolean primitiveRestartEnabled);
  void primitiveTopology(final EPrimitiveTopology primitiveTopology);

  interface FeatureIDs {
    int PRIMITIVE_RESTART_ENABLED = 92147281;
    int PRIMITIVE_TOPOLOGY = -1972195890;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> PRIMITIVE_RESTART_ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("primitiveRestartEnabled").defaultValue("false").id(InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<EPrimitiveTopology, EPrimitiveTopology, Listener<EPrimitiveTopology>, Features<?>> PRIMITIVE_TOPOLOGY = new AttributeBuilder<EPrimitiveTopology, EPrimitiveTopology, Listener<EPrimitiveTopology>, Features<?>>().name("primitiveTopology").defaultValue("TRIANGLE_LIST").id(InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY).datatype(() -> EnumerationModelDefinition.Enums.E_PRIMITIVE_TOPOLOGY).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PRIMITIVE_RESTART_ENABLED, PRIMITIVE_TOPOLOGY);
  }

  interface Builder extends IFeaturedObject.Builder<InputAssembly> {
    Builder primitiveRestartEnabled(boolean primitiveRestartEnabled);
    Builder primitiveTopology(EPrimitiveTopology primitiveTopology);
  }
}
