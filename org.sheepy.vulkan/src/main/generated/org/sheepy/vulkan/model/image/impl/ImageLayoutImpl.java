package org.sheepy.vulkan.model.image.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageLayout;
import org.sheepy.vulkan.model.image.ImageModelDefinition;

public final class ImageLayoutImpl extends FeaturedObject<ImageLayout.Features<?>> implements ImageLayout {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<ImageLayout.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EPipelineStage stage;
  private EImageLayout layout;
  private final List<EAccess> accessMask = newObservableList(ImageLayout.FeatureIDs.ACCESS_MASK, false, false);

  public ImageLayoutImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageLayout.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public EPipelineStage stage() {
    return stage;
  }

  @Override
  public void stage(final EPipelineStage stage) {
    final var oldValue = this.stage;
    this.stage = stage;
    notifier.notify(ImageLayout.FeatureIDs.STAGE, false, false, oldValue, stage);
  }

  @Override
  public EImageLayout layout() {
    return layout;
  }

  @Override
  public void layout(final EImageLayout layout) {
    final var oldValue = this.layout;
    this.layout = layout;
    notifier.notify(ImageLayout.FeatureIDs.LAYOUT, false, false, oldValue, layout);
  }

  @Override
  public List<EAccess> accessMask() {
    return accessMask;
  }

  @Override
  public Group<ImageLayout> lmGroup() {
    return ImageModelDefinition.Groups.IMAGE_LAYOUT;
  }

  @Override
  protected FeatureSetter<ImageLayout> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageLayout> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageLayout.FeatureIDs.STAGE -> 0;
      case ImageLayout.FeatureIDs.LAYOUT -> 1;
      case ImageLayout.FeatureIDs.ACCESS_MASK -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageLayout> GET_MAP = new FeatureGetter.Builder<ImageLayout>(FEATURE_COUNT, ImageLayoutImpl::featureIndexStatic).add(ImageLayout.FeatureIDs.STAGE, ImageLayout::stage).add(ImageLayout.FeatureIDs.LAYOUT, ImageLayout::layout).add(ImageLayout.FeatureIDs.ACCESS_MASK, ImageLayout::accessMask).build();
    private static final FeatureSetter<ImageLayout> SET_MAP = new FeatureSetter.Builder<ImageLayout>(FEATURE_COUNT, ImageLayoutImpl::featureIndexStatic).add(ImageLayout.FeatureIDs.STAGE, (object, value) -> ((ImageLayoutImpl) object).stage((EPipelineStage) value)).add(ImageLayout.FeatureIDs.LAYOUT, (object, value) -> ((ImageLayoutImpl) object).layout((EImageLayout) value)).build();
  }
}
