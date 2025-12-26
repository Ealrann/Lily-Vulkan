package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.joml.Vector4fc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class ImageAttachmentImpl extends FeaturedObject<ImageAttachment.Features<?>> implements ImageAttachment {
  private static final int FEATURE_COUNT = 10;
  private final ModelNotifier<ImageAttachment.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ESampleCount samples;
  private EAttachmentLoadOp loadOp;
  private EAttachmentStoreOp storeOp;
  private EAttachmentLoadOp stencilLoadOp;
  private EAttachmentStoreOp stencilStoreOp;
  private EImageLayout initialLayout;
  private EImageLayout finalLayout;
  private Vector4fc clearValue;
  private VulkanEngine imageRef;

  public ImageAttachmentImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageAttachment.Features<?>> notifier() {
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
    notifier.notify(ImageAttachment.FeatureIDs.CLEAR_VALUE, false, false, oldValue, clearValue);
  }

  @Override
  public VulkanEngine imageRef() {
    return imageRef;
  }

  @Override
  public void imageRef(final VulkanEngine imageRef) {
    final var oldValue = this.imageRef;
    final var eventType = imageRef == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.imageRef = imageRef;
    notifier.notify(ImageAttachment.FeatureIDs.IMAGE_REF, false, false, eventType, oldValue, imageRef);
  }

  @Override
  public Group<ImageAttachment> lmGroup() {
    return GraphicModelDefinition.Groups.IMAGE_ATTACHMENT;
  }

  @Override
  protected FeatureSetter<ImageAttachment> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageAttachment> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageAttachment.FeatureIDs.NAME -> 0;
      case ImageAttachment.FeatureIDs.SAMPLES -> 1;
      case ImageAttachment.FeatureIDs.LOAD_OP -> 2;
      case ImageAttachment.FeatureIDs.STORE_OP -> 3;
      case ImageAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
      case ImageAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
      case ImageAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
      case ImageAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
      case ImageAttachment.FeatureIDs.CLEAR_VALUE -> 8;
      case ImageAttachment.FeatureIDs.IMAGE_REF -> 9;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageAttachment> GET_MAP = new FeatureGetter.Builder<ImageAttachment>(FEATURE_COUNT, ImageAttachmentImpl::featureIndexStatic).add(ImageAttachment.FeatureIDs.NAME, ImageAttachment::name).add(ImageAttachment.FeatureIDs.SAMPLES, ImageAttachment::samples).add(ImageAttachment.FeatureIDs.LOAD_OP, ImageAttachment::loadOp).add(ImageAttachment.FeatureIDs.STORE_OP, ImageAttachment::storeOp).add(ImageAttachment.FeatureIDs.STENCIL_LOAD_OP, ImageAttachment::stencilLoadOp).add(ImageAttachment.FeatureIDs.STENCIL_STORE_OP, ImageAttachment::stencilStoreOp).add(ImageAttachment.FeatureIDs.INITIAL_LAYOUT, ImageAttachment::initialLayout).add(ImageAttachment.FeatureIDs.FINAL_LAYOUT, ImageAttachment::finalLayout).add(ImageAttachment.FeatureIDs.CLEAR_VALUE, ImageAttachment::clearValue).add(ImageAttachment.FeatureIDs.IMAGE_REF, ImageAttachment::imageRef).build();
    private static final FeatureSetter<ImageAttachment> SET_MAP = new FeatureSetter.Builder<ImageAttachment>(FEATURE_COUNT, ImageAttachmentImpl::featureIndexStatic).add(ImageAttachment.FeatureIDs.SAMPLES, (object, value) -> ((ImageAttachmentImpl) object).samples((ESampleCount) value)).add(ImageAttachment.FeatureIDs.LOAD_OP, (object, value) -> ((ImageAttachmentImpl) object).loadOp((EAttachmentLoadOp) value)).add(ImageAttachment.FeatureIDs.STORE_OP, (object, value) -> ((ImageAttachmentImpl) object).storeOp((EAttachmentStoreOp) value)).add(ImageAttachment.FeatureIDs.STENCIL_LOAD_OP, (object, value) -> ((ImageAttachmentImpl) object).stencilLoadOp((EAttachmentLoadOp) value)).add(ImageAttachment.FeatureIDs.STENCIL_STORE_OP, (object, value) -> ((ImageAttachmentImpl) object).stencilStoreOp((EAttachmentStoreOp) value)).add(ImageAttachment.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((ImageAttachmentImpl) object).initialLayout((EImageLayout) value)).add(ImageAttachment.FeatureIDs.FINAL_LAYOUT, (object, value) -> ((ImageAttachmentImpl) object).finalLayout((EImageLayout) value)).add(ImageAttachment.FeatureIDs.CLEAR_VALUE, (object, value) -> ((ImageAttachmentImpl) object).clearValue((Vector4fc) value)).add(ImageAttachment.FeatureIDs.IMAGE_REF, (object, value) -> ((ImageAttachmentImpl) object).imageRef((VulkanEngine) value)).build();
  }
}
