package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;

public final class SetViewportImpl extends FeaturedObject<SetViewport.Features<?>> implements SetViewport {
  private static final int FEATURE_COUNT = 8;
  private final ModelNotifier<SetViewport.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private float x;
  private float y;
  private float width;
  private float height;
  private float minDepth;
  private float maxDepth;

  public SetViewportImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SetViewport.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IPipelineTask.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public float x() {
    return x;
  }

  @Override
  public void x(final float x) {
    final var oldValue = this.x;
    this.x = x;
    notifier.notifyFloat(SetViewport.FeatureIDs.X, false, false, oldValue, x);
  }

  @Override
  public float y() {
    return y;
  }

  @Override
  public void y(final float y) {
    final var oldValue = this.y;
    this.y = y;
    notifier.notifyFloat(SetViewport.FeatureIDs.Y, false, false, oldValue, y);
  }

  @Override
  public float width() {
    return width;
  }

  @Override
  public void width(final float width) {
    final var oldValue = this.width;
    this.width = width;
    notifier.notifyFloat(SetViewport.FeatureIDs.WIDTH, false, false, oldValue, width);
  }

  @Override
  public float height() {
    return height;
  }

  @Override
  public void height(final float height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyFloat(SetViewport.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public float minDepth() {
    return minDepth;
  }

  @Override
  public void minDepth(final float minDepth) {
    final var oldValue = this.minDepth;
    this.minDepth = minDepth;
    notifier.notifyFloat(SetViewport.FeatureIDs.MIN_DEPTH, false, false, oldValue, minDepth);
  }

  @Override
  public float maxDepth() {
    return maxDepth;
  }

  @Override
  public void maxDepth(final float maxDepth) {
    final var oldValue = this.maxDepth;
    this.maxDepth = maxDepth;
    notifier.notifyFloat(SetViewport.FeatureIDs.MAX_DEPTH, false, false, oldValue, maxDepth);
  }

  @Override
  public Group<SetViewport> lmGroup() {
    return GraphicModelDefinition.Groups.SET_VIEWPORT;
  }

  @Override
  protected FeatureSetter<SetViewport> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SetViewport> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SetViewport.FeatureIDs.NAME -> 0;
      case SetViewport.FeatureIDs.ENABLED -> 1;
      case SetViewport.FeatureIDs.X -> 2;
      case SetViewport.FeatureIDs.Y -> 3;
      case SetViewport.FeatureIDs.WIDTH -> 4;
      case SetViewport.FeatureIDs.HEIGHT -> 5;
      case SetViewport.FeatureIDs.MIN_DEPTH -> 6;
      case SetViewport.FeatureIDs.MAX_DEPTH -> 7;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SetViewport> GET_MAP = new FeatureGetter.Builder<SetViewport>(FEATURE_COUNT, SetViewportImpl::featureIndexStatic).add(SetViewport.FeatureIDs.NAME, SetViewport::name).add(SetViewport.FeatureIDs.ENABLED, SetViewport::enabled).add(SetViewport.FeatureIDs.X, SetViewport::x).add(SetViewport.FeatureIDs.Y, SetViewport::y).add(SetViewport.FeatureIDs.WIDTH, SetViewport::width).add(SetViewport.FeatureIDs.HEIGHT, SetViewport::height).add(SetViewport.FeatureIDs.MIN_DEPTH, SetViewport::minDepth).add(SetViewport.FeatureIDs.MAX_DEPTH, SetViewport::maxDepth).build();
    private static final FeatureSetter<SetViewport> SET_MAP = new FeatureSetter.Builder<SetViewport>(FEATURE_COUNT, SetViewportImpl::featureIndexStatic).add(SetViewport.FeatureIDs.ENABLED, (object, value) -> ((SetViewportImpl) object).enabled((boolean) value)).add(SetViewport.FeatureIDs.X, (object, value) -> ((SetViewportImpl) object).x((float) value)).add(SetViewport.FeatureIDs.Y, (object, value) -> ((SetViewportImpl) object).y((float) value)).add(SetViewport.FeatureIDs.WIDTH, (object, value) -> ((SetViewportImpl) object).width((float) value)).add(SetViewport.FeatureIDs.HEIGHT, (object, value) -> ((SetViewportImpl) object).height((float) value)).add(SetViewport.FeatureIDs.MIN_DEPTH, (object, value) -> ((SetViewportImpl) object).minDepth((float) value)).add(SetViewport.FeatureIDs.MAX_DEPTH, (object, value) -> ((SetViewportImpl) object).maxDepth((float) value)).build();
  }
}
