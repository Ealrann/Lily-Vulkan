package org.sheepy.vulkan.model.pipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.pipeline.PipelineModelDefinition;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

public final class SpecializationConstantImpl extends FeaturedObject<SpecializationConstant.Features<?>> implements SpecializationConstant {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<SpecializationConstant.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private String name;
  private int constantId;
  private int size;

  public SpecializationConstantImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SpecializationConstant.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public void name(final String name) {
    final var oldValue = this.name;
    this.name = name;
    notifier.notify(SpecializationConstant.FeatureIDs.NAME, false, false, oldValue, name);
  }

  @Override
  public int constantId() {
    return constantId;
  }

  @Override
  public void constantId(final int constantId) {
    final var oldValue = this.constantId;
    this.constantId = constantId;
    notifier.notifyInt(SpecializationConstant.FeatureIDs.CONSTANT_ID, false, false, oldValue, constantId);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void size(final int size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notifyInt(SpecializationConstant.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public Group<SpecializationConstant> lmGroup() {
    return PipelineModelDefinition.Groups.SPECIALIZATION_CONSTANT;
  }

  @Override
  protected FeatureSetter<SpecializationConstant> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SpecializationConstant> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SpecializationConstant.FeatureIDs.NAME -> 0;
      case SpecializationConstant.FeatureIDs.CONSTANT_ID -> 1;
      case SpecializationConstant.FeatureIDs.SIZE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SpecializationConstant> GET_MAP = new FeatureGetter.Builder<SpecializationConstant>(FEATURE_COUNT, SpecializationConstantImpl::featureIndexStatic).add(SpecializationConstant.FeatureIDs.NAME, SpecializationConstant::name).add(SpecializationConstant.FeatureIDs.CONSTANT_ID, SpecializationConstant::constantId).add(SpecializationConstant.FeatureIDs.SIZE, SpecializationConstant::size).build();
    private static final FeatureSetter<SpecializationConstant> SET_MAP = new FeatureSetter.Builder<SpecializationConstant>(FEATURE_COUNT, SpecializationConstantImpl::featureIndexStatic).add(SpecializationConstant.FeatureIDs.NAME, (object, value) -> ((SpecializationConstantImpl) object).name((String) value)).add(SpecializationConstant.FeatureIDs.CONSTANT_ID, (object, value) -> ((SpecializationConstantImpl) object).constantId((int) value)).add(SpecializationConstant.FeatureIDs.SIZE, (object, value) -> ((SpecializationConstantImpl) object).size((int) value)).build();
  }
}
