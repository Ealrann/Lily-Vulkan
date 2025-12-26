package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;

public final class SetScissorImpl extends FeaturedObject<SetScissor.Features<?>> implements SetScissor {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<SetScissor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private int offsetX;
  private int offsetY;
  private int width;
  private int height;

  public SetScissorImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SetScissor.Features<?>> notifier() {
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
  public int offsetX() {
    return offsetX;
  }

  @Override
  public void offsetX(final int offsetX) {
    final var oldValue = this.offsetX;
    this.offsetX = offsetX;
    notifier.notifyInt(SetScissor.FeatureIDs.OFFSETX, false, false, oldValue, offsetX);
  }

  @Override
  public int offsetY() {
    return offsetY;
  }

  @Override
  public void offsetY(final int offsetY) {
    final var oldValue = this.offsetY;
    this.offsetY = offsetY;
    notifier.notifyInt(SetScissor.FeatureIDs.OFFSETY, false, false, oldValue, offsetY);
  }

  @Override
  public int width() {
    return width;
  }

  @Override
  public void width(final int width) {
    final var oldValue = this.width;
    this.width = width;
    notifier.notifyInt(SetScissor.FeatureIDs.WIDTH, false, false, oldValue, width);
  }

  @Override
  public int height() {
    return height;
  }

  @Override
  public void height(final int height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyInt(SetScissor.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public Group<SetScissor> lmGroup() {
    return GraphicModelDefinition.Groups.SET_SCISSOR;
  }

  @Override
  protected FeatureSetter<SetScissor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SetScissor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SetScissor.FeatureIDs.NAME -> 0;
      case SetScissor.FeatureIDs.ENABLED -> 1;
      case SetScissor.FeatureIDs.OFFSETX -> 2;
      case SetScissor.FeatureIDs.OFFSETY -> 3;
      case SetScissor.FeatureIDs.WIDTH -> 4;
      case SetScissor.FeatureIDs.HEIGHT -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SetScissor> GET_MAP = new FeatureGetter.Builder<SetScissor>(FEATURE_COUNT, SetScissorImpl::featureIndexStatic).add(SetScissor.FeatureIDs.NAME, SetScissor::name).add(SetScissor.FeatureIDs.ENABLED, SetScissor::enabled).add(SetScissor.FeatureIDs.OFFSETX, SetScissor::offsetX).add(SetScissor.FeatureIDs.OFFSETY, SetScissor::offsetY).add(SetScissor.FeatureIDs.WIDTH, SetScissor::width).add(SetScissor.FeatureIDs.HEIGHT, SetScissor::height).build();
    private static final FeatureSetter<SetScissor> SET_MAP = new FeatureSetter.Builder<SetScissor>(FEATURE_COUNT, SetScissorImpl::featureIndexStatic).add(SetScissor.FeatureIDs.ENABLED, (object, value) -> ((SetScissorImpl) object).enabled((boolean) value)).add(SetScissor.FeatureIDs.OFFSETX, (object, value) -> ((SetScissorImpl) object).offsetX((int) value)).add(SetScissor.FeatureIDs.OFFSETY, (object, value) -> ((SetScissorImpl) object).offsetY((int) value)).add(SetScissor.FeatureIDs.WIDTH, (object, value) -> ((SetScissorImpl) object).width((int) value)).add(SetScissor.FeatureIDs.HEIGHT, (object, value) -> ((SetScissorImpl) object).height((int) value)).build();
  }
}
