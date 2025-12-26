package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.nio.ByteBuffer;
import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class GenericConstantBufferImpl extends FeaturedObject<GenericConstantBuffer.Features<?>> implements GenericConstantBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<GenericConstantBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ByteBuffer data;
  private final List<IModelVariable> referencedVariables = newObservableList(GenericConstantBuffer.FeatureIDs.REFERENCED_VARIABLES, true, false);
  private ModelVariablePkg VariablePkg;

  public GenericConstantBufferImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GenericConstantBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public ByteBuffer data() {
    return data;
  }

  @Override
  public void data(final ByteBuffer data) {
    final var oldValue = this.data;
    this.data = data;
    notifier.notify(ConstantBuffer.FeatureIDs.DATA, false, false, oldValue, data);
  }

  @Override
  public List<IModelVariable> referencedVariables() {
    return referencedVariables;
  }

  @Override
  public ModelVariablePkg VariablePkg() {
    return VariablePkg;
  }

  @Override
  public void VariablePkg(final ModelVariablePkg VariablePkg) {
    final var oldValue = this.VariablePkg;
    final var eventType = VariablePkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.VariablePkg = VariablePkg;
    setContainer(VariablePkg, GenericConstantBuffer.FeatureIDs.VARIABLE_PKG);
    beforeContainmentNotify(eventType, oldValue, VariablePkg);
    notifier.notify(GenericConstantBuffer.FeatureIDs.VARIABLE_PKG, true, false, eventType, oldValue, VariablePkg);
    afterContainmentNotify(eventType, oldValue, VariablePkg);
  }

  @Override
  public Group<GenericConstantBuffer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.GENERIC_CONSTANT_BUFFER;
  }

  @Override
  protected FeatureSetter<GenericConstantBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GenericConstantBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GenericConstantBuffer.FeatureIDs.NAME -> 0;
      case GenericConstantBuffer.FeatureIDs.DATA -> 1;
      case GenericConstantBuffer.FeatureIDs.REFERENCED_VARIABLES -> 2;
      case GenericConstantBuffer.FeatureIDs.VARIABLE_PKG -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GenericConstantBuffer> GET_MAP = new FeatureGetter.Builder<GenericConstantBuffer>(FEATURE_COUNT, GenericConstantBufferImpl::featureIndexStatic).add(GenericConstantBuffer.FeatureIDs.NAME, GenericConstantBuffer::name).add(GenericConstantBuffer.FeatureIDs.DATA, GenericConstantBuffer::data).add(GenericConstantBuffer.FeatureIDs.REFERENCED_VARIABLES, GenericConstantBuffer::referencedVariables).add(GenericConstantBuffer.FeatureIDs.VARIABLE_PKG, GenericConstantBuffer::VariablePkg).build();
    private static final FeatureSetter<GenericConstantBuffer> SET_MAP = new FeatureSetter.Builder<GenericConstantBuffer>(FEATURE_COUNT, GenericConstantBufferImpl::featureIndexStatic).add(GenericConstantBuffer.FeatureIDs.DATA, (object, value) -> ((GenericConstantBufferImpl) object).data((ByteBuffer) value)).add(GenericConstantBuffer.FeatureIDs.VARIABLE_PKG, (object, value) -> ((GenericConstantBufferImpl) object).VariablePkg((ModelVariablePkg) value)).build();
  }
}
