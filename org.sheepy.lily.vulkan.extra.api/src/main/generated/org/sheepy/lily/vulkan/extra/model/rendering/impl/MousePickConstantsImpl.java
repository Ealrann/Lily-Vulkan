package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.nio.ByteBuffer;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

public final class MousePickConstantsImpl extends FeaturedObject<MousePickConstants.Features<?>> implements MousePickConstants {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<MousePickConstants.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ByteBuffer data;
  private MousePickExtension mousePickExtension;

  public MousePickConstantsImpl(final String name, final MousePickExtension mousePickExtension) {
    this.name = name;
    this.mousePickExtension = mousePickExtension;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<MousePickConstants.Features<?>> notifier() {
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
  public MousePickExtension mousePickExtension() {
    return mousePickExtension;
  }

  @Override
  public void mousePickExtension(final MousePickExtension mousePickExtension) {
    final var oldValue = this.mousePickExtension;
    final var eventType = mousePickExtension == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.mousePickExtension = mousePickExtension;
    notifier.notify(MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION, false, false, eventType, oldValue, mousePickExtension);
  }

  @Override
  public Group<MousePickConstants> lmGroup() {
    return RenderingModelDefinition.Groups.MOUSE_PICK_CONSTANTS;
  }

  @Override
  protected FeatureSetter<MousePickConstants> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<MousePickConstants> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case MousePickConstants.FeatureIDs.NAME -> 0;
      case MousePickConstants.FeatureIDs.DATA -> 1;
      case MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<MousePickConstants> GET_MAP = new FeatureGetter.Builder<MousePickConstants>(FEATURE_COUNT, MousePickConstantsImpl::featureIndexStatic).add(MousePickConstants.FeatureIDs.NAME, MousePickConstants::name).add(MousePickConstants.FeatureIDs.DATA, MousePickConstants::data).add(MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION, MousePickConstants::mousePickExtension).build();
    private static final FeatureSetter<MousePickConstants> SET_MAP = new FeatureSetter.Builder<MousePickConstants>(FEATURE_COUNT, MousePickConstantsImpl::featureIndexStatic).add(MousePickConstants.FeatureIDs.DATA, (object, value) -> ((MousePickConstantsImpl) object).data((ByteBuffer) value)).add(MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION, (object, value) -> ((MousePickConstantsImpl) object).mousePickExtension((MousePickExtension) value)).build();
  }
}
