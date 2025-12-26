package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class PhysicalEntityVariableImpl extends FeaturedObject<PhysicalEntityVariable.Features<?>> implements PhysicalEntityVariable {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<PhysicalEntityVariable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private PhysicalEntity entity;
  private EPhysicalEntityFeature feature;

  public PhysicalEntityVariableImpl(final String name, final EPhysicalEntityFeature feature) {
    this.name = name;
    this.feature = feature;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PhysicalEntityVariable.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public PhysicalEntity entity() {
    return entity;
  }

  @Override
  public void entity(final PhysicalEntity entity) {
    final var oldValue = this.entity;
    final var eventType = entity == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.entity = entity;
    notifier.notify(PhysicalEntityVariable.FeatureIDs.ENTITY, false, false, eventType, oldValue, entity);
  }

  @Override
  public EPhysicalEntityFeature feature() {
    return feature;
  }

  @Override
  public void feature(final EPhysicalEntityFeature feature) {
    final var oldValue = this.feature;
    this.feature = feature;
    notifier.notify(PhysicalEntityVariable.FeatureIDs.FEATURE, false, false, oldValue, feature);
  }

  @Override
  public Group<PhysicalEntityVariable> lmGroup() {
    return RenderingModelDefinition.Groups.PHYSICAL_ENTITY_VARIABLE;
  }

  @Override
  protected FeatureSetter<PhysicalEntityVariable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PhysicalEntityVariable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PhysicalEntityVariable.FeatureIDs.NAME -> 0;
      case PhysicalEntityVariable.FeatureIDs.ENTITY -> 1;
      case PhysicalEntityVariable.FeatureIDs.FEATURE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PhysicalEntityVariable> GET_MAP = new FeatureGetter.Builder<PhysicalEntityVariable>(FEATURE_COUNT, PhysicalEntityVariableImpl::featureIndexStatic).add(PhysicalEntityVariable.FeatureIDs.NAME, PhysicalEntityVariable::name).add(PhysicalEntityVariable.FeatureIDs.ENTITY, PhysicalEntityVariable::entity).add(PhysicalEntityVariable.FeatureIDs.FEATURE, PhysicalEntityVariable::feature).build();
    private static final FeatureSetter<PhysicalEntityVariable> SET_MAP = new FeatureSetter.Builder<PhysicalEntityVariable>(FEATURE_COUNT, PhysicalEntityVariableImpl::featureIndexStatic).add(PhysicalEntityVariable.FeatureIDs.ENTITY, (object, value) -> ((PhysicalEntityVariableImpl) object).entity((PhysicalEntity) value)).add(PhysicalEntityVariable.FeatureIDs.FEATURE, (object, value) -> ((PhysicalEntityVariableImpl) object).feature((EPhysicalEntityFeature) value)).build();
  }
}
