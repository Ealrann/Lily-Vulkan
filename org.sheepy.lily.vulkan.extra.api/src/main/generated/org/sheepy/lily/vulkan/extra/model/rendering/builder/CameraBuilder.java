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
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl;

public final class CameraBuilder implements Builder {
  private String name;
  private float fieldOfView = 45f;
  private float zNear;
  private float zFar;
  private Vector3dc location = ((Function<String, Vector3dc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0); }).apply("0;0;0");
  private Supplier<Axis> axis;
  private Vector3dc lookDirection = ((Function<String, Vector3dc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){double x=Double.parseDouble(split[0]);double y=Double.parseDouble(split[1]);double z=Double.parseDouble(split[2]);return new org.joml.Vector3d(x,y,z);}}return new org.joml.Vector3d(0,0,0); }).apply("1;0;0");

  public CameraBuilder() {
  }

  @Override
  public CameraBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CameraBuilder fieldOfView(float fieldOfView) {
    this.fieldOfView = fieldOfView;
    return this;
  }

  @Override
  public CameraBuilder zNear(float zNear) {
    this.zNear = zNear;
    return this;
  }

  @Override
  public CameraBuilder zFar(float zFar) {
    this.zFar = zFar;
    return this;
  }

  @Override
  public CameraBuilder location(Vector3dc location) {
    this.location = location;
    return this;
  }

  @Override
  public CameraBuilder axis(Supplier<Axis> axis) {
    this.axis = axis;
    return this;
  }

  @Override
  public CameraBuilder lookDirection(Vector3dc lookDirection) {
    this.lookDirection = lookDirection;
    return this;
  }

  @Override
  public Camera build() {
    final var built = new CameraImpl(name, fieldOfView, zNear, zFar, axis.get());
    built.location(location);
    built.lookDirection(lookDirection);
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
    private static final FeatureInserter<CameraBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CameraBuilder>(6, Inserters::attributeIndex).add(Camera.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Camera.FeatureIDs.FIELD_OF_VIEW, (builder, value) -> builder.fieldOfView((float) value)).add(Camera.FeatureIDs.Z_NEAR, (builder, value) -> builder.zNear((float) value)).add(Camera.FeatureIDs.Z_FAR, (builder, value) -> builder.zFar((float) value)).add(Camera.FeatureIDs.LOCATION, (builder, value) -> builder.location((Vector3dc) value)).add(Camera.FeatureIDs.LOOK_DIRECTION, (builder, value) -> builder.lookDirection((Vector3dc) value)).build();
    private static final RelationLazyInserter<CameraBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CameraBuilder>(1, Inserters::relationIndex).add(Camera.FeatureIDs.AXIS, (builder, value) -> builder.axis((Supplier<Axis>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Camera.FeatureIDs.NAME -> 0;
        case Camera.FeatureIDs.FIELD_OF_VIEW -> 1;
        case Camera.FeatureIDs.Z_NEAR -> 2;
        case Camera.FeatureIDs.Z_FAR -> 3;
        case Camera.FeatureIDs.LOCATION -> 4;
        case Camera.FeatureIDs.LOOK_DIRECTION -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Camera.FeatureIDs.AXIS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
