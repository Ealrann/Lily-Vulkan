package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BindIndexBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface BindIndexBuffer extends IPipelineTask {
  static Builder builder() {
    return new BindIndexBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EIndexType indexType();
  IBuffer buffer();
  void indexType(final EIndexType indexType);
  void buffer(final IBuffer buffer);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int INDEX_TYPE = -1153457216;
    int BUFFER = -1680454612;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<EIndexType, EIndexType, Listener<EIndexType>, Features<?>> INDEX_TYPE = new AttributeBuilder<EIndexType, EIndexType, Listener<EIndexType>, Features<?>>().name("indexType").defaultValue("UINT32").id(BindIndexBuffer.FeatureIDs.INDEX_TYPE).datatype(() -> EnumerationModelDefinition.Enums.E_INDEX_TYPE).build();
    Relation<IBuffer, IBuffer, Listener<IBuffer>, Features<?>> BUFFER = new RelationBuilder<IBuffer, IBuffer, Listener<IBuffer>, Features<?>>().name("buffer").id(BindIndexBuffer.FeatureIDs.BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, INDEX_TYPE, BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<BindIndexBuffer> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder indexType(EIndexType indexType);
    Builder buffer(Supplier<IBuffer> buffer);
  }
}
