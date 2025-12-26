package org.sheepy.lily.openal.model.openal.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.openal.model.openal.OpenALEngine;
import org.sheepy.lily.openal.model.openal.OpenALModelDefinition;

public final class OpenALEngineImpl extends FeaturedObject<OpenALEngine.Features<?>> implements OpenALEngine {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<OpenALEngine.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private ResourcePkg resourcePkg;

  public OpenALEngineImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<OpenALEngine.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public ResourcePkg resourcePkg() {
    return resourcePkg;
  }

  @Override
  public void resourcePkg(final ResourcePkg resourcePkg) {
    final var oldValue = this.resourcePkg;
    final var eventType = resourcePkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.resourcePkg = resourcePkg;
    setContainer(resourcePkg, OpenALEngine.FeatureIDs.RESOURCE_PKG);
    beforeContainmentNotify(eventType, oldValue, resourcePkg);
    notifier.notify(OpenALEngine.FeatureIDs.RESOURCE_PKG, true, false, eventType, oldValue, resourcePkg);
    afterContainmentNotify(eventType, oldValue, resourcePkg);
  }

  @Override
  public Group<OpenALEngine> lmGroup() {
    return OpenALModelDefinition.Groups.OPENAL_ENGINE;
  }

  @Override
  protected FeatureSetter<OpenALEngine> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<OpenALEngine> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case OpenALEngine.FeatureIDs.RESOURCE_PKG -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<OpenALEngine> GET_MAP = new FeatureGetter.Builder<OpenALEngine>(FEATURE_COUNT, OpenALEngineImpl::featureIndexStatic).add(OpenALEngine.FeatureIDs.RESOURCE_PKG, OpenALEngine::resourcePkg).build();
    private static final FeatureSetter<OpenALEngine> SET_MAP = new FeatureSetter.Builder<OpenALEngine>(FEATURE_COUNT, OpenALEngineImpl::featureIndexStatic).add(OpenALEngine.FeatureIDs.RESOURCE_PKG, (object, value) -> ((OpenALEngineImpl) object).resourcePkg((ResourcePkg) value)).build();
  }
}
