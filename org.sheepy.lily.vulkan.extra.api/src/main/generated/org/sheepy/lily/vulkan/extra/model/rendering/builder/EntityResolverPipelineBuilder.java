package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityResolverPipelineImpl;

public final class EntityResolverPipelineBuilder implements Builder {
  private final List<Supplier<IEntityResolver>> entityResolvers = new ArrayList<>();
  private boolean takeFirst = false;

  public EntityResolverPipelineBuilder() {
  }

  @Override
  public EntityResolverPipelineBuilder addEntityResolver(Supplier<IEntityResolver> entityResolver) {
    this.entityResolvers.add(entityResolver);
    return this;
  }

  @Override
  public EntityResolverPipelineBuilder addEntityResolvers(
      final List<IEntityResolver> entityResolvers) {
    entityResolvers.forEach(value -> this.entityResolvers.add(() -> value));
    return this;
  }

  @Override
  public EntityResolverPipelineBuilder takeFirst(boolean takeFirst) {
    this.takeFirst = takeFirst;
    return this;
  }

  @Override
  public EntityResolverPipeline build() {
    final var builtEntityResolvers = BuildUtils.collectSuppliers(entityResolvers);
    final var built = new EntityResolverPipelineImpl();
    built.entityResolvers().addAll(builtEntityResolvers);
    built.takeFirst(takeFirst);
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<EntityResolverPipelineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<EntityResolverPipelineBuilder>(1, Inserters::attributeIndex).add(EntityResolverPipeline.FeatureIDs.TAKE_FIRST, (builder, value) -> builder.takeFirst((boolean) value)).build();
    private static final RelationLazyInserter<EntityResolverPipelineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<EntityResolverPipelineBuilder>(1, Inserters::relationIndex).add(EntityResolverPipeline.FeatureIDs.ENTITY_RESOLVERS, (builder, value) -> builder.addEntityResolver((Supplier<IEntityResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case EntityResolverPipeline.FeatureIDs.TAKE_FIRST -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case EntityResolverPipeline.FeatureIDs.ENTITY_RESOLVERS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
