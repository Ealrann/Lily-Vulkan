package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.vulkan.model.enumeration.EInputRate;

public final class InputDescriptorImpl extends FeaturedObject<InputDescriptor.Features<?>> implements InputDescriptor {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<InputDescriptor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EInputRate inputRate;
  private int strideLength;
  private final List<AttributeDescription> attributes = newObservableList(InputDescriptor.FeatureIDs.ATTRIBUTES, true, true);

  public InputDescriptorImpl(final List<AttributeDescription> attributes) {
    this.attributes.addAll(attributes);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<InputDescriptor.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public EInputRate inputRate() {
    return inputRate;
  }

  @Override
  public void inputRate(final EInputRate inputRate) {
    final var oldValue = this.inputRate;
    this.inputRate = inputRate;
    notifier.notify(InputDescriptor.FeatureIDs.INPUT_RATE, false, false, oldValue, inputRate);
  }

  @Override
  public int strideLength() {
    return strideLength;
  }

  @Override
  public void strideLength(final int strideLength) {
    final var oldValue = this.strideLength;
    this.strideLength = strideLength;
    notifier.notifyInt(InputDescriptor.FeatureIDs.STRIDE_LENGTH, false, false, oldValue, strideLength);
  }

  @Override
  public List<AttributeDescription> attributes() {
    return attributes;
  }

  @Override
  public Group<InputDescriptor> lmGroup() {
    return GraphicModelDefinition.Groups.INPUT_DESCRIPTOR;
  }

  @Override
  protected FeatureSetter<InputDescriptor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<InputDescriptor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case InputDescriptor.FeatureIDs.INPUT_RATE -> 0;
      case InputDescriptor.FeatureIDs.STRIDE_LENGTH -> 1;
      case InputDescriptor.FeatureIDs.ATTRIBUTES -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<InputDescriptor> GET_MAP = new FeatureGetter.Builder<InputDescriptor>(FEATURE_COUNT, InputDescriptorImpl::featureIndexStatic).add(InputDescriptor.FeatureIDs.INPUT_RATE, InputDescriptor::inputRate).add(InputDescriptor.FeatureIDs.STRIDE_LENGTH, InputDescriptor::strideLength).add(InputDescriptor.FeatureIDs.ATTRIBUTES, InputDescriptor::attributes).build();
    private static final FeatureSetter<InputDescriptor> SET_MAP = new FeatureSetter.Builder<InputDescriptor>(FEATURE_COUNT, InputDescriptorImpl::featureIndexStatic).add(InputDescriptor.FeatureIDs.INPUT_RATE, (object, value) -> ((InputDescriptorImpl) object).inputRate((EInputRate) value)).add(InputDescriptor.FeatureIDs.STRIDE_LENGTH, (object, value) -> ((InputDescriptorImpl) object).strideLength((int) value)).build();
  }
}
