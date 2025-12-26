package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;

public final class ImageViewerImpl extends FeaturedObject<ImageViewer.Features<?>> implements ImageViewer {
  private static final int FEATURE_COUNT = 8;
  private final ModelNotifier<ImageViewer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EFormat format;
  private final List<EImageUsage> usages = newObservableList(ImageInfo.FeatureIDs.USAGES, false, false);
  private int tiling;
  private int mipLevels;
  private EImageLayout initialLayout;
  private final String name;
  private ImageDataProvider dataProvider;
  private boolean mipmapEnabled;

  public ImageViewerImpl(final EFormat format, final List<EImageUsage> usages, final int tiling,
      final int mipLevels, final String name, final ImageDataProvider dataProvider,
      final boolean mipmapEnabled) {
    this.format = format;
    this.usages.addAll(usages);
    this.tiling = tiling;
    this.mipLevels = mipLevels;
    this.name = name;
    this.dataProvider = dataProvider;
    this.mipmapEnabled = mipmapEnabled;
    setContainer(dataProvider, ImageViewer.FeatureIDs.DATA_PROVIDER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageViewer.Features<?>> notifier() {
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
  public ImageDataProvider dataProvider() {
    return dataProvider;
  }

  @Override
  public void dataProvider(final ImageDataProvider dataProvider) {
    final var oldValue = this.dataProvider;
    final var eventType = dataProvider == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dataProvider = dataProvider;
    setContainer(dataProvider, ImageViewer.FeatureIDs.DATA_PROVIDER);
    beforeContainmentNotify(eventType, oldValue, dataProvider);
    notifier.notify(ImageViewer.FeatureIDs.DATA_PROVIDER, true, false, eventType, oldValue, dataProvider);
    afterContainmentNotify(eventType, oldValue, dataProvider);
  }

  @Override
  public boolean mipmapEnabled() {
    return mipmapEnabled;
  }

  @Override
  public void mipmapEnabled(final boolean mipmapEnabled) {
    final var oldValue = this.mipmapEnabled;
    this.mipmapEnabled = mipmapEnabled;
    notifier.notifyBoolean(ImageViewer.FeatureIDs.MIPMAP_ENABLED, false, false, oldValue, mipmapEnabled);
  }

  @Override
  public Group<ImageViewer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.IMAGE_VIEWER;
  }

  @Override
  protected FeatureSetter<ImageViewer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageViewer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageViewer.FeatureIDs.FORMAT -> 0;
      case ImageViewer.FeatureIDs.USAGES -> 1;
      case ImageViewer.FeatureIDs.TILING -> 2;
      case ImageViewer.FeatureIDs.MIP_LEVELS -> 3;
      case ImageViewer.FeatureIDs.INITIAL_LAYOUT -> 4;
      case ImageViewer.FeatureIDs.NAME -> 5;
      case ImageViewer.FeatureIDs.DATA_PROVIDER -> 6;
      case ImageViewer.FeatureIDs.MIPMAP_ENABLED -> 7;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageViewer> GET_MAP = new FeatureGetter.Builder<ImageViewer>(FEATURE_COUNT, ImageViewerImpl::featureIndexStatic).add(ImageViewer.FeatureIDs.FORMAT, ImageViewer::format).add(ImageViewer.FeatureIDs.USAGES, ImageViewer::usages).add(ImageViewer.FeatureIDs.TILING, ImageViewer::tiling).add(ImageViewer.FeatureIDs.MIP_LEVELS, ImageViewer::mipLevels).add(ImageViewer.FeatureIDs.INITIAL_LAYOUT, ImageViewer::initialLayout).add(ImageViewer.FeatureIDs.NAME, ImageViewer::name).add(ImageViewer.FeatureIDs.DATA_PROVIDER, ImageViewer::dataProvider).add(ImageViewer.FeatureIDs.MIPMAP_ENABLED, ImageViewer::mipmapEnabled).build();
    private static final FeatureSetter<ImageViewer> SET_MAP = new FeatureSetter.Builder<ImageViewer>(FEATURE_COUNT, ImageViewerImpl::featureIndexStatic).add(ImageViewer.FeatureIDs.FORMAT, (object, value) -> ((ImageViewerImpl) object).format((EFormat) value)).add(ImageViewer.FeatureIDs.TILING, (object, value) -> ((ImageViewerImpl) object).tiling((int) value)).add(ImageViewer.FeatureIDs.MIP_LEVELS, (object, value) -> ((ImageViewerImpl) object).mipLevels((int) value)).add(ImageViewer.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((ImageViewerImpl) object).initialLayout((EImageLayout) value)).add(ImageViewer.FeatureIDs.DATA_PROVIDER, (object, value) -> ((ImageViewerImpl) object).dataProvider((ImageDataProvider) value)).add(ImageViewer.FeatureIDs.MIPMAP_ENABLED, (object, value) -> ((ImageViewerImpl) object).mipmapEnabled((boolean) value)).build();
  }
}
