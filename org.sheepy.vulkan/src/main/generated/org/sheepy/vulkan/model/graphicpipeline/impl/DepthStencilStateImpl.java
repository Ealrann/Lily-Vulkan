package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.ECompareOp;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;

public final class DepthStencilStateImpl extends FeaturedObject<DepthStencilState.Features<?>> implements DepthStencilState {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<DepthStencilState.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private boolean depthTest;
  private boolean depthWrite;
  private boolean depthBoundTest;
  private boolean stencilTest;
  private ECompareOp depthCompareOp;
  private float minDepthBounds;
  private float maxDepthBounds;

  public DepthStencilStateImpl(final boolean depthTest, final boolean depthWrite,
      final boolean depthBoundTest, final boolean stencilTest, final ECompareOp depthCompareOp,
      final float minDepthBounds, final float maxDepthBounds) {
    this.depthTest = depthTest;
    this.depthWrite = depthWrite;
    this.depthBoundTest = depthBoundTest;
    this.stencilTest = stencilTest;
    this.depthCompareOp = depthCompareOp;
    this.minDepthBounds = minDepthBounds;
    this.maxDepthBounds = maxDepthBounds;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DepthStencilState.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public boolean depthTest() {
    return depthTest;
  }

  @Override
  public void depthTest(final boolean depthTest) {
    final var oldValue = this.depthTest;
    this.depthTest = depthTest;
    notifier.notifyBoolean(DepthStencilState.FeatureIDs.DEPTH_TEST, false, false, oldValue, depthTest);
  }

  @Override
  public boolean depthWrite() {
    return depthWrite;
  }

  @Override
  public void depthWrite(final boolean depthWrite) {
    final var oldValue = this.depthWrite;
    this.depthWrite = depthWrite;
    notifier.notifyBoolean(DepthStencilState.FeatureIDs.DEPTH_WRITE, false, false, oldValue, depthWrite);
  }

  @Override
  public boolean depthBoundTest() {
    return depthBoundTest;
  }

  @Override
  public void depthBoundTest(final boolean depthBoundTest) {
    final var oldValue = this.depthBoundTest;
    this.depthBoundTest = depthBoundTest;
    notifier.notifyBoolean(DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST, false, false, oldValue, depthBoundTest);
  }

  @Override
  public boolean stencilTest() {
    return stencilTest;
  }

  @Override
  public void stencilTest(final boolean stencilTest) {
    final var oldValue = this.stencilTest;
    this.stencilTest = stencilTest;
    notifier.notifyBoolean(DepthStencilState.FeatureIDs.STENCIL_TEST, false, false, oldValue, stencilTest);
  }

  @Override
  public ECompareOp depthCompareOp() {
    return depthCompareOp;
  }

  @Override
  public void depthCompareOp(final ECompareOp depthCompareOp) {
    final var oldValue = this.depthCompareOp;
    this.depthCompareOp = depthCompareOp;
    notifier.notify(DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP, false, false, oldValue, depthCompareOp);
  }

  @Override
  public float minDepthBounds() {
    return minDepthBounds;
  }

  @Override
  public void minDepthBounds(final float minDepthBounds) {
    final var oldValue = this.minDepthBounds;
    this.minDepthBounds = minDepthBounds;
    notifier.notifyFloat(DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS, false, false, oldValue, minDepthBounds);
  }

  @Override
  public float maxDepthBounds() {
    return maxDepthBounds;
  }

  @Override
  public void maxDepthBounds(final float maxDepthBounds) {
    final var oldValue = this.maxDepthBounds;
    this.maxDepthBounds = maxDepthBounds;
    notifier.notifyFloat(DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS, false, false, oldValue, maxDepthBounds);
  }

  @Override
  public Group<DepthStencilState> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.DEPTH_STENCIL_STATE;
  }

  @Override
  protected FeatureSetter<DepthStencilState> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DepthStencilState> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DepthStencilState.FeatureIDs.DEPTH_TEST -> 0;
      case DepthStencilState.FeatureIDs.DEPTH_WRITE -> 1;
      case DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST -> 2;
      case DepthStencilState.FeatureIDs.STENCIL_TEST -> 3;
      case DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP -> 4;
      case DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS -> 5;
      case DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DepthStencilState> GET_MAP = new FeatureGetter.Builder<DepthStencilState>(FEATURE_COUNT, DepthStencilStateImpl::featureIndexStatic).add(DepthStencilState.FeatureIDs.DEPTH_TEST, DepthStencilState::depthTest).add(DepthStencilState.FeatureIDs.DEPTH_WRITE, DepthStencilState::depthWrite).add(DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST, DepthStencilState::depthBoundTest).add(DepthStencilState.FeatureIDs.STENCIL_TEST, DepthStencilState::stencilTest).add(DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP, DepthStencilState::depthCompareOp).add(DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS, DepthStencilState::minDepthBounds).add(DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS, DepthStencilState::maxDepthBounds).build();
    private static final FeatureSetter<DepthStencilState> SET_MAP = new FeatureSetter.Builder<DepthStencilState>(FEATURE_COUNT, DepthStencilStateImpl::featureIndexStatic).add(DepthStencilState.FeatureIDs.DEPTH_TEST, (object, value) -> ((DepthStencilStateImpl) object).depthTest((boolean) value)).add(DepthStencilState.FeatureIDs.DEPTH_WRITE, (object, value) -> ((DepthStencilStateImpl) object).depthWrite((boolean) value)).add(DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST, (object, value) -> ((DepthStencilStateImpl) object).depthBoundTest((boolean) value)).add(DepthStencilState.FeatureIDs.STENCIL_TEST, (object, value) -> ((DepthStencilStateImpl) object).stencilTest((boolean) value)).add(DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP, (object, value) -> ((DepthStencilStateImpl) object).depthCompareOp((ECompareOp) value)).add(DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS, (object, value) -> ((DepthStencilStateImpl) object).minDepthBounds((float) value)).add(DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS, (object, value) -> ((DepthStencilStateImpl) object).maxDepthBounds((float) value)).build();
  }
}
