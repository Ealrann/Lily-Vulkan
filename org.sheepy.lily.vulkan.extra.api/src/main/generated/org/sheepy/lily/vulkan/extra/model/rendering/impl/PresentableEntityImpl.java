package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class PresentableEntityImpl extends FeaturedObject<PresentableEntity.Features<?>> implements PresentableEntity {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<PresentableEntity.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Vector3dc location;
  private Axis axis;
  private Presentation presentation;
  private double scale;

  public PresentableEntityImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PresentableEntity.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Vector3dc location() {
    return location;
  }

  @Override
  public void location(final Vector3dc location) {
    final var oldValue = this.location;
    this.location = location;
    notifier.notify(PhysicalEntity.FeatureIDs.LOCATION, false, false, oldValue, location);
  }

  @Override
  public Axis axis() {
    return axis;
  }

  @Override
  public void axis(final Axis axis) {
    final var oldValue = this.axis;
    final var eventType = axis == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.axis = axis;
    setContainer(axis, PhysicalEntity.FeatureIDs.AXIS);
    beforeContainmentNotify(eventType, oldValue, axis);
    notifier.notify(PhysicalEntity.FeatureIDs.AXIS, true, false, eventType, oldValue, axis);
    afterContainmentNotify(eventType, oldValue, axis);
  }

  @Override
  public Presentation presentation() {
    return presentation;
  }

  @Override
  public void presentation(final Presentation presentation) {
    final var oldValue = this.presentation;
    final var eventType = presentation == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.presentation = presentation;
    notifier.notify(PresentableEntity.FeatureIDs.PRESENTATION, false, false, eventType, oldValue, presentation);
  }

  @Override
  public double scale() {
    return scale;
  }

  @Override
  public void scale(final double scale) {
    final var oldValue = this.scale;
    this.scale = scale;
    notifier.notifyDouble(PresentableEntity.FeatureIDs.SCALE, false, false, oldValue, scale);
  }

  @Override
  public Group<PresentableEntity> lmGroup() {
    return RenderingModelDefinition.Groups.PRESENTABLE_ENTITY;
  }

  @Override
  protected FeatureSetter<PresentableEntity> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PresentableEntity> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PresentableEntity.FeatureIDs.NAME -> 0;
      case PresentableEntity.FeatureIDs.LOCATION -> 1;
      case PresentableEntity.FeatureIDs.AXIS -> 2;
      case PresentableEntity.FeatureIDs.PRESENTATION -> 3;
      case PresentableEntity.FeatureIDs.SCALE -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PresentableEntity> GET_MAP = new FeatureGetter.Builder<PresentableEntity>(FEATURE_COUNT, PresentableEntityImpl::featureIndexStatic).add(PresentableEntity.FeatureIDs.NAME, PresentableEntity::name).add(PresentableEntity.FeatureIDs.LOCATION, PresentableEntity::location).add(PresentableEntity.FeatureIDs.AXIS, PresentableEntity::axis).add(PresentableEntity.FeatureIDs.PRESENTATION, PresentableEntity::presentation).add(PresentableEntity.FeatureIDs.SCALE, PresentableEntity::scale).build();
    private static final FeatureSetter<PresentableEntity> SET_MAP = new FeatureSetter.Builder<PresentableEntity>(FEATURE_COUNT, PresentableEntityImpl::featureIndexStatic).add(PresentableEntity.FeatureIDs.LOCATION, (object, value) -> ((PresentableEntityImpl) object).location((Vector3dc) value)).add(PresentableEntity.FeatureIDs.AXIS, (object, value) -> ((PresentableEntityImpl) object).axis((Axis) value)).add(PresentableEntity.FeatureIDs.PRESENTATION, (object, value) -> ((PresentableEntityImpl) object).presentation((Presentation) value)).add(PresentableEntity.FeatureIDs.SCALE, (object, value) -> ((PresentableEntityImpl) object).scale((double) value)).build();
  }
}
