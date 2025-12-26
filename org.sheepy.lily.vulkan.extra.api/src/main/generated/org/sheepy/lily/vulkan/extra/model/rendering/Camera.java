package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraBuilder;

public interface Camera extends IRootResource {
  static Builder builder() {
    return new CameraBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  float fieldOfView();
  float zNear();
  float zFar();
  Vector3dc location();
  Axis axis();
  Vector3dc lookDirection();
  void fieldOfView(final float fieldOfView);
  void zNear(final float zNear);
  void zFar(final float zFar);
  void location(final Vector3dc location);
  void axis(final Axis axis);
  void lookDirection(final Vector3dc lookDirection);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FIELD_OF_VIEW = -1673674813;
    int Z_NEAR = 1290967695;
    int Z_FAR = -512553008;
    int LOCATION = -1677318712;
    int AXIS = -513249484;
    int LOOK_DIRECTION = -1105940115;
  }

  interface Features<T extends Features<T>> extends IRootResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Float, Float, FloatListener, Features<?>> FIELD_OF_VIEW = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("fieldOfView").mandatory(true).defaultValue("45f").id(Camera.FeatureIDs.FIELD_OF_VIEW).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> Z_NEAR = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("zNear").mandatory(true).id(Camera.FeatureIDs.Z_NEAR).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> Z_FAR = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("zFar").mandatory(true).id(Camera.FeatureIDs.Z_FAR).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>> LOCATION = new AttributeBuilder<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>>().name("location").defaultValue("0;0;0").id(Camera.FeatureIDs.LOCATION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3D).build();
    Relation<Axis, Axis, Listener<Axis>, Features<?>> AXIS = new RelationBuilder<Axis, Axis, Listener<Axis>, Features<?>>().name("axis").mandatory(true).contains(true).id(Camera.FeatureIDs.AXIS).concept(() -> RenderingModelDefinition.Groups.AXIS).build();
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>> LOOK_DIRECTION = new AttributeBuilder<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>>().name("lookDirection").defaultValue("1;0;0").id(Camera.FeatureIDs.LOOK_DIRECTION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3D).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FIELD_OF_VIEW, Z_NEAR, Z_FAR, LOCATION, AXIS, LOOK_DIRECTION);
  }

  interface Builder extends IFeaturedObject.Builder<Camera> {
    Builder name(String name);
    Builder fieldOfView(float fieldOfView);
    Builder zNear(float zNear);
    Builder zFar(float zFar);
    Builder location(Vector3dc location);
    Builder axis(Supplier<Axis> axis);
    Builder lookDirection(Vector3dc lookDirection);
  }
}
