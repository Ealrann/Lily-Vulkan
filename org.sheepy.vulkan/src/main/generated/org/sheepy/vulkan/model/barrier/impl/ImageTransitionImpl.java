package org.sheepy.vulkan.model.barrier.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.barrier.BarrierModelDefinition;
import org.sheepy.vulkan.model.barrier.ImageTransition;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class ImageTransitionImpl extends FeaturedObject<ImageTransition.Features<?>> implements ImageTransition {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<ImageTransition.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EImageLayout srcLayout;
  private EImageLayout dstLayout;
  private final List<EAccess> srcAccessMask = newObservableList(ImageTransition.FeatureIDs.SRC_ACCESS_MASK, false, false);
  private final List<EAccess> dstAccessMask = newObservableList(ImageTransition.FeatureIDs.DST_ACCESS_MASK, false, false);

  public ImageTransitionImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageTransition.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public EImageLayout srcLayout() {
    return srcLayout;
  }

  @Override
  public void srcLayout(final EImageLayout srcLayout) {
    final var oldValue = this.srcLayout;
    this.srcLayout = srcLayout;
    notifier.notify(ImageTransition.FeatureIDs.SRC_LAYOUT, false, false, oldValue, srcLayout);
  }

  @Override
  public EImageLayout dstLayout() {
    return dstLayout;
  }

  @Override
  public void dstLayout(final EImageLayout dstLayout) {
    final var oldValue = this.dstLayout;
    this.dstLayout = dstLayout;
    notifier.notify(ImageTransition.FeatureIDs.DST_LAYOUT, false, false, oldValue, dstLayout);
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
  public Group<ImageTransition> lmGroup() {
    return BarrierModelDefinition.Groups.IMAGE_TRANSITION;
  }

  @Override
  protected FeatureSetter<ImageTransition> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageTransition> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageTransition.FeatureIDs.SRC_LAYOUT -> 0;
      case ImageTransition.FeatureIDs.DST_LAYOUT -> 1;
      case ImageTransition.FeatureIDs.SRC_ACCESS_MASK -> 2;
      case ImageTransition.FeatureIDs.DST_ACCESS_MASK -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageTransition> GET_MAP = new FeatureGetter.Builder<ImageTransition>(FEATURE_COUNT, ImageTransitionImpl::featureIndexStatic).add(ImageTransition.FeatureIDs.SRC_LAYOUT, ImageTransition::srcLayout).add(ImageTransition.FeatureIDs.DST_LAYOUT, ImageTransition::dstLayout).add(ImageTransition.FeatureIDs.SRC_ACCESS_MASK, ImageTransition::srcAccessMask).add(ImageTransition.FeatureIDs.DST_ACCESS_MASK, ImageTransition::dstAccessMask).build();
    private static final FeatureSetter<ImageTransition> SET_MAP = new FeatureSetter.Builder<ImageTransition>(FEATURE_COUNT, ImageTransitionImpl::featureIndexStatic).add(ImageTransition.FeatureIDs.SRC_LAYOUT, (object, value) -> ((ImageTransitionImpl) object).srcLayout((EImageLayout) value)).add(ImageTransition.FeatureIDs.DST_LAYOUT, (object, value) -> ((ImageTransitionImpl) object).dstLayout((EImageLayout) value)).build();
  }
}
