package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.joml.Vector3ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.AbstractBlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.vulkan.model.enumeration.EFilter;

public final class BlitTaskImpl extends FeaturedObject<BlitTask.Features<?>> implements BlitTask {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<BlitTask.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private EFilter filter;
  private Vector3ic clearColor;
  private IVulkanImage srcImage;
  private IVulkanImage dstImage;

  public BlitTaskImpl(final String name, final Vector3ic clearColor) {
    this.name = name;
    this.clearColor = clearColor;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BlitTask.Features<?>> notifier() {
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
  public EFilter filter() {
    return filter;
  }

  @Override
  public void filter(final EFilter filter) {
    final var oldValue = this.filter;
    this.filter = filter;
    notifier.notify(AbstractBlitTask.FeatureIDs.FILTER, false, false, oldValue, filter);
  }

  @Override
  public Vector3ic clearColor() {
    return clearColor;
  }

  @Override
  public void clearColor(final Vector3ic clearColor) {
    final var oldValue = this.clearColor;
    this.clearColor = clearColor;
    notifier.notify(AbstractBlitTask.FeatureIDs.CLEAR_COLOR, false, false, oldValue, clearColor);
  }

  @Override
  public IVulkanImage srcImage() {
    return srcImage;
  }

  @Override
  public void srcImage(final IVulkanImage srcImage) {
    final var oldValue = this.srcImage;
    final var eventType = srcImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.srcImage = srcImage;
    notifier.notify(AbstractBlitTask.FeatureIDs.SRC_IMAGE, false, false, eventType, oldValue, srcImage);
  }

  @Override
  public IVulkanImage dstImage() {
    return dstImage;
  }

  @Override
  public void dstImage(final IVulkanImage dstImage) {
    final var oldValue = this.dstImage;
    final var eventType = dstImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dstImage = dstImage;
    notifier.notify(BlitTask.FeatureIDs.DST_IMAGE, false, false, eventType, oldValue, dstImage);
  }

  @Override
  public Group<BlitTask> lmGroup() {
    return GraphicModelDefinition.Groups.BLIT_TASK;
  }

  @Override
  protected FeatureSetter<BlitTask> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BlitTask> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BlitTask.FeatureIDs.NAME -> 0;
      case BlitTask.FeatureIDs.ENABLED -> 1;
      case BlitTask.FeatureIDs.FILTER -> 2;
      case BlitTask.FeatureIDs.CLEAR_COLOR -> 3;
      case BlitTask.FeatureIDs.SRC_IMAGE -> 4;
      case BlitTask.FeatureIDs.DST_IMAGE -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BlitTask> GET_MAP = new FeatureGetter.Builder<BlitTask>(FEATURE_COUNT, BlitTaskImpl::featureIndexStatic).add(BlitTask.FeatureIDs.NAME, BlitTask::name).add(BlitTask.FeatureIDs.ENABLED, BlitTask::enabled).add(BlitTask.FeatureIDs.FILTER, BlitTask::filter).add(BlitTask.FeatureIDs.CLEAR_COLOR, BlitTask::clearColor).add(BlitTask.FeatureIDs.SRC_IMAGE, BlitTask::srcImage).add(BlitTask.FeatureIDs.DST_IMAGE, BlitTask::dstImage).build();
    private static final FeatureSetter<BlitTask> SET_MAP = new FeatureSetter.Builder<BlitTask>(FEATURE_COUNT, BlitTaskImpl::featureIndexStatic).add(BlitTask.FeatureIDs.ENABLED, (object, value) -> ((BlitTaskImpl) object).enabled((boolean) value)).add(BlitTask.FeatureIDs.FILTER, (object, value) -> ((BlitTaskImpl) object).filter((EFilter) value)).add(BlitTask.FeatureIDs.CLEAR_COLOR, (object, value) -> ((BlitTaskImpl) object).clearColor((Vector3ic) value)).add(BlitTask.FeatureIDs.SRC_IMAGE, (object, value) -> ((BlitTaskImpl) object).srcImage((IVulkanImage) value)).add(BlitTask.FeatureIDs.DST_IMAGE, (object, value) -> ((BlitTaskImpl) object).dstImage((IVulkanImage) value)).build();
  }
}
