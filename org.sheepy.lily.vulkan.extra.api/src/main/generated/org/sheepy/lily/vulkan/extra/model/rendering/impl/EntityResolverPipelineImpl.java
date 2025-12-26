package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class EntityResolverPipelineImpl extends FeaturedObject<EntityResolverPipeline.Features<?>> implements EntityResolverPipeline {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<EntityResolverPipeline.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IEntityResolver> entityResolvers = newObservableList(EntityResolverPipeline.FeatureIDs.ENTITY_RESOLVERS, true, false);
  private boolean takeFirst;

  public EntityResolverPipelineImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<EntityResolverPipeline.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IEntityResolver> entityResolvers() {
    return entityResolvers;
  }

  @Override
  public boolean takeFirst() {
    return takeFirst;
  }

  @Override
  public void takeFirst(final boolean takeFirst) {
    final var oldValue = this.takeFirst;
    this.takeFirst = takeFirst;
    notifier.notifyBoolean(EntityResolverPipeline.FeatureIDs.TAKE_FIRST, false, false, oldValue, takeFirst);
  }

  @Override
  public Group<EntityResolverPipeline> lmGroup() {
    return RenderingModelDefinition.Groups.ENTITY_RESOLVER_PIPELINE;
  }

  @Override
  protected FeatureSetter<EntityResolverPipeline> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<EntityResolverPipeline> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case EntityResolverPipeline.FeatureIDs.ENTITY_RESOLVERS -> 0;
      case EntityResolverPipeline.FeatureIDs.TAKE_FIRST -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<EntityResolverPipeline> GET_MAP = new FeatureGetter.Builder<EntityResolverPipeline>(FEATURE_COUNT, EntityResolverPipelineImpl::featureIndexStatic).add(EntityResolverPipeline.FeatureIDs.ENTITY_RESOLVERS, EntityResolverPipeline::entityResolvers).add(EntityResolverPipeline.FeatureIDs.TAKE_FIRST, EntityResolverPipeline::takeFirst).build();
    private static final FeatureSetter<EntityResolverPipeline> SET_MAP = new FeatureSetter.Builder<EntityResolverPipeline>(FEATURE_COUNT, EntityResolverPipelineImpl::featureIndexStatic).add(EntityResolverPipeline.FeatureIDs.TAKE_FIRST, (object, value) -> ((EntityResolverPipelineImpl) object).takeFirst((boolean) value)).build();
  }
}
