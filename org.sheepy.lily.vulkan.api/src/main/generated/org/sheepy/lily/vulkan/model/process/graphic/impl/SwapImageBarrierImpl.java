package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class SwapImageBarrierImpl extends FeaturedObject<SwapImageBarrier.Features<?>> implements SwapImageBarrier {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<SwapImageBarrier.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<EAccess> srcAccessMask = newObservableList(Barrier.FeatureIDs.SRC_ACCESS_MASK, false, false);
  private final List<EAccess> dstAccessMask = newObservableList(Barrier.FeatureIDs.DST_ACCESS_MASK, false, false);
  private EImageLayout srcLayout;
  private EImageLayout dstLayout;

  public SwapImageBarrierImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SwapImageBarrier.Features<?>> notifier() {
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
  public Group<SwapImageBarrier> lmGroup() {
    return GraphicModelDefinition.Groups.SWAP_IMAGE_BARRIER;
  }

  @Override
  protected FeatureSetter<SwapImageBarrier> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SwapImageBarrier> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SwapImageBarrier.FeatureIDs.NAME -> 0;
      case SwapImageBarrier.FeatureIDs.SRC_ACCESS_MASK -> 1;
      case SwapImageBarrier.FeatureIDs.DST_ACCESS_MASK -> 2;
      case SwapImageBarrier.FeatureIDs.SRC_LAYOUT -> 3;
      case SwapImageBarrier.FeatureIDs.DST_LAYOUT -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SwapImageBarrier> GET_MAP = new FeatureGetter.Builder<SwapImageBarrier>(FEATURE_COUNT, SwapImageBarrierImpl::featureIndexStatic).add(SwapImageBarrier.FeatureIDs.NAME, SwapImageBarrier::name).add(SwapImageBarrier.FeatureIDs.SRC_ACCESS_MASK, SwapImageBarrier::srcAccessMask).add(SwapImageBarrier.FeatureIDs.DST_ACCESS_MASK, SwapImageBarrier::dstAccessMask).add(SwapImageBarrier.FeatureIDs.SRC_LAYOUT, SwapImageBarrier::srcLayout).add(SwapImageBarrier.FeatureIDs.DST_LAYOUT, SwapImageBarrier::dstLayout).build();
    private static final FeatureSetter<SwapImageBarrier> SET_MAP = new FeatureSetter.Builder<SwapImageBarrier>(FEATURE_COUNT, SwapImageBarrierImpl::featureIndexStatic).add(SwapImageBarrier.FeatureIDs.SRC_LAYOUT, (object, value) -> ((SwapImageBarrierImpl) object).srcLayout((EImageLayout) value)).add(SwapImageBarrier.FeatureIDs.DST_LAYOUT, (object, value) -> ((SwapImageBarrierImpl) object).dstLayout((EImageLayout) value)).build();
  }
}
