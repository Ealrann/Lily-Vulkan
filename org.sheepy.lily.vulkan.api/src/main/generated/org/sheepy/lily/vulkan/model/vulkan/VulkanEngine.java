package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.vulkan.builder.VulkanEngineBuilder;
import org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface VulkanEngine extends IEngine, IResourceContainer {
  static Builder builder() {
    return new VulkanEngineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean enabled();
  List<IProcess> processes();
  List<EPhysicalDeviceFeature> features();
  void enabled(final boolean enabled);

  interface FeatureIDs {
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int ENABLED = 123751725;
    int PROCESSES = -1796783543;
    int FEATURES = 1903452113;
  }

  interface Features<T extends Features<T>> extends IEngine.Features<T>, IResourceContainer.Features<T> {
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("enabled").defaultValue("true").id(VulkanEngine.FeatureIDs.ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Relation<IProcess, List<IProcess>, Listener<List<IProcess>>, Features<?>> PROCESSES = new RelationBuilder<IProcess, List<IProcess>, Listener<List<IProcess>>, Features<?>>().name("processes").many(true).contains(true).id(VulkanEngine.FeatureIDs.PROCESSES).concept(() -> VulkanModelDefinition.Groups.I_PROCESS).build();
    Attribute<EPhysicalDeviceFeature, List<EPhysicalDeviceFeature>, Listener<List<EPhysicalDeviceFeature>>, Features<?>> FEATURES = new AttributeBuilder<EPhysicalDeviceFeature, List<EPhysicalDeviceFeature>, Listener<List<EPhysicalDeviceFeature>>, Features<?>>().name("features").many(true).id(VulkanEngine.FeatureIDs.FEATURES).datatype(() -> EnumerationModelDefinition.Enums.E_PHYSICAL_DEVICE_FEATURE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCE_PKG, DESCRIPTOR_PKG, ENABLED, PROCESSES, FEATURES);
  }

  interface Builder extends IFeaturedObject.Builder<VulkanEngine> {
    Builder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg);
    Builder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg);
    Builder enabled(boolean enabled);
    Builder addProcesse(Supplier<IProcess> processe);
    Builder addFeature(EPhysicalDeviceFeature feature);
    Builder addProcesses(List<IProcess> processes);
    Builder addFeatures(List<EPhysicalDeviceFeature> features);
  }
}
