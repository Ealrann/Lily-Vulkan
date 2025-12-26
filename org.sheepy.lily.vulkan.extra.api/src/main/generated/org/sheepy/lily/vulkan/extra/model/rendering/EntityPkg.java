package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface EntityPkg<T extends Entity> extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<T> entities();

  interface FeatureIDs {
    int ENTITIES = 726413076;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Entity, List<Entity>, Listener<List<Entity>>, Features<?>> ENTITIES = new RelationBuilder<Entity, List<Entity>, Listener<List<Entity>>, Features<?>>().name("entities").many(true).contains(true).id(EntityPkg.FeatureIDs.ENTITIES).concept(() -> RenderingModelDefinition.Groups.ENTITY).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ENTITIES);
  }
}
