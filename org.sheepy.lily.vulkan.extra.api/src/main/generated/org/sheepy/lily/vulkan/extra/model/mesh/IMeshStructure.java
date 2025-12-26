package org.sheepy.lily.vulkan.extra.model.mesh;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public interface IMeshStructure extends Structure {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends Structure.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
