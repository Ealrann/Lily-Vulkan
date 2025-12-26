package org.sheepy.lily.vulkan.extra.model.mesh;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;

public interface Mesh extends Presentation {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int PRESENTED_ENTITIES = Presentation.FeatureIDs.PRESENTED_ENTITIES;
  }

  interface Features<T extends Features<T>> extends Presentation.Features<T> {
    Relation<PresentableEntity, List<PresentableEntity>, Listener<List<PresentableEntity>>, Presentation.Features<?>> PRESENTED_ENTITIES = Presentation.Features.PRESENTED_ENTITIES;
    List<Feature<?, ?, ?, ?>> ALL = List.of(PRESENTED_ENTITIES);
  }
}
