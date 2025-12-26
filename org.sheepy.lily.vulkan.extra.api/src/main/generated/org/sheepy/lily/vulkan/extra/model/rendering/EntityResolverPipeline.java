package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.EntityResolverPipelineBuilder;

public interface EntityResolverPipeline extends LMObject {
  static Builder builder() {
    return new EntityResolverPipelineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IEntityResolver> entityResolvers();
  boolean takeFirst();
  void takeFirst(final boolean takeFirst);

  interface FeatureIDs {
    int ENTITY_RESOLVERS = 2069582525;
    int TAKE_FIRST = -1828491556;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IEntityResolver, List<IEntityResolver>, Listener<List<IEntityResolver>>, Features<?>> ENTITY_RESOLVERS = new RelationBuilder<IEntityResolver, List<IEntityResolver>, Listener<List<IEntityResolver>>, Features<?>>().name("entityResolvers").many(true).id(EntityResolverPipeline.FeatureIDs.ENTITY_RESOLVERS).concept(() -> RenderingModelDefinition.Groups.I_ENTITY_RESOLVER).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> TAKE_FIRST = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("takeFirst").defaultValue("false").id(EntityResolverPipeline.FeatureIDs.TAKE_FIRST).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ENTITY_RESOLVERS, TAKE_FIRST);
  }

  interface Builder extends IFeaturedObject.Builder<EntityResolverPipeline> {
    Builder addEntityResolver(Supplier<IEntityResolver> entityResolver);
    Builder takeFirst(boolean takeFirst);
    Builder addEntityResolvers(List<IEntityResolver> entityResolvers);
  }
}
