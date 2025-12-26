package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class ImageBarrierImpl extends FeaturedObject<ImageBarrier.Features<?>> implements ImageBarrier {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<ImageBarrier.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<EAccess> srcAccessMask = newObservableList(Barrier.FeatureIDs.SRC_ACCESS_MASK, false, false);
  private final List<EAccess> dstAccessMask = newObservableList(Barrier.FeatureIDs.DST_ACCESS_MASK, false, false);
  private EImageLayout srcLayout;
  private EImageLayout dstLayout;
  private IVulkanImage image;

  public ImageBarrierImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageBarrier.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<EAccess> srcAccessMask() {
    return srcAccessMask;
  }

  @Override
  public List<EAccess> dstAccessMask() {
    return dstAccessMask;
  }

  @Override
  public EImageLayout srcLayout() {
    return srcLayout;
  }

  @Override
  public void srcLayout(final EImageLayout srcLayout) {
    final var oldValue = this.srcLayout;
    this.srcLayout = srcLayout;
    notifier.notify(AbstractImageBarrier.FeatureIDs.SRC_LAYOUT, false, false, oldValue, srcLayout);
  }

  @Override
  public EImageLayout dstLayout() {
    return dstLayout;
  }

  @Override
  public void dstLayout(final EImageLayout dstLayout) {
    final var oldValue = this.dstLayout;
    this.dstLayout = dstLayout;
    notifier.notify(AbstractImageBarrier.FeatureIDs.DST_LAYOUT, false, false, oldValue, dstLayout);
  }

  @Override
  public IVulkanImage image() {
    return image;
  }

  @Override
  public void image(final IVulkanImage image) {
    final var oldValue = this.image;
    final var eventType = image == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.image = image;
    notifier.notify(ImageBarrier.FeatureIDs.IMAGE, false, false, eventType, oldValue, image);
  }

  @Override
  public Group<ImageBarrier> lmGroup() {
    return VulkanResourceModelDefinition.Groups.IMAGE_BARRIER;
  }

  @Override
  protected FeatureSetter<ImageBarrier> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageBarrier> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageBarrier.FeatureIDs.NAME -> 0;
      case ImageBarrier.FeatureIDs.SRC_ACCESS_MASK -> 1;
      case ImageBarrier.FeatureIDs.DST_ACCESS_MASK -> 2;
      case ImageBarrier.FeatureIDs.SRC_LAYOUT -> 3;
      case ImageBarrier.FeatureIDs.DST_LAYOUT -> 4;
      case ImageBarrier.FeatureIDs.IMAGE -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageBarrier> GET_MAP = new FeatureGetter.Builder<ImageBarrier>(FEATURE_COUNT, ImageBarrierImpl::featureIndexStatic).add(ImageBarrier.FeatureIDs.NAME, ImageBarrier::name).add(ImageBarrier.FeatureIDs.SRC_ACCESS_MASK, ImageBarrier::srcAccessMask).add(ImageBarrier.FeatureIDs.DST_ACCESS_MASK, ImageBarrier::dstAccessMask).add(ImageBarrier.FeatureIDs.SRC_LAYOUT, ImageBarrier::srcLayout).add(ImageBarrier.FeatureIDs.DST_LAYOUT, ImageBarrier::dstLayout).add(ImageBarrier.FeatureIDs.IMAGE, ImageBarrier::image).build();
    private static final FeatureSetter<ImageBarrier> SET_MAP = new FeatureSetter.Builder<ImageBarrier>(FEATURE_COUNT, ImageBarrierImpl::featureIndexStatic).add(ImageBarrier.FeatureIDs.SRC_LAYOUT, (object, value) -> ((ImageBarrierImpl) object).srcLayout((EImageLayout) value)).add(ImageBarrier.FeatureIDs.DST_LAYOUT, (object, value) -> ((ImageBarrierImpl) object).dstLayout((EImageLayout) value)).add(ImageBarrier.FeatureIDs.IMAGE, (object, value) -> ((ImageBarrierImpl) object).image((IVulkanImage) value)).build();
  }
}
