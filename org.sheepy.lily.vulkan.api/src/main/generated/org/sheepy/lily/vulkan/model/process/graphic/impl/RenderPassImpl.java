package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;

public final class RenderPassImpl extends FeaturedObject<RenderPass.Features<?>> implements RenderPass {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<RenderPass.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ExtraAttachment> attachments = newObservableList(RenderPass.FeatureIDs.ATTACHMENTS, true, false);

  public RenderPassImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<RenderPass.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ExtraAttachment> attachments() {
    return attachments;
  }

  @Override
  public Group<RenderPass> lmGroup() {
    return GraphicModelDefinition.Groups.RENDER_PASS;
  }

  @Override
  protected FeatureSetter<RenderPass> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<RenderPass> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case RenderPass.FeatureIDs.ATTACHMENTS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<RenderPass> GET_MAP = new FeatureGetter.Builder<RenderPass>(FEATURE_COUNT, RenderPassImpl::featureIndexStatic).add(RenderPass.FeatureIDs.ATTACHMENTS, RenderPass::attachments).build();
    private static final FeatureSetter<RenderPass> SET_MAP = new FeatureSetter.Builder<RenderPass>(FEATURE_COUNT, RenderPassImpl::featureIndexStatic).build();
  }
}
