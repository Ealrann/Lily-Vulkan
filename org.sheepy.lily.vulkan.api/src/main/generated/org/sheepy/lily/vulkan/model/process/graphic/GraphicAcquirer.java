package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicAcquirerBuilder;

public interface GraphicAcquirer extends IExecutionAcquirer {
  static Builder builder() {
    return new GraphicAcquirerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends IExecutionAcquirer.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }

  interface Builder extends IFeaturedObject.Builder<GraphicAcquirer> {
  }
}
