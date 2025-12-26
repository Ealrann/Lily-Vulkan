package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.api.notification.listener.LongListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.TransferBufferBuilder;

public interface TransferBuffer extends IVulkanResource {
  static Builder builder() {
    return new TransferBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  long size();
  boolean usedToPush();
  boolean usedToFetch();
  void size(final long size);
  void usedToPush(final boolean usedToPush);
  void usedToFetch(final boolean usedToFetch);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SIZE = 1735763461;
    int USED_TO_PUSH = 488244566;
    int USED_TO_FETCH = -2053998594;
  }

  interface Features<T extends Features<T>> extends IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Long, Long, LongListener, Features<?>> SIZE = new AttributeBuilder<Long, Long, LongListener, Features<?>>().name("size").id(TransferBuffer.FeatureIDs.SIZE).datatype(() -> LMCoreModelDefinition.Units.LONG).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> USED_TO_PUSH = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("usedToPush").mandatory(true).defaultValue("true").id(TransferBuffer.FeatureIDs.USED_TO_PUSH).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> USED_TO_FETCH = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("usedToFetch").mandatory(true).defaultValue("false").id(TransferBuffer.FeatureIDs.USED_TO_FETCH).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SIZE, USED_TO_PUSH, USED_TO_FETCH);
  }

  interface Builder extends IFeaturedObject.Builder<TransferBuffer> {
    Builder name(String name);
    Builder size(long size);
    Builder usedToPush(boolean usedToPush);
    Builder usedToFetch(boolean usedToFetch);
  }
}
