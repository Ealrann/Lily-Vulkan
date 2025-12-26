package org.sheepy.lily.vulkan.model.process.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.Submission;

public final class SubmissionImpl extends FeaturedObject<Submission.Features<?>> implements Submission {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<Submission.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public SubmissionImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Submission.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<Submission> lmGroup() {
    return ProcessModelDefinition.Groups.SUBMISSION;
  }

  @Override
  protected FeatureSetter<Submission> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Submission> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    throw new IllegalArgumentException("Unknown featureId: " + featureId);
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Submission> GET_MAP = new FeatureGetter.Builder<Submission>(FEATURE_COUNT, SubmissionImpl::featureIndexStatic).build();
    private static final FeatureSetter<Submission> SET_MAP = new FeatureSetter.Builder<Submission>(FEATURE_COUNT, SubmissionImpl::featureIndexStatic).build();
  }
}
