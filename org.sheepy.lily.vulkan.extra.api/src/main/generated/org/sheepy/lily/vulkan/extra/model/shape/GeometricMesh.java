package org.sheepy.lily.vulkan.extra.model.shape;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.shape.builder.GeometricMeshBuilder;

public interface GeometricMesh extends Mesh {
  static Builder builder() {
    return new GeometricMeshBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int PRESENTED_ENTITIES = Presentation.FeatureIDs.PRESENTED_ENTITIES;
  }

  interface Features<T extends Features<T>> extends Mesh.Features<T> {
    Relation<PresentableEntity, List<PresentableEntity>, Listener<List<PresentableEntity>>, Presentation.Features<?>> PRESENTED_ENTITIES = Presentation.Features.PRESENTED_ENTITIES;
    List<Feature<?, ?, ?, ?>> ALL = List.of(PRESENTED_ENTITIES);
  }

  interface Builder extends IFeaturedObject.Builder<GeometricMesh> {
    Builder addPresentedEntitie(Supplier<PresentableEntity> presentedEntitie);
    Builder addPresentedEntities(List<PresentableEntity> presentedEntities);
  }
}
