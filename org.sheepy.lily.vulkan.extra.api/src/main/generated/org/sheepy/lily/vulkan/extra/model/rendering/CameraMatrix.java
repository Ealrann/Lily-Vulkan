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
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraMatrixBuilder;

public interface CameraMatrix extends IModelVariable {
  static Builder builder() {
    return new CameraMatrixBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Camera camera();
  void camera(final Camera camera);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int CAMERA = 1269794871;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<Camera, Camera, Listener<Camera>, Features<?>> CAMERA = new RelationBuilder<Camera, Camera, Listener<Camera>, Features<?>>().name("camera").mandatory(true).id(CameraMatrix.FeatureIDs.CAMERA).concept(() -> RenderingModelDefinition.Groups.CAMERA).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, CAMERA);
  }

  interface Builder extends IFeaturedObject.Builder<CameraMatrix> {
    Builder name(String name);
    Builder camera(Supplier<Camera> camera);
  }
}
