package org.sheepy.vulkan.model.pipeline.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.PipelineModelDefinition;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public final class PushConstantRangeImpl extends FeaturedObject<PushConstantRange.Features<?>> implements PushConstantRange {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<PushConstantRange.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<EShaderStage> stages = newObservableList(PushConstantRange.FeatureIDs.STAGES, false, false);
  private int offset;
  private int size;

  public PushConstantRangeImpl(final List<EShaderStage> stages) {
    this.stages.addAll(stages);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PushConstantRange.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<EShaderStage> stages() {
    return stages;
  }

  @Override
  public int offset() {
    return offset;
  }

  @Override
  public void offset(final int offset) {
    final var oldValue = this.offset;
    this.offset = offset;
    notifier.notifyInt(PushConstantRange.FeatureIDs.OFFSET, false, false, oldValue, offset);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void size(final int size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notifyInt(PushConstantRange.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public Group<PushConstantRange> lmGroup() {
    return PipelineModelDefinition.Groups.PUSH_CONSTANT_RANGE;
  }

  @Override
  protected FeatureSetter<PushConstantRange> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PushConstantRange> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PushConstantRange.FeatureIDs.STAGES -> 0;
      case PushConstantRange.FeatureIDs.OFFSET -> 1;
      case PushConstantRange.FeatureIDs.SIZE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PushConstantRange> GET_MAP = new FeatureGetter.Builder<PushConstantRange>(FEATURE_COUNT, PushConstantRangeImpl::featureIndexStatic).add(PushConstantRange.FeatureIDs.STAGES, PushConstantRange::stages).add(PushConstantRange.FeatureIDs.OFFSET, PushConstantRange::offset).add(PushConstantRange.FeatureIDs.SIZE, PushConstantRange::size).build();
    private static final FeatureSetter<PushConstantRange> SET_MAP = new FeatureSetter.Builder<PushConstantRange>(FEATURE_COUNT, PushConstantRangeImpl::featureIndexStatic).add(PushConstantRange.FeatureIDs.OFFSET, (object, value) -> ((PushConstantRangeImpl) object).offset((int) value)).add(PushConstantRange.FeatureIDs.SIZE, (object, value) -> ((PushConstantRangeImpl) object).size((int) value)).build();
  }
}
