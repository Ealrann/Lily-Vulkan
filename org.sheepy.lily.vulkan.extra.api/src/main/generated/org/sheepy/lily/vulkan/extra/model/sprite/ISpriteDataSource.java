package org.sheepy.lily.vulkan.extra.model.sprite;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;

public interface ISpriteDataSource extends IBufferDataSource {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends IBufferDataSource.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
