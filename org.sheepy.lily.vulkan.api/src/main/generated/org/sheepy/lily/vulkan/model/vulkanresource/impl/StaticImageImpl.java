package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.nio.ByteBuffer;
import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;

public final class StaticImageImpl extends FeaturedObject<StaticImage.Features<?>> implements StaticImage {
  private static final int FEATURE_COUNT = 9;
  private final ModelNotifier<StaticImage.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EFormat format;
  private final List<EImageUsage> usages = newObservableList(ImageInfo.FeatureIDs.USAGES, false, false);
  private int tiling;
  private int mipLevels;
  private EImageLayout initialLayout;
  private final String name;
  private boolean fillWithZero;
  private ByteBuffer fillWith;
  private Vector2ic size;

  public StaticImageImpl(final EFormat format, final List<EImageUsage> usages, final int tiling,
      final int mipLevels, final String name, final Vector2ic size) {
    this.format = format;
    this.usages.addAll(usages);
    this.tiling = tiling;
    this.mipLevels = mipLevels;
    this.name = name;
    this.size = size;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<StaticImage.Features<?>> notifier() {
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
  public boolean fillWithZero() {
    return fillWithZero;
  }

  @Override
  public void fillWithZero(final boolean fillWithZero) {
    final var oldValue = this.fillWithZero;
    this.fillWithZero = fillWithZero;
    notifier.notifyBoolean(StaticImage.FeatureIDs.FILL_WITH_ZERO, false, false, oldValue, fillWithZero);
  }

  @Override
  public ByteBuffer fillWith() {
    return fillWith;
  }

  @Override
  public void fillWith(final ByteBuffer fillWith) {
    final var oldValue = this.fillWith;
    this.fillWith = fillWith;
    notifier.notify(StaticImage.FeatureIDs.FILL_WITH, false, false, oldValue, fillWith);
  }

  @Override
  public Vector2ic size() {
    return size;
  }

  @Override
  public void size(final Vector2ic size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notify(StaticImage.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public Group<StaticImage> lmGroup() {
    return VulkanResourceModelDefinition.Groups.STATIC_IMAGE;
  }

  @Override
  protected FeatureSetter<StaticImage> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<StaticImage> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case StaticImage.FeatureIDs.FORMAT -> 0;
      case StaticImage.FeatureIDs.USAGES -> 1;
      case StaticImage.FeatureIDs.TILING -> 2;
      case StaticImage.FeatureIDs.MIP_LEVELS -> 3;
      case StaticImage.FeatureIDs.INITIAL_LAYOUT -> 4;
      case StaticImage.FeatureIDs.NAME -> 5;
      case StaticImage.FeatureIDs.FILL_WITH_ZERO -> 6;
      case StaticImage.FeatureIDs.FILL_WITH -> 7;
      case StaticImage.FeatureIDs.SIZE -> 8;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<StaticImage> GET_MAP = new FeatureGetter.Builder<StaticImage>(FEATURE_COUNT, StaticImageImpl::featureIndexStatic).add(StaticImage.FeatureIDs.FORMAT, StaticImage::format).add(StaticImage.FeatureIDs.USAGES, StaticImage::usages).add(StaticImage.FeatureIDs.TILING, StaticImage::tiling).add(StaticImage.FeatureIDs.MIP_LEVELS, StaticImage::mipLevels).add(StaticImage.FeatureIDs.INITIAL_LAYOUT, StaticImage::initialLayout).add(StaticImage.FeatureIDs.NAME, StaticImage::name).add(StaticImage.FeatureIDs.FILL_WITH_ZERO, StaticImage::fillWithZero).add(StaticImage.FeatureIDs.FILL_WITH, StaticImage::fillWith).add(StaticImage.FeatureIDs.SIZE, StaticImage::size).build();
    private static final FeatureSetter<StaticImage> SET_MAP = new FeatureSetter.Builder<StaticImage>(FEATURE_COUNT, StaticImageImpl::featureIndexStatic).add(StaticImage.FeatureIDs.FORMAT, (object, value) -> ((StaticImageImpl) object).format((EFormat) value)).add(StaticImage.FeatureIDs.TILING, (object, value) -> ((StaticImageImpl) object).tiling((int) value)).add(StaticImage.FeatureIDs.MIP_LEVELS, (object, value) -> ((StaticImageImpl) object).mipLevels((int) value)).add(StaticImage.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((StaticImageImpl) object).initialLayout((EImageLayout) value)).add(StaticImage.FeatureIDs.FILL_WITH_ZERO, (object, value) -> ((StaticImageImpl) object).fillWithZero((boolean) value)).add(StaticImage.FeatureIDs.FILL_WITH, (object, value) -> ((StaticImageImpl) object).fillWith((ByteBuffer) value)).add(StaticImage.FeatureIDs.SIZE, (object, value) -> ((StaticImageImpl) object).size((Vector2ic) value)).build();
  }
}
