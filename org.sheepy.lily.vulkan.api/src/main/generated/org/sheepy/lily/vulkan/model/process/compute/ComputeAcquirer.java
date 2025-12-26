package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeAcquirerBuilder;

public interface ComputeAcquirer extends IExecutionAcquirer {
  static Builder builder() {
    return new ComputeAcquirerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends IExecutionAcquirer.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }

  interface Builder extends IFeaturedObject.Builder<ComputeAcquirer> {
  }
}
