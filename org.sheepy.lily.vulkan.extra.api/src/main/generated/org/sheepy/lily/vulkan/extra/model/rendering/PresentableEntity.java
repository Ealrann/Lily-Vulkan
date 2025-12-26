package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.DoubleListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.PresentableEntityBuilder;

public interface PresentableEntity extends PhysicalEntity {
  static Builder builder() {
    return new PresentableEntityBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Presentation presentation();
  double scale();
  void presentation(final Presentation presentation);
  void scale(final double scale);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int LOCATION = PhysicalEntity.FeatureIDs.LOCATION;
    int AXIS = PhysicalEntity.FeatureIDs.AXIS;
    int PRESENTATION = 2004844894;
    int SCALE = -34157690;
  }

  interface Features<T extends Features<T>> extends PhysicalEntity.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Vector3dc, Vector3dc, Listener<Vector3dc>, PhysicalEntity.Features<?>> LOCATION = PhysicalEntity.Features.LOCATION;
    Relation<Axis, Axis, Listener<Axis>, PhysicalEntity.Features<?>> AXIS = PhysicalEntity.Features.AXIS;
    Relation<Presentation, Presentation, Listener<Presentation>, Features<?>> PRESENTATION = new RelationBuilder<Presentation, Presentation, Listener<Presentation>, Features<?>>().name("presentation").id(PresentableEntity.FeatureIDs.PRESENTATION).concept(() -> RenderingModelDefinition.Groups.PRESENTATION).build();
    Attribute<Double, Double, DoubleListener, Features<?>> SCALE = new AttributeBuilder<Double, Double, DoubleListener, Features<?>>().name("scale").defaultValue("1").id(PresentableEntity.FeatureIDs.SCALE).datatype(() -> LMCoreModelDefinition.Units.DOUBLE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, LOCATION, AXIS, PRESENTATION, SCALE);
  }

  interface Builder extends IFeaturedObject.Builder<PresentableEntity> {
    Builder name(String name);
    Builder location(Vector3dc location);
    Builder axis(Supplier<Axis> axis);
    Builder presentation(Supplier<Presentation> presentation);
    Builder scale(double scale);
  }
}
