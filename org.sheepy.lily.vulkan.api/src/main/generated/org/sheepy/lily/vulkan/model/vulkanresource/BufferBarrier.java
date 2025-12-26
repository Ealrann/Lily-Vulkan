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
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferBarrierBuilder;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;

public interface BufferBarrier extends AbstractBufferBarrier {
  static Builder builder() {
    return new BufferBarrierBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  BufferReference buffers();
  void buffers(final BufferReference buffers);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SRC_ACCESS_MASK = Barrier.FeatureIDs.SRC_ACCESS_MASK;
    int DST_ACCESS_MASK = Barrier.FeatureIDs.DST_ACCESS_MASK;
    int BUFFERS = 1990725061;
  }

  interface Features<T extends Features<T>> extends AbstractBufferBarrier.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> SRC_ACCESS_MASK = Barrier.Features.SRC_ACCESS_MASK;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> DST_ACCESS_MASK = Barrier.Features.DST_ACCESS_MASK;
    Relation<BufferReference, BufferReference, Listener<BufferReference>, Features<?>> BUFFERS = new RelationBuilder<BufferReference, BufferReference, Listener<BufferReference>, Features<?>>().name("buffers").mandatory(true).contains(true).id(BufferBarrier.FeatureIDs.BUFFERS).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_REFERENCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SRC_ACCESS_MASK, DST_ACCESS_MASK, BUFFERS);
  }

  interface Builder extends IFeaturedObject.Builder<BufferBarrier> {
    Builder name(String name);
    Builder addSrcAccessMask(EAccess srcAccessMask);
    Builder addDstAccessMask(EAccess dstAccessMask);
    Builder buffers(Supplier<BufferReference> buffers);
    Builder addSrcAccessMask(List<EAccess> srcAccessMask);
    Builder addDstAccessMask(List<EAccess> dstAccessMask);
  }
}
