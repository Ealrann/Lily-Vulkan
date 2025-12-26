package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.ECameraField;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraVariableImpl;

public final class CameraVariableBuilder implements Builder {
  private String name;
  private Supplier<Camera> camera;
  private ECameraField field = ECameraField.ZNear;

  public CameraVariableBuilder() {
  }

  @Override
  public CameraVariableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CameraVariableBuilder camera(Supplier<Camera> camera) {
    this.camera = camera;
    return this;
  }

  @Override
  public CameraVariableBuilder field(ECameraField field) {
    this.field = field;
    return this;
  }

  @Override
  public CameraVariable build() {
    final var built = new CameraVariableImpl(name, camera.get(), field);
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
    private static final FeatureInserter<CameraVariableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CameraVariableBuilder>(2, Inserters::attributeIndex).add(CameraVariable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(CameraVariable.FeatureIDs.FIELD, (builder, value) -> builder.field((ECameraField) value)).build();
    private static final RelationLazyInserter<CameraVariableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CameraVariableBuilder>(1, Inserters::relationIndex).add(CameraVariable.FeatureIDs.CAMERA, (builder, value) -> builder.camera((Supplier<Camera>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CameraVariable.FeatureIDs.NAME -> 0;
        case CameraVariable.FeatureIDs.FIELD -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CameraVariable.FeatureIDs.CAMERA -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
