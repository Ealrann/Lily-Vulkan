package org.sheepy.lily.vulkan.extra.model.shape.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh.Builder;
import org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl;

public final class GeometricMeshBuilder implements Builder {
  private final List<Supplier<PresentableEntity>> presentedEntities = new ArrayList<>();

  public GeometricMeshBuilder() {
  }

  @Override
  public GeometricMeshBuilder addPresentedEntitie(Supplier<PresentableEntity> presentedEntitie) {
    this.presentedEntities.add(presentedEntitie);
    return this;
  }

  @Override
  public GeometricMeshBuilder addPresentedEntities(
      final List<PresentableEntity> presentedEntities) {
    presentedEntities.forEach(value -> this.presentedEntities.add(() -> value));
    return this;
  }

  @Override
  public GeometricMesh build() {
    final var builtPresentedEntities = BuildUtils.collectSuppliers(presentedEntities);
    final var built = new GeometricMeshImpl();
    built.presentedEntities().addAll(builtPresentedEntities);
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
    private static final FeatureInserter<GeometricMeshBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GeometricMeshBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<GeometricMeshBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GeometricMeshBuilder>(1, Inserters::relationIndex).add(GeometricMesh.FeatureIDs.PRESENTED_ENTITIES, (builder, value) -> builder.addPresentedEntitie((Supplier<PresentableEntity>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GeometricMesh.FeatureIDs.PRESENTED_ENTITIES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
