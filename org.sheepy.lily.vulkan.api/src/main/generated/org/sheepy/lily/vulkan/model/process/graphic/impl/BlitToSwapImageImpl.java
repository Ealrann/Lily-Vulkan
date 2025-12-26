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
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.vulkan.model.enumeration.EFilter;

public final class BlitToSwapImageImpl extends FeaturedObject<BlitToSwapImage.Features<?>> implements BlitToSwapImage {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<BlitToSwapImage.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private EFilter filter;
  private Vector3ic clearColor;
  private IVulkanImage srcImage;

  public BlitToSwapImageImpl(final String name, final Vector3ic clearColor) {
    this.name = name;
    this.clearColor = clearColor;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BlitToSwapImage.Features<?>> notifier() {
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
  public Group<BlitToSwapImage> lmGroup() {
    return GraphicModelDefinition.Groups.BLIT_TO_SWAP_IMAGE;
  }

  @Override
  protected FeatureSetter<BlitToSwapImage> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BlitToSwapImage> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BlitToSwapImage.FeatureIDs.NAME -> 0;
      case BlitToSwapImage.FeatureIDs.ENABLED -> 1;
      case BlitToSwapImage.FeatureIDs.FILTER -> 2;
      case BlitToSwapImage.FeatureIDs.CLEAR_COLOR -> 3;
      case BlitToSwapImage.FeatureIDs.SRC_IMAGE -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BlitToSwapImage> GET_MAP = new FeatureGetter.Builder<BlitToSwapImage>(FEATURE_COUNT, BlitToSwapImageImpl::featureIndexStatic).add(BlitToSwapImage.FeatureIDs.NAME, BlitToSwapImage::name).add(BlitToSwapImage.FeatureIDs.ENABLED, BlitToSwapImage::enabled).add(BlitToSwapImage.FeatureIDs.FILTER, BlitToSwapImage::filter).add(BlitToSwapImage.FeatureIDs.CLEAR_COLOR, BlitToSwapImage::clearColor).add(BlitToSwapImage.FeatureIDs.SRC_IMAGE, BlitToSwapImage::srcImage).build();
    private static final FeatureSetter<BlitToSwapImage> SET_MAP = new FeatureSetter.Builder<BlitToSwapImage>(FEATURE_COUNT, BlitToSwapImageImpl::featureIndexStatic).add(BlitToSwapImage.FeatureIDs.ENABLED, (object, value) -> ((BlitToSwapImageImpl) object).enabled((boolean) value)).add(BlitToSwapImage.FeatureIDs.FILTER, (object, value) -> ((BlitToSwapImageImpl) object).filter((EFilter) value)).add(BlitToSwapImage.FeatureIDs.CLEAR_COLOR, (object, value) -> ((BlitToSwapImageImpl) object).clearColor((Vector3ic) value)).add(BlitToSwapImage.FeatureIDs.SRC_IMAGE, (object, value) -> ((BlitToSwapImageImpl) object).srcImage((IVulkanImage) value)).build();
  }
}
