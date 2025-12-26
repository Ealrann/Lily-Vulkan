package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface IBuffer extends LNamedElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<EBufferUsage> usages();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int USAGES = 1611777134;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, Features<?>> USAGES = new AttributeBuilder<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, Features<?>>().name("usages").many(true).id(IBuffer.FeatureIDs.USAGES).datatype(() -> EnumerationModelDefinition.Enums.E_BUFFER_USAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, USAGES);
  }
}
