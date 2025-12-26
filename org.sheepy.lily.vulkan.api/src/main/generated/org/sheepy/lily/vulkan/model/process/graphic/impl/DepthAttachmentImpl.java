package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class DepthAttachmentImpl extends FeaturedObject<DepthAttachment.Features<?>> implements DepthAttachment {
  private static final int FEATURE_COUNT = 10;
  private final ModelNotifier<DepthAttachment.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ESampleCount samples;
  private EAttachmentLoadOp loadOp;
  private EAttachmentStoreOp storeOp;
  private EAttachmentLoadOp stencilLoadOp;
  private EAttachmentStoreOp stencilStoreOp;
  private EImageLayout initialLayout;
  private EImageLayout finalLayout;
  private boolean clear;
  private final List<EImageUsage> usages = newObservableList(DepthAttachment.FeatureIDs.USAGES, false, false);

  public DepthAttachmentImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DepthAttachment.Features<?>> notifier() {
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
  public boolean clear() {
    return clear;
  }

  @Override
  public void clear(final boolean clear) {
    final var oldValue = this.clear;
    this.clear = clear;
    notifier.notifyBoolean(DepthAttachment.FeatureIDs.CLEAR, false, false, oldValue, clear);
  }

  @Override
  public List<EImageUsage> usages() {
    return usages;
  }

  @Override
  public Group<DepthAttachment> lmGroup() {
    return GraphicModelDefinition.Groups.DEPTH_ATTACHMENT;
  }

  @Override
  protected FeatureSetter<DepthAttachment> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DepthAttachment> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DepthAttachment.FeatureIDs.NAME -> 0;
      case DepthAttachment.FeatureIDs.SAMPLES -> 1;
      case DepthAttachment.FeatureIDs.LOAD_OP -> 2;
      case DepthAttachment.FeatureIDs.STORE_OP -> 3;
      case DepthAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
      case DepthAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
      case DepthAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
      case DepthAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
      case DepthAttachment.FeatureIDs.CLEAR -> 8;
      case DepthAttachment.FeatureIDs.USAGES -> 9;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DepthAttachment> GET_MAP = new FeatureGetter.Builder<DepthAttachment>(FEATURE_COUNT, DepthAttachmentImpl::featureIndexStatic).add(DepthAttachment.FeatureIDs.NAME, DepthAttachment::name).add(DepthAttachment.FeatureIDs.SAMPLES, DepthAttachment::samples).add(DepthAttachment.FeatureIDs.LOAD_OP, DepthAttachment::loadOp).add(DepthAttachment.FeatureIDs.STORE_OP, DepthAttachment::storeOp).add(DepthAttachment.FeatureIDs.STENCIL_LOAD_OP, DepthAttachment::stencilLoadOp).add(DepthAttachment.FeatureIDs.STENCIL_STORE_OP, DepthAttachment::stencilStoreOp).add(DepthAttachment.FeatureIDs.INITIAL_LAYOUT, DepthAttachment::initialLayout).add(DepthAttachment.FeatureIDs.FINAL_LAYOUT, DepthAttachment::finalLayout).add(DepthAttachment.FeatureIDs.CLEAR, DepthAttachment::clear).add(DepthAttachment.FeatureIDs.USAGES, DepthAttachment::usages).build();
    private static final FeatureSetter<DepthAttachment> SET_MAP = new FeatureSetter.Builder<DepthAttachment>(FEATURE_COUNT, DepthAttachmentImpl::featureIndexStatic).add(DepthAttachment.FeatureIDs.SAMPLES, (object, value) -> ((DepthAttachmentImpl) object).samples((ESampleCount) value)).add(DepthAttachment.FeatureIDs.LOAD_OP, (object, value) -> ((DepthAttachmentImpl) object).loadOp((EAttachmentLoadOp) value)).add(DepthAttachment.FeatureIDs.STORE_OP, (object, value) -> ((DepthAttachmentImpl) object).storeOp((EAttachmentStoreOp) value)).add(DepthAttachment.FeatureIDs.STENCIL_LOAD_OP, (object, value) -> ((DepthAttachmentImpl) object).stencilLoadOp((EAttachmentLoadOp) value)).add(DepthAttachment.FeatureIDs.STENCIL_STORE_OP, (object, value) -> ((DepthAttachmentImpl) object).stencilStoreOp((EAttachmentStoreOp) value)).add(DepthAttachment.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((DepthAttachmentImpl) object).initialLayout((EImageLayout) value)).add(DepthAttachment.FeatureIDs.FINAL_LAYOUT, (object, value) -> ((DepthAttachmentImpl) object).finalLayout((EImageLayout) value)).add(DepthAttachment.FeatureIDs.CLEAR, (object, value) -> ((DepthAttachmentImpl) object).clear((boolean) value)).build();
  }
}
