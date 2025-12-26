package org.sheepy.vulkan.model.image.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageModelDefinition;

public final class ImageInfoImpl extends FeaturedObject<ImageInfo.Features<?>> implements ImageInfo {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<ImageInfo.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EFormat format;
  private final List<EImageUsage> usages = newObservableList(ImageInfo.FeatureIDs.USAGES, false, false);
  private int tiling;
  private int mipLevels;
  private EImageLayout initialLayout;

  public ImageInfoImpl(final EFormat format, final List<EImageUsage> usages, final int tiling,
      final int mipLevels) {
    this.format = format;
    this.usages.addAll(usages);
    this.tiling = tiling;
    this.mipLevels = mipLevels;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageInfo.Features<?>> notifier() {
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
  public Group<ImageInfo> lmGroup() {
    return ImageModelDefinition.Groups.IMAGE_INFO;
  }

  @Override
  protected FeatureSetter<ImageInfo> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageInfo> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageInfo.FeatureIDs.FORMAT -> 0;
      case ImageInfo.FeatureIDs.USAGES -> 1;
      case ImageInfo.FeatureIDs.TILING -> 2;
      case ImageInfo.FeatureIDs.MIP_LEVELS -> 3;
      case ImageInfo.FeatureIDs.INITIAL_LAYOUT -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageInfo> GET_MAP = new FeatureGetter.Builder<ImageInfo>(FEATURE_COUNT, ImageInfoImpl::featureIndexStatic).add(ImageInfo.FeatureIDs.FORMAT, ImageInfo::format).add(ImageInfo.FeatureIDs.USAGES, ImageInfo::usages).add(ImageInfo.FeatureIDs.TILING, ImageInfo::tiling).add(ImageInfo.FeatureIDs.MIP_LEVELS, ImageInfo::mipLevels).add(ImageInfo.FeatureIDs.INITIAL_LAYOUT, ImageInfo::initialLayout).build();
    private static final FeatureSetter<ImageInfo> SET_MAP = new FeatureSetter.Builder<ImageInfo>(FEATURE_COUNT, ImageInfoImpl::featureIndexStatic).add(ImageInfo.FeatureIDs.FORMAT, (object, value) -> ((ImageInfoImpl) object).format((EFormat) value)).add(ImageInfo.FeatureIDs.TILING, (object, value) -> ((ImageInfoImpl) object).tiling((int) value)).add(ImageInfo.FeatureIDs.MIP_LEVELS, (object, value) -> ((ImageInfoImpl) object).mipLevels((int) value)).add(ImageInfo.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((ImageInfoImpl) object).initialLayout((EImageLayout) value)).build();
  }
}
