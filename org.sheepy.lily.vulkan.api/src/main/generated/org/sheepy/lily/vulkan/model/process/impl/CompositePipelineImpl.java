package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;

public final class CompositePipelineImpl extends FeaturedObject<CompositePipeline.Features<?>> implements CompositePipeline {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<CompositePipeline.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean allocate;
  private boolean record;
  private PipelineExtensionPkg extensionPkg;
  private final List<TaskPipeline> pipelines = newObservableList(CompositePipeline.FeatureIDs.PIPELINES, true, true);
  private int repeat;

  public CompositePipelineImpl(final String name, final int repeat) {
    this.name = name;
    this.repeat = repeat;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CompositePipeline.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean allocate() {
    return allocate;
  }

  @Override
  public void allocate(final boolean allocate) {
    final var oldValue = this.allocate;
    this.allocate = allocate;
    notifier.notifyBoolean(AbstractPipeline.FeatureIDs.ALLOCATE, false, false, oldValue, allocate);
  }

  @Override
  public boolean record() {
    return record;
  }

  @Override
  public void record(final boolean record) {
    final var oldValue = this.record;
    this.record = record;
    notifier.notifyBoolean(AbstractPipeline.FeatureIDs.RECORD, false, false, oldValue, record);
  }

  @Override
  public PipelineExtensionPkg extensionPkg() {
    return extensionPkg;
  }

  @Override
  public void extensionPkg(final PipelineExtensionPkg extensionPkg) {
    final var oldValue = this.extensionPkg;
    final var eventType = extensionPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.extensionPkg = extensionPkg;
    setContainer(extensionPkg, AbstractPipeline.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(AbstractPipeline.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public List<TaskPipeline> pipelines() {
    return pipelines;
  }

  @Override
  public int repeat() {
    return repeat;
  }

  @Override
  public void repeat(final int repeat) {
    final var oldValue = this.repeat;
    this.repeat = repeat;
    notifier.notifyInt(CompositePipeline.FeatureIDs.REPEAT, false, false, oldValue, repeat);
  }

  @Override
  public Group<CompositePipeline> lmGroup() {
    return ProcessModelDefinition.Groups.COMPOSITE_PIPELINE;
  }

  @Override
  protected FeatureSetter<CompositePipeline> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CompositePipeline> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CompositePipeline.FeatureIDs.NAME -> 0;
      case CompositePipeline.FeatureIDs.ALLOCATE -> 1;
      case CompositePipeline.FeatureIDs.RECORD -> 2;
      case CompositePipeline.FeatureIDs.EXTENSION_PKG -> 3;
      case CompositePipeline.FeatureIDs.PIPELINES -> 4;
      case CompositePipeline.FeatureIDs.REPEAT -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CompositePipeline> GET_MAP = new FeatureGetter.Builder<CompositePipeline>(FEATURE_COUNT, CompositePipelineImpl::featureIndexStatic).add(CompositePipeline.FeatureIDs.NAME, CompositePipeline::name).add(CompositePipeline.FeatureIDs.ALLOCATE, CompositePipeline::allocate).add(CompositePipeline.FeatureIDs.RECORD, CompositePipeline::record).add(CompositePipeline.FeatureIDs.EXTENSION_PKG, CompositePipeline::extensionPkg).add(CompositePipeline.FeatureIDs.PIPELINES, CompositePipeline::pipelines).add(CompositePipeline.FeatureIDs.REPEAT, CompositePipeline::repeat).build();
    private static final FeatureSetter<CompositePipeline> SET_MAP = new FeatureSetter.Builder<CompositePipeline>(FEATURE_COUNT, CompositePipelineImpl::featureIndexStatic).add(CompositePipeline.FeatureIDs.ALLOCATE, (object, value) -> ((CompositePipelineImpl) object).allocate((boolean) value)).add(CompositePipeline.FeatureIDs.RECORD, (object, value) -> ((CompositePipelineImpl) object).record((boolean) value)).add(CompositePipeline.FeatureIDs.EXTENSION_PKG, (object, value) -> ((CompositePipelineImpl) object).extensionPkg((PipelineExtensionPkg) value)).add(CompositePipeline.FeatureIDs.REPEAT, (object, value) -> ((CompositePipelineImpl) object).repeat((int) value)).build();
  }
}
