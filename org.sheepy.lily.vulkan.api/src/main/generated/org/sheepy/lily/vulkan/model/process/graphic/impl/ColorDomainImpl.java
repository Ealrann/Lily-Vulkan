package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.vulkan.model.enumeration.EColorSpace;
import org.sheepy.vulkan.model.enumeration.EFormat;

public final class ColorDomainImpl extends FeaturedObject<ColorDomain.Features<?>> implements ColorDomain {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<ColorDomain.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EFormat format;
  private EColorSpace colorSpace;

  public ColorDomainImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ColorDomain.Features<?>> notifier() {
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
    notifier.notify(ColorDomain.FeatureIDs.FORMAT, false, false, oldValue, format);
  }

  @Override
  public EColorSpace colorSpace() {
    return colorSpace;
  }

  @Override
  public void colorSpace(final EColorSpace colorSpace) {
    final var oldValue = this.colorSpace;
    this.colorSpace = colorSpace;
    notifier.notify(ColorDomain.FeatureIDs.COLOR_SPACE, false, false, oldValue, colorSpace);
  }

  @Override
  public Group<ColorDomain> lmGroup() {
    return GraphicModelDefinition.Groups.COLOR_DOMAIN;
  }

  @Override
  protected FeatureSetter<ColorDomain> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ColorDomain> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ColorDomain.FeatureIDs.FORMAT -> 0;
      case ColorDomain.FeatureIDs.COLOR_SPACE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ColorDomain> GET_MAP = new FeatureGetter.Builder<ColorDomain>(FEATURE_COUNT, ColorDomainImpl::featureIndexStatic).add(ColorDomain.FeatureIDs.FORMAT, ColorDomain::format).add(ColorDomain.FeatureIDs.COLOR_SPACE, ColorDomain::colorSpace).build();
    private static final FeatureSetter<ColorDomain> SET_MAP = new FeatureSetter.Builder<ColorDomain>(FEATURE_COUNT, ColorDomainImpl::featureIndexStatic).add(ColorDomain.FeatureIDs.FORMAT, (object, value) -> ((ColorDomainImpl) object).format((EFormat) value)).add(ColorDomain.FeatureIDs.COLOR_SPACE, (object, value) -> ((ColorDomainImpl) object).colorSpace((EColorSpace) value)).build();
  }
}
