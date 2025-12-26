package org.sheepy.lily.vulkan.model.vulkan.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.MouseLocation;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;

public final class MouseLocationImpl extends FeaturedObject<MouseLocation.Features<?>> implements MouseLocation {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<MouseLocation.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private VulkanEngine vulkanEngine;

  public MouseLocationImpl(final String name, final VulkanEngine vulkanEngine) {
    this.name = name;
    this.vulkanEngine = vulkanEngine;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<MouseLocation.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public VulkanEngine vulkanEngine() {
    return vulkanEngine;
  }

  @Override
  public void vulkanEngine(final VulkanEngine vulkanEngine) {
    final var oldValue = this.vulkanEngine;
    final var eventType = vulkanEngine == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.vulkanEngine = vulkanEngine;
    notifier.notify(MouseLocation.FeatureIDs.VULKAN_ENGINE, false, false, eventType, oldValue, vulkanEngine);
  }

  @Override
  public Group<MouseLocation> lmGroup() {
    return VulkanModelDefinition.Groups.MOUSE_LOCATION;
  }

  @Override
  protected FeatureSetter<MouseLocation> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<MouseLocation> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case MouseLocation.FeatureIDs.NAME -> 0;
      case MouseLocation.FeatureIDs.VULKAN_ENGINE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<MouseLocation> GET_MAP = new FeatureGetter.Builder<MouseLocation>(FEATURE_COUNT, MouseLocationImpl::featureIndexStatic).add(MouseLocation.FeatureIDs.NAME, MouseLocation::name).add(MouseLocation.FeatureIDs.VULKAN_ENGINE, MouseLocation::vulkanEngine).build();
    private static final FeatureSetter<MouseLocation> SET_MAP = new FeatureSetter.Builder<MouseLocation>(FEATURE_COUNT, MouseLocationImpl::featureIndexStatic).add(MouseLocation.FeatureIDs.VULKAN_ENGINE, (object, value) -> ((MouseLocationImpl) object).vulkanEngine((VulkanEngine) value)).build();
  }
}
