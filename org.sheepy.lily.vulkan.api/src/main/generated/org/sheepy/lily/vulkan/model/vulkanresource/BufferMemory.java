package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferMemoryBuilder;

public interface BufferMemory extends IMemoryChunkPart, LNamedElement {
  static Builder builder() {
    return new BufferMemoryBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IBuffer> buffers();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int BUFFERS = 1946368453;
  }

  interface Features<T extends Features<T>> extends IMemoryChunkPart.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<IBuffer, List<IBuffer>, Listener<List<IBuffer>>, Features<?>> BUFFERS = new RelationBuilder<IBuffer, List<IBuffer>, Listener<List<IBuffer>>, Features<?>>().name("buffers").many(true).contains(true).id(BufferMemory.FeatureIDs.BUFFERS).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, BUFFERS);
  }

  interface Builder extends IFeaturedObject.Builder<BufferMemory> {
    Builder name(String name);
    Builder addBuffer(Supplier<IBuffer> buffer);
    Builder addBuffers(List<IBuffer> buffers);
  }
}
