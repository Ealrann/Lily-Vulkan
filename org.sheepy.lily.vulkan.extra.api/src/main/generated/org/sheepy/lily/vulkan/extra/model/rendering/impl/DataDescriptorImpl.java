package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class DataDescriptorImpl extends FeaturedObject<DataDescriptor.Features<?>> implements DataDescriptor {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<DataDescriptor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int part;
  private int instance;
  private EDescriptorType descriptorType;
  private final List<EShaderStage> stages = newObservableList(DataDescriptor.FeatureIDs.STAGES, false, false);

  public DataDescriptorImpl(final int part, final int instance,
      final EDescriptorType descriptorType, final List<EShaderStage> stages) {
    this.part = part;
    this.instance = instance;
    this.descriptorType = descriptorType;
    this.stages.addAll(stages);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DataDescriptor.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int part() {
    return part;
  }

  @Override
  public void part(final int part) {
    final var oldValue = this.part;
    this.part = part;
    notifier.notifyInt(DataDescriptor.FeatureIDs.PART, false, false, oldValue, part);
  }

  @Override
  public int instance() {
    return instance;
  }

  @Override
  public void instance(final int instance) {
    final var oldValue = this.instance;
    this.instance = instance;
    notifier.notifyInt(DataDescriptor.FeatureIDs.INSTANCE, false, false, oldValue, instance);
  }

  @Override
  public EDescriptorType descriptorType() {
    return descriptorType;
  }

  @Override
  public void descriptorType(final EDescriptorType descriptorType) {
    final var oldValue = this.descriptorType;
    this.descriptorType = descriptorType;
    notifier.notify(DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE, false, false, oldValue, descriptorType);
  }

  @Override
  public List<EShaderStage> stages() {
    return stages;
  }

  @Override
  public Group<DataDescriptor> lmGroup() {
    return RenderingModelDefinition.Groups.DATA_DESCRIPTOR;
  }

  @Override
  protected FeatureSetter<DataDescriptor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DataDescriptor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DataDescriptor.FeatureIDs.PART -> 0;
      case DataDescriptor.FeatureIDs.INSTANCE -> 1;
      case DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE -> 2;
      case DataDescriptor.FeatureIDs.STAGES -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DataDescriptor> GET_MAP = new FeatureGetter.Builder<DataDescriptor>(FEATURE_COUNT, DataDescriptorImpl::featureIndexStatic).add(DataDescriptor.FeatureIDs.PART, DataDescriptor::part).add(DataDescriptor.FeatureIDs.INSTANCE, DataDescriptor::instance).add(DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE, DataDescriptor::descriptorType).add(DataDescriptor.FeatureIDs.STAGES, DataDescriptor::stages).build();
    private static final FeatureSetter<DataDescriptor> SET_MAP = new FeatureSetter.Builder<DataDescriptor>(FEATURE_COUNT, DataDescriptorImpl::featureIndexStatic).add(DataDescriptor.FeatureIDs.PART, (object, value) -> ((DataDescriptorImpl) object).part((int) value)).add(DataDescriptor.FeatureIDs.INSTANCE, (object, value) -> ((DataDescriptorImpl) object).instance((int) value)).add(DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE, (object, value) -> ((DataDescriptorImpl) object).descriptorType((EDescriptorType) value)).build();
  }
}
