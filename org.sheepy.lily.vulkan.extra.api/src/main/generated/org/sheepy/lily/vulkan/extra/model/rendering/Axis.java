package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.AxisBuilder;

public interface Axis extends LMObject {
  static Builder builder() {
    return new AxisBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector3dc frontDirection();
  Vector3dc upDirection();
  Vector3dc rightDirection();
  void frontDirection(final Vector3dc frontDirection);
  void upDirection(final Vector3dc upDirection);
  void rightDirection(final Vector3dc rightDirection);

  interface FeatureIDs {
    int FRONT_DIRECTION = -1882421587;
    int UP_DIRECTION = -1208873171;
    int RIGHT_DIRECTION = 145581082;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>> FRONT_DIRECTION = new AttributeBuilder<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>>().name("frontDirection").defaultValue("0;0;0").id(Axis.FeatureIDs.FRONT_DIRECTION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3D).build();
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>> UP_DIRECTION = new AttributeBuilder<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>>().name("upDirection").defaultValue("0;0;0").id(Axis.FeatureIDs.UP_DIRECTION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3D).build();
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>> RIGHT_DIRECTION = new AttributeBuilder<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>>().name("rightDirection").defaultValue("0;0;0").id(Axis.FeatureIDs.RIGHT_DIRECTION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3D).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FRONT_DIRECTION, UP_DIRECTION, RIGHT_DIRECTION);
  }

  interface Builder extends IFeaturedObject.Builder<Axis> {
    Builder frontDirection(Vector3dc frontDirection);
    Builder upDirection(Vector3dc upDirection);
    Builder rightDirection(Vector3dc rightDirection);
  }
}
