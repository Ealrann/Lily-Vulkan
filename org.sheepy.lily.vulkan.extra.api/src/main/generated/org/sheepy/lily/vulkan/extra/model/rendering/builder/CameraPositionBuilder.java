package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraPositionImpl;

public final class CameraPositionBuilder implements Builder {
  private String name;
  private Supplier<Camera> camera;

  public CameraPositionBuilder() {
  }

  @Override
  public CameraPositionBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CameraPositionBuilder camera(Supplier<Camera> camera) {
    this.camera = camera;
    return this;
  }

  @Override
  public CameraPosition build() {
    final var built = new CameraPositionImpl(name, camera.get());
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
    private static final FeatureInserter<CameraPositionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CameraPositionBuilder>(1, Inserters::attributeIndex).add(CameraPosition.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<CameraPositionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CameraPositionBuilder>(1, Inserters::relationIndex).add(CameraPosition.FeatureIDs.CAMERA, (builder, value) -> builder.camera((Supplier<Camera>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CameraPosition.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CameraPosition.FeatureIDs.CAMERA -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
