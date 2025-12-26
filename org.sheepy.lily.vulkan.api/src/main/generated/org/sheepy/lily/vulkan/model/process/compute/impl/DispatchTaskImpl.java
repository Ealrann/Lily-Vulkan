package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

public final class DispatchTaskImpl extends FeaturedObject<DispatchTask.Features<?>> implements DispatchTask {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<DispatchTask.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private int workgroupCountX;
  private int workgroupCountY;
  private int workgroupCountZ;

  public DispatchTaskImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DispatchTask.Features<?>> notifier() {
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
  public int workgroupCountX() {
    return workgroupCountX;
  }

  @Override
  public void workgroupCountX(final int workgroupCountX) {
    final var oldValue = this.workgroupCountX;
    this.workgroupCountX = workgroupCountX;
    notifier.notifyInt(DispatchTask.FeatureIDs.WORKGROUP_COUNTX, false, false, oldValue, workgroupCountX);
  }

  @Override
  public int workgroupCountY() {
    return workgroupCountY;
  }

  @Override
  public void workgroupCountY(final int workgroupCountY) {
    final var oldValue = this.workgroupCountY;
    this.workgroupCountY = workgroupCountY;
    notifier.notifyInt(DispatchTask.FeatureIDs.WORKGROUP_COUNTY, false, false, oldValue, workgroupCountY);
  }

  @Override
  public int workgroupCountZ() {
    return workgroupCountZ;
  }

  @Override
  public void workgroupCountZ(final int workgroupCountZ) {
    final var oldValue = this.workgroupCountZ;
    this.workgroupCountZ = workgroupCountZ;
    notifier.notifyInt(DispatchTask.FeatureIDs.WORKGROUP_COUNTZ, false, false, oldValue, workgroupCountZ);
  }

  @Override
  public Group<DispatchTask> lmGroup() {
    return ComputeModelDefinition.Groups.DISPATCH_TASK;
  }

  @Override
  protected FeatureSetter<DispatchTask> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DispatchTask> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DispatchTask.FeatureIDs.NAME -> 0;
      case DispatchTask.FeatureIDs.ENABLED -> 1;
      case DispatchTask.FeatureIDs.WORKGROUP_COUNTX -> 2;
      case DispatchTask.FeatureIDs.WORKGROUP_COUNTY -> 3;
      case DispatchTask.FeatureIDs.WORKGROUP_COUNTZ -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DispatchTask> GET_MAP = new FeatureGetter.Builder<DispatchTask>(FEATURE_COUNT, DispatchTaskImpl::featureIndexStatic).add(DispatchTask.FeatureIDs.NAME, DispatchTask::name).add(DispatchTask.FeatureIDs.ENABLED, DispatchTask::enabled).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTX, DispatchTask::workgroupCountX).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTY, DispatchTask::workgroupCountY).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTZ, DispatchTask::workgroupCountZ).build();
    private static final FeatureSetter<DispatchTask> SET_MAP = new FeatureSetter.Builder<DispatchTask>(FEATURE_COUNT, DispatchTaskImpl::featureIndexStatic).add(DispatchTask.FeatureIDs.ENABLED, (object, value) -> ((DispatchTaskImpl) object).enabled((boolean) value)).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTX, (object, value) -> ((DispatchTaskImpl) object).workgroupCountX((int) value)).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTY, (object, value) -> ((DispatchTaskImpl) object).workgroupCountY((int) value)).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTZ, (object, value) -> ((DispatchTaskImpl) object).workgroupCountZ((int) value)).build();
  }
}
