package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.PhysicalSurfaceBuilder;

public interface PhysicalSurface extends LMObject {
  static Builder builder() {
    return new PhysicalSurfaceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ColorDomain colorDomain();
  void colorDomain(final ColorDomain colorDomain);

  interface FeatureIDs {
    int COLOR_DOMAIN = -719474500;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ColorDomain, ColorDomain, Listener<ColorDomain>, Features<?>> COLOR_DOMAIN = new RelationBuilder<ColorDomain, ColorDomain, Listener<ColorDomain>, Features<?>>().name("colorDomain").mandatory(true).contains(true).id(PhysicalSurface.FeatureIDs.COLOR_DOMAIN).concept(() -> GraphicModelDefinition.Groups.COLOR_DOMAIN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(COLOR_DOMAIN);
  }

  interface Builder extends IFeaturedObject.Builder<PhysicalSurface> {
    Builder colorDomain(Supplier<ColorDomain> colorDomain);
  }
}
