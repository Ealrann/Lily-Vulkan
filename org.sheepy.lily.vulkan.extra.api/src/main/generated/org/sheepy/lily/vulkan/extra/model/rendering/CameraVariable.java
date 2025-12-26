package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraVariableBuilder;

public interface CameraVariable extends IModelVariable {
  static Builder builder() {
    return new CameraVariableBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Camera camera();
  ECameraField field();
  void camera(final Camera camera);
  void field(final ECameraField field);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int CAMERA = 598534876;
    int FIELD = -531880349;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<Camera, Camera, Listener<Camera>, Features<?>> CAMERA = new RelationBuilder<Camera, Camera, Listener<Camera>, Features<?>>().name("camera").mandatory(true).id(CameraVariable.FeatureIDs.CAMERA).concept(() -> RenderingModelDefinition.Groups.CAMERA).build();
    Attribute<ECameraField, ECameraField, Listener<ECameraField>, Features<?>> FIELD = new AttributeBuilder<ECameraField, ECameraField, Listener<ECameraField>, Features<?>>().name("field").mandatory(true).id(CameraVariable.FeatureIDs.FIELD).datatype(() -> RenderingModelDefinition.Enums.E_CAMERA_FIELD).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, CAMERA, FIELD);
  }

  interface Builder extends IFeaturedObject.Builder<CameraVariable> {
    Builder name(String name);
    Builder camera(Supplier<Camera> camera);
    Builder field(ECameraField field);
  }
}
