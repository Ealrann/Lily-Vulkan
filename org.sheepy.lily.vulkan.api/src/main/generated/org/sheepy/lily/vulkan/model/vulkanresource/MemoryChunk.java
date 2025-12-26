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
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.MemoryChunkBuilder;

public interface MemoryChunk extends IVulkanResource {
  static Builder builder() {
    return new MemoryChunkBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IMemoryChunkPart> parts();
  TransferBuffer transferBuffer();
  void transferBuffer(final TransferBuffer transferBuffer);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int PARTS = 62977287;
    int TRANSFER_BUFFER = -1637286460;
  }

  interface Features<T extends Features<T>> extends IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<IMemoryChunkPart, List<IMemoryChunkPart>, Listener<List<IMemoryChunkPart>>, Features<?>> PARTS = new RelationBuilder<IMemoryChunkPart, List<IMemoryChunkPart>, Listener<List<IMemoryChunkPart>>, Features<?>>().name("parts").many(true).contains(true).id(MemoryChunk.FeatureIDs.PARTS).concept(() -> VulkanResourceModelDefinition.Groups.I_MEMORY_CHUNK_PART).build();
    Relation<TransferBuffer, TransferBuffer, Listener<TransferBuffer>, Features<?>> TRANSFER_BUFFER = new RelationBuilder<TransferBuffer, TransferBuffer, Listener<TransferBuffer>, Features<?>>().name("transferBuffer").id(MemoryChunk.FeatureIDs.TRANSFER_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.TRANSFER_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, PARTS, TRANSFER_BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<MemoryChunk> {
    Builder name(String name);
    Builder addPart(Supplier<IMemoryChunkPart> part);
    Builder transferBuffer(Supplier<TransferBuffer> transferBuffer);
    Builder addParts(List<IMemoryChunkPart> parts);
  }
}
