package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeConfigurationBuilder;

public interface ComputeConfiguration extends ProcessConfiguration {
  static Builder builder() {
    return new ComputeConfigurationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends ProcessConfiguration.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }

  interface Builder extends IFeaturedObject.Builder<ComputeConfiguration> {
  }
}
