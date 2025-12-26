package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;

public final class BindVertexBufferImpl extends FeaturedObject<BindVertexBuffer.Features<?>> implements BindVertexBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<BindVertexBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private int firstBinding;
  private final List<VertexBinding> vertexBindings = newObservableList(BindVertexBuffer.FeatureIDs.VERTEX_BINDINGS, true, true);

  public BindVertexBufferImpl(final String name, final List<VertexBinding> vertexBindings) {
    this.name = name;
    this.vertexBindings.addAll(vertexBindings);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BindVertexBuffer.Features<?>> notifier() {
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
  public int firstBinding() {
    return firstBinding;
  }

  @Override
  public void firstBinding(final int firstBinding) {
    final var oldValue = this.firstBinding;
    this.firstBinding = firstBinding;
    notifier.notifyInt(BindVertexBuffer.FeatureIDs.FIRST_BINDING, false, false, oldValue, firstBinding);
  }

  @Override
  public List<VertexBinding> vertexBindings() {
    return vertexBindings;
  }

  @Override
  public Group<BindVertexBuffer> lmGroup() {
    return GraphicModelDefinition.Groups.BIND_VERTEX_BUFFER;
  }

  @Override
  protected FeatureSetter<BindVertexBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BindVertexBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BindVertexBuffer.FeatureIDs.NAME -> 0;
      case BindVertexBuffer.FeatureIDs.ENABLED -> 1;
      case BindVertexBuffer.FeatureIDs.FIRST_BINDING -> 2;
      case BindVertexBuffer.FeatureIDs.VERTEX_BINDINGS -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BindVertexBuffer> GET_MAP = new FeatureGetter.Builder<BindVertexBuffer>(FEATURE_COUNT, BindVertexBufferImpl::featureIndexStatic).add(BindVertexBuffer.FeatureIDs.NAME, BindVertexBuffer::name).add(BindVertexBuffer.FeatureIDs.ENABLED, BindVertexBuffer::enabled).add(BindVertexBuffer.FeatureIDs.FIRST_BINDING, BindVertexBuffer::firstBinding).add(BindVertexBuffer.FeatureIDs.VERTEX_BINDINGS, BindVertexBuffer::vertexBindings).build();
    private static final FeatureSetter<BindVertexBuffer> SET_MAP = new FeatureSetter.Builder<BindVertexBuffer>(FEATURE_COUNT, BindVertexBufferImpl::featureIndexStatic).add(BindVertexBuffer.FeatureIDs.ENABLED, (object, value) -> ((BindVertexBufferImpl) object).enabled((boolean) value)).add(BindVertexBuffer.FeatureIDs.FIRST_BINDING, (object, value) -> ((BindVertexBufferImpl) object).firstBinding((int) value)).build();
  }
}
