package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface PhysicalEntity extends Entity {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector3dc location();
  Axis axis();
  void location(final Vector3dc location);
  void axis(final Axis axis);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int LOCATION = -713299213;
    int AXIS = 239960543;
  }

  interface Features<T extends Features<T>> extends Entity.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>> LOCATION = new AttributeBuilder<Vector3dc, Vector3dc, Listener<Vector3dc>, Features<?>>().name("location").defaultValue("0;0;0").id(PhysicalEntity.FeatureIDs.LOCATION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3D).build();
    Relation<Axis, Axis, Listener<Axis>, Features<?>> AXIS = new RelationBuilder<Axis, Axis, Listener<Axis>, Features<?>>().name("axis").contains(true).id(PhysicalEntity.FeatureIDs.AXIS).concept(() -> RenderingModelDefinition.Groups.AXIS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, LOCATION, AXIS);
  }
}
