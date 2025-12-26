package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

public final class VertexBindingImpl extends FeaturedObject<VertexBinding.Features<?>> implements VertexBinding {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<VertexBinding.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private IBuffer buffer;

  public VertexBindingImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<VertexBinding.Features<?>> notifier() {
    return notifier;
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
    notifier.notify(VertexBinding.FeatureIDs.BUFFER, false, false, eventType, oldValue, buffer);
  }

  @Override
  public Group<VertexBinding> lmGroup() {
    return GraphicModelDefinition.Groups.VERTEX_BINDING;
  }

  @Override
  protected FeatureSetter<VertexBinding> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<VertexBinding> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case VertexBinding.FeatureIDs.BUFFER -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<VertexBinding> GET_MAP = new FeatureGetter.Builder<VertexBinding>(FEATURE_COUNT, VertexBindingImpl::featureIndexStatic).add(VertexBinding.FeatureIDs.BUFFER, VertexBinding::buffer).build();
    private static final FeatureSetter<VertexBinding> SET_MAP = new FeatureSetter.Builder<VertexBinding>(FEATURE_COUNT, VertexBindingImpl::featureIndexStatic).add(VertexBinding.FeatureIDs.BUFFER, (object, value) -> ((VertexBindingImpl) object).buffer((IBuffer) value)).build();
  }
}
