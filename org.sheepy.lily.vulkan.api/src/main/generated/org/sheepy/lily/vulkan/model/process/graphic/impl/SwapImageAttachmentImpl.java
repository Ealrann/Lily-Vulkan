package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.joml.Vector4fc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class SwapImageAttachmentImpl extends FeaturedObject<SwapImageAttachment.Features<?>> implements SwapImageAttachment {
  private static final int FEATURE_COUNT = 9;
  private final ModelNotifier<SwapImageAttachment.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ESampleCount samples;
  private EAttachmentLoadOp loadOp;
  private EAttachmentStoreOp storeOp;
  private EAttachmentLoadOp stencilLoadOp;
  private EAttachmentStoreOp stencilStoreOp;
  private EImageLayout initialLayout;
  private EImageLayout finalLayout;
  private Vector4fc clearValue;

  public SwapImageAttachmentImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SwapImageAttachment.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public ESampleCount samples() {
    return samples;
  }

  @Override
  public void samples(final ESampleCount samples) {
    final var oldValue = this.samples;
    this.samples = samples;
    notifier.notify(Attachment.FeatureIDs.SAMPLES, false, false, oldValue, samples);
  }

  @Override
  public EAttachmentLoadOp loadOp() {
    return loadOp;
  }

  @Override
  public void loadOp(final EAttachmentLoadOp loadOp) {
    final var oldValue = this.loadOp;
    this.loadOp = loadOp;
    notifier.notify(Attachment.FeatureIDs.LOAD_OP, false, false, oldValue, loadOp);
  }

  @Override
  public EAttachmentStoreOp storeOp() {
    return storeOp;
  }

  @Override
  public void storeOp(final EAttachmentStoreOp storeOp) {
    final var oldValue = this.storeOp;
    this.storeOp = storeOp;
    notifier.notify(Attachment.FeatureIDs.STORE_OP, false, false, oldValue, storeOp);
  }

  @Override
  public EAttachmentLoadOp stencilLoadOp() {
    return stencilLoadOp;
  }

  @Override
  public void stencilLoadOp(final EAttachmentLoadOp stencilLoadOp) {
    final var oldValue = this.stencilLoadOp;
    this.stencilLoadOp = stencilLoadOp;
    notifier.notify(Attachment.FeatureIDs.STENCIL_LOAD_OP, false, false, oldValue, stencilLoadOp);
  }

  @Override
  public EAttachmentStoreOp stencilStoreOp() {
    return stencilStoreOp;
  }

  @Override
  public void stencilStoreOp(final EAttachmentStoreOp stencilStoreOp) {
    final var oldValue = this.stencilStoreOp;
    this.stencilStoreOp = stencilStoreOp;
    notifier.notify(Attachment.FeatureIDs.STENCIL_STORE_OP, false, false, oldValue, stencilStoreOp);
  }

  @Override
  public EImageLayout initialLayout() {
    return initialLayout;
  }

  @Override
  public void initialLayout(final EImageLayout initialLayout) {
    final var oldValue = this.initialLayout;
    this.initialLayout = initialLayout;
    notifier.notify(Attachment.FeatureIDs.INITIAL_LAYOUT, false, false, oldValue, initialLayout);
  }

  @Override
  public EImageLayout finalLayout() {
    return finalLayout;
  }

  @Override
  public void finalLayout(final EImageLayout finalLayout) {
    final var oldValue = this.finalLayout;
    this.finalLayout = finalLayout;
    notifier.notify(Attachment.FeatureIDs.FINAL_LAYOUT, false, false, oldValue, finalLayout);
  }

  @Override
  public Vector4fc clearValue() {
    return clearValue;
  }

  @Override
  public void clearValue(final Vector4fc clearValue) {
    final var oldValue = this.clearValue;
    this.clearValue = clearValue;
    notifier.notify(SwapImageAttachment.FeatureIDs.CLEAR_VALUE, false, false, oldValue, clearValue);
  }

  @Override
  public Group<SwapImageAttachment> lmGroup() {
    return GraphicModelDefinition.Groups.SWAP_IMAGE_ATTACHMENT;
  }

  @Override
  protected FeatureSetter<SwapImageAttachment> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SwapImageAttachment> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SwapImageAttachment.FeatureIDs.NAME -> 0;
      case SwapImageAttachment.FeatureIDs.SAMPLES -> 1;
      case SwapImageAttachment.FeatureIDs.LOAD_OP -> 2;
      case SwapImageAttachment.FeatureIDs.STORE_OP -> 3;
      case SwapImageAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
      case SwapImageAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
      case SwapImageAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
      case SwapImageAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
      case SwapImageAttachment.FeatureIDs.CLEAR_VALUE -> 8;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SwapImageAttachment> GET_MAP = new FeatureGetter.Builder<SwapImageAttachment>(FEATURE_COUNT, SwapImageAttachmentImpl::featureIndexStatic).add(SwapImageAttachment.FeatureIDs.NAME, SwapImageAttachment::name).add(SwapImageAttachment.FeatureIDs.SAMPLES, SwapImageAttachment::samples).add(SwapImageAttachment.FeatureIDs.LOAD_OP, SwapImageAttachment::loadOp).add(SwapImageAttachment.FeatureIDs.STORE_OP, SwapImageAttachment::storeOp).add(SwapImageAttachment.FeatureIDs.STENCIL_LOAD_OP, SwapImageAttachment::stencilLoadOp).add(SwapImageAttachment.FeatureIDs.STENCIL_STORE_OP, SwapImageAttachment::stencilStoreOp).add(SwapImageAttachment.FeatureIDs.INITIAL_LAYOUT, SwapImageAttachment::initialLayout).add(SwapImageAttachment.FeatureIDs.FINAL_LAYOUT, SwapImageAttachment::finalLayout).add(SwapImageAttachment.FeatureIDs.CLEAR_VALUE, SwapImageAttachment::clearValue).build();
    private static final FeatureSetter<SwapImageAttachment> SET_MAP = new FeatureSetter.Builder<SwapImageAttachment>(FEATURE_COUNT, SwapImageAttachmentImpl::featureIndexStatic).add(SwapImageAttachment.FeatureIDs.SAMPLES, (object, value) -> ((SwapImageAttachmentImpl) object).samples((ESampleCount) value)).add(SwapImageAttachment.FeatureIDs.LOAD_OP, (object, value) -> ((SwapImageAttachmentImpl) object).loadOp((EAttachmentLoadOp) value)).add(SwapImageAttachment.FeatureIDs.STORE_OP, (object, value) -> ((SwapImageAttachmentImpl) object).storeOp((EAttachmentStoreOp) value)).add(SwapImageAttachment.FeatureIDs.STENCIL_LOAD_OP, (object, value) -> ((SwapImageAttachmentImpl) object).stencilLoadOp((EAttachmentLoadOp) value)).add(SwapImageAttachment.FeatureIDs.STENCIL_STORE_OP, (object, value) -> ((SwapImageAttachmentImpl) object).stencilStoreOp((EAttachmentStoreOp) value)).add(SwapImageAttachment.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((SwapImageAttachmentImpl) object).initialLayout((EImageLayout) value)).add(SwapImageAttachment.FeatureIDs.FINAL_LAYOUT, (object, value) -> ((SwapImageAttachmentImpl) object).finalLayout((EImageLayout) value)).add(SwapImageAttachment.FeatureIDs.CLEAR_VALUE, (object, value) -> ((SwapImageAttachmentImpl) object).clearValue((Vector4fc) value)).build();
  }
}
