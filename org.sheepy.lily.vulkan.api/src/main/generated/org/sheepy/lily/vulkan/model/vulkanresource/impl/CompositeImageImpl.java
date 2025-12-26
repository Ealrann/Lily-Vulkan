package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;

public final class CompositeImageImpl extends FeaturedObject<CompositeImage.Features<?>> implements CompositeImage {
  private static final int FEATURE_COUNT = 8;
  private final ModelNotifier<CompositeImage.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EFormat format;
  private final List<EImageUsage> usages = newObservableList(ImageInfo.FeatureIDs.USAGES, false, false);
  private int tiling;
  private int mipLevels;
  private EImageLayout initialLayout;
  private final String name;
  private final List<ImageInlay> inlays = newObservableList(CompositeImage.FeatureIDs.INLAYS, true, true);
  private IVulkanImage background;

  public CompositeImageImpl(final EFormat format, final List<EImageUsage> usages, final int tiling,
      final int mipLevels, final String name, final IVulkanImage background) {
    this.format = format;
    this.usages.addAll(usages);
    this.tiling = tiling;
    this.mipLevels = mipLevels;
    this.name = name;
    this.background = background;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CompositeImage.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public EFormat format() {
    return format;
  }

  @Override
  public void format(final EFormat format) {
    final var oldValue = this.format;
    this.format = format;
    notifier.notify(ImageInfo.FeatureIDs.FORMAT, false, false, oldValue, format);
  }

  @Override
  public List<EImageUsage> usages() {
    return usages;
  }

  @Override
  public int tiling() {
    return tiling;
  }

  @Override
  public void tiling(final int tiling) {
    final var oldValue = this.tiling;
    this.tiling = tiling;
    notifier.notifyInt(ImageInfo.FeatureIDs.TILING, false, false, oldValue, tiling);
  }

  @Override
  public int mipLevels() {
    return mipLevels;
  }

  @Override
  public void mipLevels(final int mipLevels) {
    final var oldValue = this.mipLevels;
    this.mipLevels = mipLevels;
    notifier.notifyInt(ImageInfo.FeatureIDs.MIP_LEVELS, false, false, oldValue, mipLevels);
  }

  @Override
  public EImageLayout initialLayout() {
    return initialLayout;
  }

  @Override
  public void initialLayout(final EImageLayout initialLayout) {
    final var oldValue = this.initialLayout;
    this.initialLayout = initialLayout;
    notifier.notify(ImageInfo.FeatureIDs.INITIAL_LAYOUT, false, false, oldValue, initialLayout);
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<ImageInlay> inlays() {
    return inlays;
  }

  @Override
  public IVulkanImage background() {
    return background;
  }

  @Override
  public void background(final IVulkanImage background) {
    final var oldValue = this.background;
    final var eventType = background == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.background = background;
    notifier.notify(CompositeImage.FeatureIDs.BACKGROUND, false, false, eventType, oldValue, background);
  }

  @Override
  public Group<CompositeImage> lmGroup() {
    return VulkanResourceModelDefinition.Groups.COMPOSITE_IMAGE;
  }

  @Override
  protected FeatureSetter<CompositeImage> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CompositeImage> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CompositeImage.FeatureIDs.FORMAT -> 0;
      case CompositeImage.FeatureIDs.USAGES -> 1;
      case CompositeImage.FeatureIDs.TILING -> 2;
      case CompositeImage.FeatureIDs.MIP_LEVELS -> 3;
      case CompositeImage.FeatureIDs.INITIAL_LAYOUT -> 4;
      case CompositeImage.FeatureIDs.NAME -> 5;
      case CompositeImage.FeatureIDs.INLAYS -> 6;
      case CompositeImage.FeatureIDs.BACKGROUND -> 7;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CompositeImage> GET_MAP = new FeatureGetter.Builder<CompositeImage>(FEATURE_COUNT, CompositeImageImpl::featureIndexStatic).add(CompositeImage.FeatureIDs.FORMAT, CompositeImage::format).add(CompositeImage.FeatureIDs.USAGES, CompositeImage::usages).add(CompositeImage.FeatureIDs.TILING, CompositeImage::tiling).add(CompositeImage.FeatureIDs.MIP_LEVELS, CompositeImage::mipLevels).add(CompositeImage.FeatureIDs.INITIAL_LAYOUT, CompositeImage::initialLayout).add(CompositeImage.FeatureIDs.NAME, CompositeImage::name).add(CompositeImage.FeatureIDs.INLAYS, CompositeImage::inlays).add(CompositeImage.FeatureIDs.BACKGROUND, CompositeImage::background).build();
    private static final FeatureSetter<CompositeImage> SET_MAP = new FeatureSetter.Builder<CompositeImage>(FEATURE_COUNT, CompositeImageImpl::featureIndexStatic).add(CompositeImage.FeatureIDs.FORMAT, (object, value) -> ((CompositeImageImpl) object).format((EFormat) value)).add(CompositeImage.FeatureIDs.TILING, (object, value) -> ((CompositeImageImpl) object).tiling((int) value)).add(CompositeImage.FeatureIDs.MIP_LEVELS, (object, value) -> ((CompositeImageImpl) object).mipLevels((int) value)).add(CompositeImage.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((CompositeImageImpl) object).initialLayout((EImageLayout) value)).add(CompositeImage.FeatureIDs.BACKGROUND, (object, value) -> ((CompositeImageImpl) object).background((IVulkanImage) value)).build();
  }
}
