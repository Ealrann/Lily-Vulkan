package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeCommandBufferBuilder;

public interface ComputeCommandBuffer extends ICommandBuffer {
  static Builder builder() {
    return new ComputeCommandBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int INDEX = ICommandBuffer.FeatureIDs.INDEX;
  }

  interface Features<T extends Features<T>> extends ICommandBuffer.Features<T> {
    Attribute<Integer, Integer, IntListener, ICommandBuffer.Features<?>> INDEX = ICommandBuffer.Features.INDEX;
    List<Feature<?, ?, ?, ?>> ALL = List.of(INDEX);
  }

  interface Builder extends IFeaturedObject.Builder<ComputeCommandBuffer> {
    Builder index(int index);
  }
}
