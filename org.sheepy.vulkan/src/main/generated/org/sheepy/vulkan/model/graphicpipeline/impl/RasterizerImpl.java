package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPolygonMode;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;

public final class RasterizerImpl extends FeaturedObject<Rasterizer.Features<?>> implements Rasterizer {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<Rasterizer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private ECullMode cullMode;
  private EFrontFace frontFace;
  private EPolygonMode polygonMode;
  private int lineWidth;
  private boolean depthClampEnable;
  private boolean discardEnable;
  private boolean depthBiasEnable;

  public RasterizerImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Rasterizer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public ECullMode cullMode() {
    return cullMode;
  }

  @Override
  public void cullMode(final ECullMode cullMode) {
    final var oldValue = this.cullMode;
    this.cullMode = cullMode;
    notifier.notify(Rasterizer.FeatureIDs.CULL_MODE, false, false, oldValue, cullMode);
  }

  @Override
  public EFrontFace frontFace() {
    return frontFace;
  }

  @Override
  public void frontFace(final EFrontFace frontFace) {
    final var oldValue = this.frontFace;
    this.frontFace = frontFace;
    notifier.notify(Rasterizer.FeatureIDs.FRONT_FACE, false, false, oldValue, frontFace);
  }

  @Override
  public EPolygonMode polygonMode() {
    return polygonMode;
  }

  @Override
  public void polygonMode(final EPolygonMode polygonMode) {
    final var oldValue = this.polygonMode;
    this.polygonMode = polygonMode;
    notifier.notify(Rasterizer.FeatureIDs.POLYGON_MODE, false, false, oldValue, polygonMode);
  }

  @Override
  public int lineWidth() {
    return lineWidth;
  }

  @Override
  public void lineWidth(final int lineWidth) {
    final var oldValue = this.lineWidth;
    this.lineWidth = lineWidth;
    notifier.notifyInt(Rasterizer.FeatureIDs.LINE_WIDTH, false, false, oldValue, lineWidth);
  }

  @Override
  public boolean depthClampEnable() {
    return depthClampEnable;
  }

  @Override
  public void depthClampEnable(final boolean depthClampEnable) {
    final var oldValue = this.depthClampEnable;
    this.depthClampEnable = depthClampEnable;
    notifier.notifyBoolean(Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE, false, false, oldValue, depthClampEnable);
  }

  @Override
  public boolean discardEnable() {
    return discardEnable;
  }

  @Override
  public void discardEnable(final boolean discardEnable) {
    final var oldValue = this.discardEnable;
    this.discardEnable = discardEnable;
    notifier.notifyBoolean(Rasterizer.FeatureIDs.DISCARD_ENABLE, false, false, oldValue, discardEnable);
  }

  @Override
  public boolean depthBiasEnable() {
    return depthBiasEnable;
  }

  @Override
  public void depthBiasEnable(final boolean depthBiasEnable) {
    final var oldValue = this.depthBiasEnable;
    this.depthBiasEnable = depthBiasEnable;
    notifier.notifyBoolean(Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE, false, false, oldValue, depthBiasEnable);
  }

  @Override
  public Group<Rasterizer> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.RASTERIZER;
  }

  @Override
  protected FeatureSetter<Rasterizer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Rasterizer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Rasterizer.FeatureIDs.CULL_MODE -> 0;
      case Rasterizer.FeatureIDs.FRONT_FACE -> 1;
      case Rasterizer.FeatureIDs.POLYGON_MODE -> 2;
      case Rasterizer.FeatureIDs.LINE_WIDTH -> 3;
      case Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE -> 4;
      case Rasterizer.FeatureIDs.DISCARD_ENABLE -> 5;
      case Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Rasterizer> GET_MAP = new FeatureGetter.Builder<Rasterizer>(FEATURE_COUNT, RasterizerImpl::featureIndexStatic).add(Rasterizer.FeatureIDs.CULL_MODE, Rasterizer::cullMode).add(Rasterizer.FeatureIDs.FRONT_FACE, Rasterizer::frontFace).add(Rasterizer.FeatureIDs.POLYGON_MODE, Rasterizer::polygonMode).add(Rasterizer.FeatureIDs.LINE_WIDTH, Rasterizer::lineWidth).add(Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE, Rasterizer::depthClampEnable).add(Rasterizer.FeatureIDs.DISCARD_ENABLE, Rasterizer::discardEnable).add(Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE, Rasterizer::depthBiasEnable).build();
    private static final FeatureSetter<Rasterizer> SET_MAP = new FeatureSetter.Builder<Rasterizer>(FEATURE_COUNT, RasterizerImpl::featureIndexStatic).add(Rasterizer.FeatureIDs.CULL_MODE, (object, value) -> ((RasterizerImpl) object).cullMode((ECullMode) value)).add(Rasterizer.FeatureIDs.FRONT_FACE, (object, value) -> ((RasterizerImpl) object).frontFace((EFrontFace) value)).add(Rasterizer.FeatureIDs.POLYGON_MODE, (object, value) -> ((RasterizerImpl) object).polygonMode((EPolygonMode) value)).add(Rasterizer.FeatureIDs.LINE_WIDTH, (object, value) -> ((RasterizerImpl) object).lineWidth((int) value)).add(Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE, (object, value) -> ((RasterizerImpl) object).depthClampEnable((boolean) value)).add(Rasterizer.FeatureIDs.DISCARD_ENABLE, (object, value) -> ((RasterizerImpl) object).discardEnable((boolean) value)).add(Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE, (object, value) -> ((RasterizerImpl) object).depthBiasEnable((boolean) value)).build();
  }
}
