package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class AttachmentRefPkgImpl extends FeaturedObject<AttachmentRefPkg.Features<?>> implements AttachmentRefPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<AttachmentRefPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<AttachmentRef> attachmentRefs = newObservableList(AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS, true, true);

  public AttachmentRefPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<AttachmentRefPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<AttachmentRef> attachmentRefs() {
    return attachmentRefs;
  }

  @Override
  public Group<AttachmentRefPkg> lmGroup() {
    return GraphicModelDefinition.Groups.ATTACHMENT_REF_PKG;
  }

  @Override
  protected FeatureSetter<AttachmentRefPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<AttachmentRefPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<AttachmentRefPkg> GET_MAP = new FeatureGetter.Builder<AttachmentRefPkg>(FEATURE_COUNT, AttachmentRefPkgImpl::featureIndexStatic).add(AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS, AttachmentRefPkg::attachmentRefs).build();
    private static final FeatureSetter<AttachmentRefPkg> SET_MAP = new FeatureSetter.Builder<AttachmentRefPkg>(FEATURE_COUNT, AttachmentRefPkgImpl::featureIndexStatic).build();
  }
}
