package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;

public final class SelectionProxyImpl extends FeaturedObject<SelectionProxy.Features<?>> implements SelectionProxy {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<SelectionProxy.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EMousePickMode pickMode;
  private IEntitySelection selection;
  private IEntitySelection focus;

  public SelectionProxyImpl(final EMousePickMode pickMode) {
    this.pickMode = pickMode;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SelectionProxy.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public EMousePickMode pickMode() {
    return pickMode;
  }

  @Override
  public void pickMode(final EMousePickMode pickMode) {
    final var oldValue = this.pickMode;
    this.pickMode = pickMode;
    notifier.notify(SelectionProxy.FeatureIDs.PICK_MODE, false, false, oldValue, pickMode);
  }

  @Override
  public IEntitySelection selection() {
    return selection;
  }

  @Override
  public void selection(final IEntitySelection selection) {
    final var oldValue = this.selection;
    final var eventType = selection == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.selection = selection;
    setContainer(selection, SelectionProxy.FeatureIDs.SELECTION);
    beforeContainmentNotify(eventType, oldValue, selection);
    notifier.notify(SelectionProxy.FeatureIDs.SELECTION, true, false, eventType, oldValue, selection);
    afterContainmentNotify(eventType, oldValue, selection);
  }

  @Override
  public IEntitySelection focus() {
    return focus;
  }

  @Override
  public void focus(final IEntitySelection focus) {
    final var oldValue = this.focus;
    final var eventType = focus == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.focus = focus;
    setContainer(focus, SelectionProxy.FeatureIDs.FOCUS);
    beforeContainmentNotify(eventType, oldValue, focus);
    notifier.notify(SelectionProxy.FeatureIDs.FOCUS, true, false, eventType, oldValue, focus);
    afterContainmentNotify(eventType, oldValue, focus);
  }

  @Override
  public Group<SelectionProxy> lmGroup() {
    return RenderingModelDefinition.Groups.SELECTION_PROXY;
  }

  @Override
  protected FeatureSetter<SelectionProxy> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SelectionProxy> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SelectionProxy.FeatureIDs.PICK_MODE -> 0;
      case SelectionProxy.FeatureIDs.SELECTION -> 1;
      case SelectionProxy.FeatureIDs.FOCUS -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SelectionProxy> GET_MAP = new FeatureGetter.Builder<SelectionProxy>(FEATURE_COUNT, SelectionProxyImpl::featureIndexStatic).add(SelectionProxy.FeatureIDs.PICK_MODE, SelectionProxy::pickMode).add(SelectionProxy.FeatureIDs.SELECTION, SelectionProxy::selection).add(SelectionProxy.FeatureIDs.FOCUS, SelectionProxy::focus).build();
    private static final FeatureSetter<SelectionProxy> SET_MAP = new FeatureSetter.Builder<SelectionProxy>(FEATURE_COUNT, SelectionProxyImpl::featureIndexStatic).add(SelectionProxy.FeatureIDs.PICK_MODE, (object, value) -> ((SelectionProxyImpl) object).pickMode((EMousePickMode) value)).add(SelectionProxy.FeatureIDs.SELECTION, (object, value) -> ((SelectionProxyImpl) object).selection((IEntitySelection) value)).add(SelectionProxy.FeatureIDs.FOCUS, (object, value) -> ((SelectionProxyImpl) object).focus((IEntitySelection) value)).build();
  }
}
