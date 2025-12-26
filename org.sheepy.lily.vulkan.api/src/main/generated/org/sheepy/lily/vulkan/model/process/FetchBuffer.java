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
import org.sheepy.lily.vulkan.model.process.builder.FetchBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface FetchBuffer extends IPipelineTask {
  static Builder builder() {
    return new FetchBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  BufferReference bufferReference();
  void bufferReference(final BufferReference bufferReference);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int BUFFER_REFERENCE = 442523754;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Relation<BufferReference, BufferReference, Listener<BufferReference>, Features<?>> BUFFER_REFERENCE = new RelationBuilder<BufferReference, BufferReference, Listener<BufferReference>, Features<?>>().name("bufferReference").mandatory(true).contains(true).id(FetchBuffer.FeatureIDs.BUFFER_REFERENCE).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_REFERENCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, BUFFER_REFERENCE);
  }

  interface Builder extends IFeaturedObject.Builder<FetchBuffer> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder bufferReference(Supplier<BufferReference> bufferReference);
  }
}
