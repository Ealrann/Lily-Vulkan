package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class BufferDescriptorImpl extends FeaturedObject<BufferDescriptor.Features<?>> implements BufferDescriptor {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<BufferDescriptor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private EDescriptorType type;
  private final List<EShaderStage> shaderStages = newObservableList(IDescriptor.FeatureIDs.SHADER_STAGES, false, false);
  private IBuffer buffer;

  public BufferDescriptorImpl(final String name, final EDescriptorType type,
      final List<EShaderStage> shaderStages, final IBuffer buffer) {
    this.name = name;
    this.type = type;
    this.shaderStages.addAll(shaderStages);
    this.buffer = buffer;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BufferDescriptor.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public EDescriptorType type() {
    return type;
  }

  @Override
  public void type(final EDescriptorType type) {
    final var oldValue = this.type;
    this.type = type;
    notifier.notify(IDescriptor.FeatureIDs.TYPE, false, false, oldValue, type);
  }

  @Override
  public List<EShaderStage> shaderStages() {
    return shaderStages;
  }

  @Override
  public IBuffer buffer() {
    return buffer;
  }

  @Override
  public void buffer(final IBuffer buffer) {
    final var oldValue = this.buffer;
    final var eventType = buffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.buffer = buffer;
    notifier.notify(BufferDescriptor.FeatureIDs.BUFFER, false, false, eventType, oldValue, buffer);
  }

  @Override
  public Group<BufferDescriptor> lmGroup() {
    return VulkanResourceModelDefinition.Groups.BUFFER_DESCRIPTOR;
  }

  @Override
  protected FeatureSetter<BufferDescriptor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BufferDescriptor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BufferDescriptor.FeatureIDs.NAME -> 0;
      case BufferDescriptor.FeatureIDs.TYPE -> 1;
      case BufferDescriptor.FeatureIDs.SHADER_STAGES -> 2;
      case BufferDescriptor.FeatureIDs.BUFFER -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BufferDescriptor> GET_MAP = new FeatureGetter.Builder<BufferDescriptor>(FEATURE_COUNT, BufferDescriptorImpl::featureIndexStatic).add(BufferDescriptor.FeatureIDs.NAME, BufferDescriptor::name).add(BufferDescriptor.FeatureIDs.TYPE, BufferDescriptor::type).add(BufferDescriptor.FeatureIDs.SHADER_STAGES, BufferDescriptor::shaderStages).add(BufferDescriptor.FeatureIDs.BUFFER, BufferDescriptor::buffer).build();
    private static final FeatureSetter<BufferDescriptor> SET_MAP = new FeatureSetter.Builder<BufferDescriptor>(FEATURE_COUNT, BufferDescriptorImpl::featureIndexStatic).add(BufferDescriptor.FeatureIDs.TYPE, (object, value) -> ((BufferDescriptorImpl) object).type((EDescriptorType) value)).add(BufferDescriptor.FeatureIDs.BUFFER, (object, value) -> ((BufferDescriptorImpl) object).buffer((IBuffer) value)).build();
  }
}
