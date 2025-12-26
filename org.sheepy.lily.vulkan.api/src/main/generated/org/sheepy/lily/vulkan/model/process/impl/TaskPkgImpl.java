package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public final class TaskPkgImpl extends FeaturedObject<TaskPkg.Features<?>> implements TaskPkg {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<TaskPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IPipelineTask> tasks = newObservableList(TaskPkg.FeatureIDs.TASKS, true, true);
  private ECommandStage stage;

  public TaskPkgImpl(final ECommandStage stage) {
    this.stage = stage;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<TaskPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IPipelineTask> tasks() {
    return tasks;
  }

  @Override
  public ECommandStage stage() {
    return stage;
  }

  @Override
  public void stage(final ECommandStage stage) {
    final var oldValue = this.stage;
    this.stage = stage;
    notifier.notify(TaskPkg.FeatureIDs.STAGE, false, false, oldValue, stage);
  }

  @Override
  public Group<TaskPkg> lmGroup() {
    return ProcessModelDefinition.Groups.TASK_PKG;
  }

  @Override
  protected FeatureSetter<TaskPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<TaskPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case TaskPkg.FeatureIDs.TASKS -> 0;
      case TaskPkg.FeatureIDs.STAGE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<TaskPkg> GET_MAP = new FeatureGetter.Builder<TaskPkg>(FEATURE_COUNT, TaskPkgImpl::featureIndexStatic).add(TaskPkg.FeatureIDs.TASKS, TaskPkg::tasks).add(TaskPkg.FeatureIDs.STAGE, TaskPkg::stage).build();
    private static final FeatureSetter<TaskPkg> SET_MAP = new FeatureSetter.Builder<TaskPkg>(FEATURE_COUNT, TaskPkgImpl::featureIndexStatic).add(TaskPkg.FeatureIDs.STAGE, (object, value) -> ((TaskPkgImpl) object).stage((ECommandStage) value)).build();
  }
}
