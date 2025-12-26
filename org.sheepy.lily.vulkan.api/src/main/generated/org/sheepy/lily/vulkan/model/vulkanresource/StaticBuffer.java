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
import org.sheepy.lily.vulkan.model.vulkanresource.builder.StaticBufferBuilder;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public interface StaticBuffer extends IBuffer {
  static Builder builder() {
    return new StaticBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  long size();
  boolean initWithZero();
  void size(final long size);
  void initWithZero(final boolean initWithZero);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int USAGES = IBuffer.FeatureIDs.USAGES;
    int SIZE = 1232595170;
    int INIT_WITH_ZERO = -1444044385;
  }

  interface Features<T extends Features<T>> extends IBuffer.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, IBuffer.Features<?>> USAGES = IBuffer.Features.USAGES;
    Attribute<Long, Long, LongListener, Features<?>> SIZE = new AttributeBuilder<Long, Long, LongListener, Features<?>>().name("size").id(StaticBuffer.FeatureIDs.SIZE).datatype(() -> LMCoreModelDefinition.Units.LONG).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> INIT_WITH_ZERO = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("initWithZero").defaultValue("false").id(StaticBuffer.FeatureIDs.INIT_WITH_ZERO).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, USAGES, SIZE, INIT_WITH_ZERO);
  }

  interface Builder extends IFeaturedObject.Builder<StaticBuffer> {
    Builder name(String name);
    Builder addUsage(EBufferUsage usage);
    Builder size(long size);
    Builder initWithZero(boolean initWithZero);
    Builder addUsages(List<EBufferUsage> usages);
  }
}
