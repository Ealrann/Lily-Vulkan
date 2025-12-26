package org.sheepy.lily.vulkan.model.vulkan.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature;

public final class VulkanEngineImpl extends FeaturedObject<VulkanEngine.Features<?>> implements VulkanEngine {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<VulkanEngine.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private VulkanResourcePkg resourcePkg;
  private DescriptorPkg descriptorPkg;
  private boolean enabled;
  private final List<IProcess> processes = newObservableList(VulkanEngine.FeatureIDs.PROCESSES, true, true);
  private final List<EPhysicalDeviceFeature> features = newObservableList(VulkanEngine.FeatureIDs.FEATURES, false, false);

  public VulkanEngineImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<VulkanEngine.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public VulkanResourcePkg resourcePkg() {
    return resourcePkg;
  }

  @Override
  public void resourcePkg(final VulkanResourcePkg resourcePkg) {
    final var oldValue = this.resourcePkg;
    final var eventType = resourcePkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.resourcePkg = resourcePkg;
    setContainer(resourcePkg, IResourceContainer.FeatureIDs.RESOURCE_PKG);
    beforeContainmentNotify(eventType, oldValue, resourcePkg);
    notifier.notify(IResourceContainer.FeatureIDs.RESOURCE_PKG, true, false, eventType, oldValue, resourcePkg);
    afterContainmentNotify(eventType, oldValue, resourcePkg);
  }

  @Override
  public DescriptorPkg descriptorPkg() {
    return descriptorPkg;
  }

  @Override
  public void descriptorPkg(final DescriptorPkg descriptorPkg) {
    final var oldValue = this.descriptorPkg;
    final var eventType = descriptorPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.descriptorPkg = descriptorPkg;
    setContainer(descriptorPkg, IResourceContainer.FeatureIDs.DESCRIPTOR_PKG);
    beforeContainmentNotify(eventType, oldValue, descriptorPkg);
    notifier.notify(IResourceContainer.FeatureIDs.DESCRIPTOR_PKG, true, false, eventType, oldValue, descriptorPkg);
    afterContainmentNotify(eventType, oldValue, descriptorPkg);
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(VulkanEngine.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public List<IProcess> processes() {
    return processes;
  }

  @Override
  public List<EPhysicalDeviceFeature> features() {
    return features;
  }

  @Override
  public Group<VulkanEngine> lmGroup() {
    return VulkanModelDefinition.Groups.VULKAN_ENGINE;
  }

  @Override
  protected FeatureSetter<VulkanEngine> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<VulkanEngine> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case VulkanEngine.FeatureIDs.RESOURCE_PKG -> 0;
      case VulkanEngine.FeatureIDs.DESCRIPTOR_PKG -> 1;
      case VulkanEngine.FeatureIDs.ENABLED -> 2;
      case VulkanEngine.FeatureIDs.PROCESSES -> 3;
      case VulkanEngine.FeatureIDs.FEATURES -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<VulkanEngine> GET_MAP = new FeatureGetter.Builder<VulkanEngine>(FEATURE_COUNT, VulkanEngineImpl::featureIndexStatic).add(VulkanEngine.FeatureIDs.RESOURCE_PKG, VulkanEngine::resourcePkg).add(VulkanEngine.FeatureIDs.DESCRIPTOR_PKG, VulkanEngine::descriptorPkg).add(VulkanEngine.FeatureIDs.ENABLED, VulkanEngine::enabled).add(VulkanEngine.FeatureIDs.PROCESSES, VulkanEngine::processes).add(VulkanEngine.FeatureIDs.FEATURES, VulkanEngine::features).build();
    private static final FeatureSetter<VulkanEngine> SET_MAP = new FeatureSetter.Builder<VulkanEngine>(FEATURE_COUNT, VulkanEngineImpl::featureIndexStatic).add(VulkanEngine.FeatureIDs.RESOURCE_PKG, (object, value) -> ((VulkanEngineImpl) object).resourcePkg((VulkanResourcePkg) value)).add(VulkanEngine.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((VulkanEngineImpl) object).descriptorPkg((DescriptorPkg) value)).add(VulkanEngine.FeatureIDs.ENABLED, (object, value) -> ((VulkanEngineImpl) object).enabled((boolean) value)).build();
  }
}
