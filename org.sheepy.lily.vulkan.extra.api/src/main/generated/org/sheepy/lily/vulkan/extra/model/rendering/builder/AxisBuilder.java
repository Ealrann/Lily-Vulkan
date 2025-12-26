package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector3dc;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl;

public final class AxisBuilder implements Builder {
  private Vector3dc frontDirection = ((Function<String, Vector3dc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0); }).apply("0;0;0");
  private Vector3dc upDirection = ((Function<String, Vector3dc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0); }).apply("0;0;0");
  private Vector3dc rightDirection = ((Function<String, Vector3dc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0); }).apply("0;0;0");

  public AxisBuilder() {
  }

  @Override
  public AxisBuilder frontDirection(Vector3dc frontDirection) {
    this.frontDirection = frontDirection;
    return this;
  }

  @Override
  public AxisBuilder upDirection(Vector3dc upDirection) {
    this.upDirection = upDirection;
    return this;
  }

  @Override
  public AxisBuilder rightDirection(Vector3dc rightDirection) {
    this.rightDirection = rightDirection;
    return this;
  }

  @Override
  public Axis build() {
    final var built = new AxisImpl();
    built.frontDirection(frontDirection);
    built.upDirection(upDirection);
    built.rightDirection(rightDirection);
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
    private static final FeatureInserter<AxisBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<AxisBuilder>(3, Inserters::attributeIndex).add(Axis.FeatureIDs.FRONT_DIRECTION, (builder, value) -> builder.frontDirection((Vector3dc) value)).add(Axis.FeatureIDs.UP_DIRECTION, (builder, value) -> builder.upDirection((Vector3dc) value)).add(Axis.FeatureIDs.RIGHT_DIRECTION, (builder, value) -> builder.rightDirection((Vector3dc) value)).build();
    private static final RelationLazyInserter<AxisBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<AxisBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Axis.FeatureIDs.FRONT_DIRECTION -> 0;
        case Axis.FeatureIDs.UP_DIRECTION -> 1;
        case Axis.FeatureIDs.RIGHT_DIRECTION -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
