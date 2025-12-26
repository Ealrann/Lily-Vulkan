package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class AttachmentPkgImpl extends FeaturedObject<AttachmentPkg.Features<?>> implements AttachmentPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<AttachmentPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ExtraAttachment> extraAttachments = newObservableList(AttachmentPkg.FeatureIDs.EXTRA_ATTACHMENTS, true, true);

  public AttachmentPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<AttachmentPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ExtraAttachment> extraAttachments() {
    return extraAttachments;
  }

  @Override
  public Group<AttachmentPkg> lmGroup() {
    return GraphicModelDefinition.Groups.ATTACHMENT_PKG;
  }

  @Override
  protected FeatureSetter<AttachmentPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<AttachmentPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case AttachmentPkg.FeatureIDs.EXTRA_ATTACHMENTS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<AttachmentPkg> GET_MAP = new FeatureGetter.Builder<AttachmentPkg>(FEATURE_COUNT, AttachmentPkgImpl::featureIndexStatic).add(AttachmentPkg.FeatureIDs.EXTRA_ATTACHMENTS, AttachmentPkg::extraAttachments).build();
    private static final FeatureSetter<AttachmentPkg> SET_MAP = new FeatureSetter.Builder<AttachmentPkg>(FEATURE_COUNT, AttachmentPkgImpl::featureIndexStatic).build();
  }
}
