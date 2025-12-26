package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.joml.Vector4fc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class ColorAttachmentImpl extends FeaturedObject<ColorAttachment.Features<?>> implements ColorAttachment {
  private static final int FEATURE_COUNT = 11;
  private final ModelNotifier<ColorAttachment.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ESampleCount samples;
  private EAttachmentLoadOp loadOp;
  private EAttachmentStoreOp storeOp;
  private EAttachmentLoadOp stencilLoadOp;
  private EAttachmentStoreOp stencilStoreOp;
  private EImageLayout initialLayout;
  private EImageLayout finalLayout;
  private Vector4fc clearValue;
  private final List<EImageUsage> usages = newObservableList(ColorAttachment.FeatureIDs.USAGES, false, false);
  private EFormat format;

  public ColorAttachmentImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ColorAttachment.Features<?>> notifier() {
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
    notifier.notify(ColorAttachment.FeatureIDs.CLEAR_VALUE, false, false, oldValue, clearValue);
  }

  @Override
  public List<EImageUsage> usages() {
    return usages;
  }

  @Override
  public EFormat format() {
    return format;
  }

  @Override
  public void format(final EFormat format) {
    final var oldValue = this.format;
    this.format = format;
    notifier.notify(ColorAttachment.FeatureIDs.FORMAT, false, false, oldValue, format);
  }

  @Override
  public Group<ColorAttachment> lmGroup() {
    return GraphicModelDefinition.Groups.COLOR_ATTACHMENT;
  }

  @Override
  protected FeatureSetter<ColorAttachment> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ColorAttachment> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ColorAttachment.FeatureIDs.NAME -> 0;
      case ColorAttachment.FeatureIDs.SAMPLES -> 1;
      case ColorAttachment.FeatureIDs.LOAD_OP -> 2;
      case ColorAttachment.FeatureIDs.STORE_OP -> 3;
      case ColorAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
      case ColorAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
      case ColorAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
      case ColorAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
      case ColorAttachment.FeatureIDs.CLEAR_VALUE -> 8;
      case ColorAttachment.FeatureIDs.USAGES -> 9;
      case ColorAttachment.FeatureIDs.FORMAT -> 10;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ColorAttachment> GET_MAP = new FeatureGetter.Builder<ColorAttachment>(FEATURE_COUNT, ColorAttachmentImpl::featureIndexStatic).add(ColorAttachment.FeatureIDs.NAME, ColorAttachment::name).add(ColorAttachment.FeatureIDs.SAMPLES, ColorAttachment::samples).add(ColorAttachment.FeatureIDs.LOAD_OP, ColorAttachment::loadOp).add(ColorAttachment.FeatureIDs.STORE_OP, ColorAttachment::storeOp).add(ColorAttachment.FeatureIDs.STENCIL_LOAD_OP, ColorAttachment::stencilLoadOp).add(ColorAttachment.FeatureIDs.STENCIL_STORE_OP, ColorAttachment::stencilStoreOp).add(ColorAttachment.FeatureIDs.INITIAL_LAYOUT, ColorAttachment::initialLayout).add(ColorAttachment.FeatureIDs.FINAL_LAYOUT, ColorAttachment::finalLayout).add(ColorAttachment.FeatureIDs.CLEAR_VALUE, ColorAttachment::clearValue).add(ColorAttachment.FeatureIDs.USAGES, ColorAttachment::usages).add(ColorAttachment.FeatureIDs.FORMAT, ColorAttachment::format).build();
    private static final FeatureSetter<ColorAttachment> SET_MAP = new FeatureSetter.Builder<ColorAttachment>(FEATURE_COUNT, ColorAttachmentImpl::featureIndexStatic).add(ColorAttachment.FeatureIDs.SAMPLES, (object, value) -> ((ColorAttachmentImpl) object).samples((ESampleCount) value)).add(ColorAttachment.FeatureIDs.LOAD_OP, (object, value) -> ((ColorAttachmentImpl) object).loadOp((EAttachmentLoadOp) value)).add(ColorAttachment.FeatureIDs.STORE_OP, (object, value) -> ((ColorAttachmentImpl) object).storeOp((EAttachmentStoreOp) value)).add(ColorAttachment.FeatureIDs.STENCIL_LOAD_OP, (object, value) -> ((ColorAttachmentImpl) object).stencilLoadOp((EAttachmentLoadOp) value)).add(ColorAttachment.FeatureIDs.STENCIL_STORE_OP, (object, value) -> ((ColorAttachmentImpl) object).stencilStoreOp((EAttachmentStoreOp) value)).add(ColorAttachment.FeatureIDs.INITIAL_LAYOUT, (object, value) -> ((ColorAttachmentImpl) object).initialLayout((EImageLayout) value)).add(ColorAttachment.FeatureIDs.FINAL_LAYOUT, (object, value) -> ((ColorAttachmentImpl) object).finalLayout((EImageLayout) value)).add(ColorAttachment.FeatureIDs.CLEAR_VALUE, (object, value) -> ((ColorAttachmentImpl) object).clearValue((Vector4fc) value)).add(ColorAttachment.FeatureIDs.FORMAT, (object, value) -> ((ColorAttachmentImpl) object).format((EFormat) value)).build();
  }
}
