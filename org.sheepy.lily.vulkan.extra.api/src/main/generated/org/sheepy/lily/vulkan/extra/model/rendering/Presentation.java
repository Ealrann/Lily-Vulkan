package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface Presentation extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<PresentableEntity> presentedEntities();

  interface FeatureIDs {
    int PRESENTED_ENTITIES = 1899105021;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<PresentableEntity, List<PresentableEntity>, Listener<List<PresentableEntity>>, Features<?>> PRESENTED_ENTITIES = new RelationBuilder<PresentableEntity, List<PresentableEntity>, Listener<List<PresentableEntity>>, Features<?>>().name("presentedEntities").many(true).id(Presentation.FeatureIDs.PRESENTED_ENTITIES).concept(() -> RenderingModelDefinition.Groups.PRESENTABLE_ENTITY).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PRESENTED_ENTITIES);
  }
}
