package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;

public final class CompositeTaskImpl extends FeaturedObject<CompositeTask.Features<?>> implements CompositeTask {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<CompositeTask.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Maintainer<CompositeTask> maintainer;
  private final String name;
  private boolean enabled;
  private int repeatCount;
  private final List<IPipelineTask> tasks = newObservableList(CompositeTask.FeatureIDs.TASKS, true, true);

  public CompositeTaskImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CompositeTask.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Maintainer<CompositeTask> maintainer() {
    return maintainer;
  }

  @Override
  public void maintainer(final Maintainer<CompositeTask> maintainer) {
    final var oldValue = this.maintainer;
    final var eventType = maintainer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.maintainer = maintainer;
    notifier.notify(Maintainable.FeatureIDs.MAINTAINER, false, false, eventType, oldValue, maintainer);
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
  public int repeatCount() {
    return repeatCount;
  }

  @Override
  public void repeatCount(final int repeatCount) {
    final var oldValue = this.repeatCount;
    this.repeatCount = repeatCount;
    notifier.notifyInt(CompositeTask.FeatureIDs.REPEAT_COUNT, false, false, oldValue, repeatCount);
  }

  @Override
  public List<IPipelineTask> tasks() {
    return tasks;
  }

  @Override
  public Group<CompositeTask> lmGroup() {
    return ProcessModelDefinition.Groups.COMPOSITE_TASK;
  }

  @Override
  protected FeatureSetter<CompositeTask> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CompositeTask> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CompositeTask.FeatureIDs.MAINTAINER -> 0;
      case CompositeTask.FeatureIDs.NAME -> 1;
      case CompositeTask.FeatureIDs.ENABLED -> 2;
      case CompositeTask.FeatureIDs.REPEAT_COUNT -> 3;
      case CompositeTask.FeatureIDs.TASKS -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CompositeTask> GET_MAP = new FeatureGetter.Builder<CompositeTask>(FEATURE_COUNT, CompositeTaskImpl::featureIndexStatic).add(CompositeTask.FeatureIDs.MAINTAINER, CompositeTask::maintainer).add(CompositeTask.FeatureIDs.NAME, CompositeTask::name).add(CompositeTask.FeatureIDs.ENABLED, CompositeTask::enabled).add(CompositeTask.FeatureIDs.REPEAT_COUNT, CompositeTask::repeatCount).add(CompositeTask.FeatureIDs.TASKS, CompositeTask::tasks).build();
    private static final FeatureSetter<CompositeTask> SET_MAP = new FeatureSetter.Builder<CompositeTask>(FEATURE_COUNT, CompositeTaskImpl::featureIndexStatic).add(CompositeTask.FeatureIDs.MAINTAINER, (object, value) -> ((CompositeTaskImpl) object).maintainer((Maintainer<CompositeTask>) value)).add(CompositeTask.FeatureIDs.ENABLED, (object, value) -> ((CompositeTaskImpl) object).enabled((boolean) value)).add(CompositeTask.FeatureIDs.REPEAT_COUNT, (object, value) -> ((CompositeTaskImpl) object).repeatCount((int) value)).build();
  }
}
