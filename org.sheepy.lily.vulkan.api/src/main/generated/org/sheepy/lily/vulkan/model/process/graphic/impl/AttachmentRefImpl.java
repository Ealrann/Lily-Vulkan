package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class AttachmentRefImpl extends FeaturedObject<AttachmentRef.Features<?>> implements AttachmentRef {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<AttachmentRef.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Attachment attachment;
  private EImageLayout layout;
  private EAttachmentType type;

  public AttachmentRefImpl(final EAttachmentType type) {
    this.type = type;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<AttachmentRef.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Attachment attachment() {
    return attachment;
  }

  @Override
  public void attachment(final Attachment attachment) {
    final var oldValue = this.attachment;
    final var eventType = attachment == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.attachment = attachment;
    notifier.notify(AttachmentRef.FeatureIDs.ATTACHMENT, false, false, eventType, oldValue, attachment);
  }

  @Override
  public EImageLayout layout() {
    return layout;
  }

  @Override
  public void layout(final EImageLayout layout) {
    final var oldValue = this.layout;
    this.layout = layout;
    notifier.notify(AttachmentRef.FeatureIDs.LAYOUT, false, false, oldValue, layout);
  }

  @Override
  public EAttachmentType type() {
    return type;
  }

  @Override
  public void type(final EAttachmentType type) {
    final var oldValue = this.type;
    this.type = type;
    notifier.notify(AttachmentRef.FeatureIDs.TYPE, false, false, oldValue, type);
  }

  @Override
  public Group<AttachmentRef> lmGroup() {
    return GraphicModelDefinition.Groups.ATTACHMENT_REF;
  }

  @Override
  protected FeatureSetter<AttachmentRef> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<AttachmentRef> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case AttachmentRef.FeatureIDs.ATTACHMENT -> 0;
      case AttachmentRef.FeatureIDs.LAYOUT -> 1;
      case AttachmentRef.FeatureIDs.TYPE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<AttachmentRef> GET_MAP = new FeatureGetter.Builder<AttachmentRef>(FEATURE_COUNT, AttachmentRefImpl::featureIndexStatic).add(AttachmentRef.FeatureIDs.ATTACHMENT, AttachmentRef::attachment).add(AttachmentRef.FeatureIDs.LAYOUT, AttachmentRef::layout).add(AttachmentRef.FeatureIDs.TYPE, AttachmentRef::type).build();
    private static final FeatureSetter<AttachmentRef> SET_MAP = new FeatureSetter.Builder<AttachmentRef>(FEATURE_COUNT, AttachmentRefImpl::featureIndexStatic).add(AttachmentRef.FeatureIDs.ATTACHMENT, (object, value) -> ((AttachmentRefImpl) object).attachment((Attachment) value)).add(AttachmentRef.FeatureIDs.LAYOUT, (object, value) -> ((AttachmentRefImpl) object).layout((EImageLayout) value)).add(AttachmentRef.FeatureIDs.TYPE, (object, value) -> ((AttachmentRefImpl) object).type((EAttachmentType) value)).build();
  }
}
