package org.sheepy.lily.vulkan.model.process;

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
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.CopyBufferTaskBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface CopyBufferTask extends IPipelineTask {
  static Builder builder() {
    return new CopyBufferTaskBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  BufferReference srcBuffer();
  BufferReference dstBuffer();
  void srcBuffer(final BufferReference srcBuffer);
  void dstBuffer(final BufferReference dstBuffer);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int SRC_BUFFER = 2083580421;
    int DST_BUFFER = -1218869978;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Relation<BufferReference, BufferReference, Listener<BufferReference>, Features<?>> SRC_BUFFER = new RelationBuilder<BufferReference, BufferReference, Listener<BufferReference>, Features<?>>().name("srcBuffer").mandatory(true).contains(true).id(CopyBufferTask.FeatureIDs.SRC_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_REFERENCE).build();
    Relation<BufferReference, BufferReference, Listener<BufferReference>, Features<?>> DST_BUFFER = new RelationBuilder<BufferReference, BufferReference, Listener<BufferReference>, Features<?>>().name("dstBuffer").mandatory(true).contains(true).id(CopyBufferTask.FeatureIDs.DST_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_REFERENCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, SRC_BUFFER, DST_BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<CopyBufferTask> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder srcBuffer(Supplier<BufferReference> srcBuffer);
    Builder dstBuffer(Supplier<BufferReference> dstBuffer);
  }
}
