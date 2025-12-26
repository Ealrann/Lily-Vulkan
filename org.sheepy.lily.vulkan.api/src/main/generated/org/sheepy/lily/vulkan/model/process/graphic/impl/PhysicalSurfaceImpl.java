package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;

public final class PhysicalSurfaceImpl extends FeaturedObject<PhysicalSurface.Features<?>> implements PhysicalSurface {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<PhysicalSurface.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private ColorDomain colorDomain;

  public PhysicalSurfaceImpl(final ColorDomain colorDomain) {
    this.colorDomain = colorDomain;
    setContainer(colorDomain, PhysicalSurface.FeatureIDs.COLOR_DOMAIN);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PhysicalSurface.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public ColorDomain colorDomain() {
    return colorDomain;
  }

  @Override
  public void colorDomain(final ColorDomain colorDomain) {
    final var oldValue = this.colorDomain;
    final var eventType = colorDomain == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.colorDomain = colorDomain;
    setContainer(colorDomain, PhysicalSurface.FeatureIDs.COLOR_DOMAIN);
    beforeContainmentNotify(eventType, oldValue, colorDomain);
    notifier.notify(PhysicalSurface.FeatureIDs.COLOR_DOMAIN, true, false, eventType, oldValue, colorDomain);
    afterContainmentNotify(eventType, oldValue, colorDomain);
  }

  @Override
  public Group<PhysicalSurface> lmGroup() {
    return GraphicModelDefinition.Groups.PHYSICAL_SURFACE;
  }

  @Override
  protected FeatureSetter<PhysicalSurface> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PhysicalSurface> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PhysicalSurface.FeatureIDs.COLOR_DOMAIN -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PhysicalSurface> GET_MAP = new FeatureGetter.Builder<PhysicalSurface>(FEATURE_COUNT, PhysicalSurfaceImpl::featureIndexStatic).add(PhysicalSurface.FeatureIDs.COLOR_DOMAIN, PhysicalSurface::colorDomain).build();
    private static final FeatureSetter<PhysicalSurface> SET_MAP = new FeatureSetter.Builder<PhysicalSurface>(FEATURE_COUNT, PhysicalSurfaceImpl::featureIndexStatic).add(PhysicalSurface.FeatureIDs.COLOR_DOMAIN, (object, value) -> ((PhysicalSurfaceImpl) object).colorDomain((ColorDomain) value)).build();
  }
}
