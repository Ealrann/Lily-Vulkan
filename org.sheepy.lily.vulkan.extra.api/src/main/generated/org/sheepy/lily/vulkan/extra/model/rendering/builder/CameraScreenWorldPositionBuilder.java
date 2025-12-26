package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraScreenWorldPositionImpl;

public final class CameraScreenWorldPositionBuilder implements Builder {
  private String name;
  private Supplier<Camera> camera;

  public CameraScreenWorldPositionBuilder() {
  }

  @Override
  public CameraScreenWorldPositionBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CameraScreenWorldPositionBuilder camera(Supplier<Camera> camera) {
    this.camera = camera;
    return this;
  }

  @Override
  public CameraScreenWorldPosition build() {
    final var built = new CameraScreenWorldPositionImpl(name, camera.get());
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
    private static final FeatureInserter<CameraScreenWorldPositionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CameraScreenWorldPositionBuilder>(1, Inserters::attributeIndex).add(CameraScreenWorldPosition.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<CameraScreenWorldPositionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CameraScreenWorldPositionBuilder>(1, Inserters::relationIndex).add(CameraScreenWorldPosition.FeatureIDs.CAMERA, (builder, value) -> builder.camera((Supplier<Camera>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CameraScreenWorldPosition.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CameraScreenWorldPosition.FeatureIDs.CAMERA -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
