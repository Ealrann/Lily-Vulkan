package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.vulkan.model.enumeration.EBindPoint;

public final class BindDescriptorSetsImpl extends FeaturedObject<BindDescriptorSets.Features<?>> implements BindDescriptorSets {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<BindDescriptorSets.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private final List<DescriptorSet> descriptorSets = newObservableList(BindDescriptorSets.FeatureIDs.DESCRIPTOR_SETS, true, false);
  private EBindPoint bindPoint;
  private int stride;

  public BindDescriptorSetsImpl(final String name, final EBindPoint bindPoint) {
    this.name = name;
    this.bindPoint = bindPoint;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BindDescriptorSets.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IPipelineTask.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public List<DescriptorSet> descriptorSets() {
    return descriptorSets;
  }

  @Override
  public EBindPoint bindPoint() {
    return bindPoint;
  }

  @Override
  public void bindPoint(final EBindPoint bindPoint) {
    final var oldValue = this.bindPoint;
    this.bindPoint = bindPoint;
    notifier.notify(BindDescriptorSets.FeatureIDs.BIND_POINT, false, false, oldValue, bindPoint);
  }

  @Override
  public int stride() {
    return stride;
  }

  @Override
  public void stride(final int stride) {
    final var oldValue = this.stride;
    this.stride = stride;
    notifier.notifyInt(BindDescriptorSets.FeatureIDs.STRIDE, false, false, oldValue, stride);
  }

  @Override
  public Group<BindDescriptorSets> lmGroup() {
    return ProcessModelDefinition.Groups.BIND_DESCRIPTOR_SETS;
  }

  @Override
  protected FeatureSetter<BindDescriptorSets> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BindDescriptorSets> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BindDescriptorSets.FeatureIDs.NAME -> 0;
      case BindDescriptorSets.FeatureIDs.ENABLED -> 1;
      case BindDescriptorSets.FeatureIDs.DESCRIPTOR_SETS -> 2;
      case BindDescriptorSets.FeatureIDs.BIND_POINT -> 3;
      case BindDescriptorSets.FeatureIDs.STRIDE -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BindDescriptorSets> GET_MAP = new FeatureGetter.Builder<BindDescriptorSets>(FEATURE_COUNT, BindDescriptorSetsImpl::featureIndexStatic).add(BindDescriptorSets.FeatureIDs.NAME, BindDescriptorSets::name).add(BindDescriptorSets.FeatureIDs.ENABLED, BindDescriptorSets::enabled).add(BindDescriptorSets.FeatureIDs.DESCRIPTOR_SETS, BindDescriptorSets::descriptorSets).add(BindDescriptorSets.FeatureIDs.BIND_POINT, BindDescriptorSets::bindPoint).add(BindDescriptorSets.FeatureIDs.STRIDE, BindDescriptorSets::stride).build();
    private static final FeatureSetter<BindDescriptorSets> SET_MAP = new FeatureSetter.Builder<BindDescriptorSets>(FEATURE_COUNT, BindDescriptorSetsImpl::featureIndexStatic).add(BindDescriptorSets.FeatureIDs.ENABLED, (object, value) -> ((BindDescriptorSetsImpl) object).enabled((boolean) value)).add(BindDescriptorSets.FeatureIDs.BIND_POINT, (object, value) -> ((BindDescriptorSetsImpl) object).bindPoint((EBindPoint) value)).add(BindDescriptorSets.FeatureIDs.STRIDE, (object, value) -> ((BindDescriptorSetsImpl) object).stride((int) value)).build();
  }
}
