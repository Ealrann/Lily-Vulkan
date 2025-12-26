package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

public final class MousePickExtensionImpl extends FeaturedObject<MousePickExtension.Features<?>> implements MousePickExtension {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<MousePickExtension.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private StaticBuffer mousePickBuffer;
  private SelectionProxy selectionProxy;
  private final List<EntityResolverPipeline> entityResolverPipelines = newObservableList(MousePickExtension.FeatureIDs.ENTITY_RESOLVER_PIPELINES, true, true);
  private int resolverPipelineOffset;

  public MousePickExtensionImpl(final StaticBuffer mousePickBuffer,
      final int resolverPipelineOffset) {
    this.mousePickBuffer = mousePickBuffer;
    this.resolverPipelineOffset = resolverPipelineOffset;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<MousePickExtension.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public StaticBuffer mousePickBuffer() {
    return mousePickBuffer;
  }

  @Override
  public void mousePickBuffer(final StaticBuffer mousePickBuffer) {
    final var oldValue = this.mousePickBuffer;
    final var eventType = mousePickBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.mousePickBuffer = mousePickBuffer;
    notifier.notify(MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER, false, false, eventType, oldValue, mousePickBuffer);
  }

  @Override
  public SelectionProxy selectionProxy() {
    return selectionProxy;
  }

  @Override
  public void selectionProxy(final SelectionProxy selectionProxy) {
    final var oldValue = this.selectionProxy;
    final var eventType = selectionProxy == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.selectionProxy = selectionProxy;
    notifier.notify(MousePickExtension.FeatureIDs.SELECTION_PROXY, false, false, eventType, oldValue, selectionProxy);
  }

  @Override
  public List<EntityResolverPipeline> entityResolverPipelines() {
    return entityResolverPipelines;
  }

  @Override
  public int resolverPipelineOffset() {
    return resolverPipelineOffset;
  }

  @Override
  public void resolverPipelineOffset(final int resolverPipelineOffset) {
    final var oldValue = this.resolverPipelineOffset;
    this.resolverPipelineOffset = resolverPipelineOffset;
    notifier.notifyInt(MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET, false, false, oldValue, resolverPipelineOffset);
  }

  @Override
  public Group<MousePickExtension> lmGroup() {
    return RenderingModelDefinition.Groups.MOUSE_PICK_EXTENSION;
  }

  @Override
  protected FeatureSetter<MousePickExtension> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<MousePickExtension> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER -> 0;
      case MousePickExtension.FeatureIDs.SELECTION_PROXY -> 1;
      case MousePickExtension.FeatureIDs.ENTITY_RESOLVER_PIPELINES -> 2;
      case MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<MousePickExtension> GET_MAP = new FeatureGetter.Builder<MousePickExtension>(FEATURE_COUNT, MousePickExtensionImpl::featureIndexStatic).add(MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER, MousePickExtension::mousePickBuffer).add(MousePickExtension.FeatureIDs.SELECTION_PROXY, MousePickExtension::selectionProxy).add(MousePickExtension.FeatureIDs.ENTITY_RESOLVER_PIPELINES, MousePickExtension::entityResolverPipelines).add(MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET, MousePickExtension::resolverPipelineOffset).build();
    private static final FeatureSetter<MousePickExtension> SET_MAP = new FeatureSetter.Builder<MousePickExtension>(FEATURE_COUNT, MousePickExtensionImpl::featureIndexStatic).add(MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER, (object, value) -> ((MousePickExtensionImpl) object).mousePickBuffer((StaticBuffer) value)).add(MousePickExtension.FeatureIDs.SELECTION_PROXY, (object, value) -> ((MousePickExtensionImpl) object).selectionProxy((SelectionProxy) value)).add(MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET, (object, value) -> ((MousePickExtensionImpl) object).resolverPipelineOffset((int) value)).build();
  }
}
