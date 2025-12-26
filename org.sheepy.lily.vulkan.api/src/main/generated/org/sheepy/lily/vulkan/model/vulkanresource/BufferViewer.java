package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.api.notification.listener.LongListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferViewerBuilder;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public interface BufferViewer extends IBuffer {
  static Builder builder() {
    return new BufferViewerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  float growFactor();
  float growThreshold();
  long size();
  IBufferDataSource dataSource();
  String dataSourceIdentifier();
  void growFactor(final float growFactor);
  void growThreshold(final float growThreshold);
  void size(final long size);
  void dataSource(final IBufferDataSource dataSource);
  void dataSourceIdentifier(final String dataSourceIdentifier);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int USAGES = IBuffer.FeatureIDs.USAGES;
    int GROW_FACTOR = -903137601;
    int GROW_THRESHOLD = -1915195141;
    int SIZE = 1885528382;
    int DATA_SOURCE = -1487094814;
    int DATA_SOURCE_IDENTIFIER = -1154526677;
  }

  interface Features<T extends Features<T>> extends IBuffer.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, IBuffer.Features<?>> USAGES = IBuffer.Features.USAGES;
    Attribute<Float, Float, FloatListener, Features<?>> GROW_FACTOR = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("growFactor").mandatory(true).defaultValue("1f").id(BufferViewer.FeatureIDs.GROW_FACTOR).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> GROW_THRESHOLD = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("growThreshold").mandatory(true).defaultValue("1f").id(BufferViewer.FeatureIDs.GROW_THRESHOLD).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Long, Long, LongListener, Features<?>> SIZE = new AttributeBuilder<Long, Long, LongListener, Features<?>>().name("size").defaultValue("0").id(BufferViewer.FeatureIDs.SIZE).datatype(() -> LMCoreModelDefinition.Units.LONG).build();
    Relation<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, Features<?>> DATA_SOURCE = new RelationBuilder<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, Features<?>>().name("dataSource").id(BufferViewer.FeatureIDs.DATA_SOURCE).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER_DATA_SOURCE).build();
    Attribute<String, String, Listener<String>, Features<?>> DATA_SOURCE_IDENTIFIER = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("dataSourceIdentifier").id(BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, USAGES, GROW_FACTOR, GROW_THRESHOLD, SIZE, DATA_SOURCE, DATA_SOURCE_IDENTIFIER);
  }

  interface Builder extends IFeaturedObject.Builder<BufferViewer> {
    Builder name(String name);
    Builder addUsage(EBufferUsage usage);
    Builder growFactor(float growFactor);
    Builder growThreshold(float growThreshold);
    Builder size(long size);
    Builder dataSource(Supplier<IBufferDataSource> dataSource);
    Builder dataSourceIdentifier(String dataSourceIdentifier);
    Builder addUsages(List<EBufferUsage> usages);
  }
}
