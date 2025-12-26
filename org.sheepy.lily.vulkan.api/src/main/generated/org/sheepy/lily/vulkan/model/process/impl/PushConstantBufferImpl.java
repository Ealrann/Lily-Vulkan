package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class PushConstantBufferImpl extends FeaturedObject<PushConstantBuffer.Features<?>> implements PushConstantBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<PushConstantBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private final List<EShaderStage> stages = newObservableList(PushConstant.FeatureIDs.STAGES, false, false);
  private ConstantBuffer buffer;

  public PushConstantBufferImpl(final String name, final List<EShaderStage> stages,
      final ConstantBuffer buffer) {
    this.name = name;
    this.stages.addAll(stages);
    this.buffer = buffer;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PushConstantBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IPipelineTask.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public List<EShaderStage> stages() {
    return stages;
  }

  @Override
  public ConstantBuffer buffer() {
    return buffer;
  }

  @Override
  public void buffer(final ConstantBuffer buffer) {
    final var oldValue = this.buffer;
    final var eventType = buffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.buffer = buffer;
    notifier.notify(PushConstantBuffer.FeatureIDs.BUFFER, false, false, eventType, oldValue, buffer);
  }

  @Override
  public Group<PushConstantBuffer> lmGroup() {
    return ProcessModelDefinition.Groups.PUSH_CONSTANT_BUFFER;
  }

  @Override
  protected FeatureSetter<PushConstantBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PushConstantBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PushConstantBuffer.FeatureIDs.NAME -> 0;
      case PushConstantBuffer.FeatureIDs.ENABLED -> 1;
      case PushConstantBuffer.FeatureIDs.STAGES -> 2;
      case PushConstantBuffer.FeatureIDs.BUFFER -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PushConstantBuffer> GET_MAP = new FeatureGetter.Builder<PushConstantBuffer>(FEATURE_COUNT, PushConstantBufferImpl::featureIndexStatic).add(PushConstantBuffer.FeatureIDs.NAME, PushConstantBuffer::name).add(PushConstantBuffer.FeatureIDs.ENABLED, PushConstantBuffer::enabled).add(PushConstantBuffer.FeatureIDs.STAGES, PushConstantBuffer::stages).add(PushConstantBuffer.FeatureIDs.BUFFER, PushConstantBuffer::buffer).build();
    private static final FeatureSetter<PushConstantBuffer> SET_MAP = new FeatureSetter.Builder<PushConstantBuffer>(FEATURE_COUNT, PushConstantBufferImpl::featureIndexStatic).add(PushConstantBuffer.FeatureIDs.ENABLED, (object, value) -> ((PushConstantBufferImpl) object).enabled((boolean) value)).add(PushConstantBuffer.FeatureIDs.BUFFER, (object, value) -> ((PushConstantBufferImpl) object).buffer((ConstantBuffer) value)).build();
  }
}
