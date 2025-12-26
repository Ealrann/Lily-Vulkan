package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface IProcess extends IResourceContainer, LNamedElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean enabled();
  float queuePriority();
  ICadence cadence();
  void enabled(final boolean enabled);
  void queuePriority(final float queuePriority);
  void cadence(final ICadence cadence);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int ENABLED = -786043098;
    int QUEUE_PRIORITY = 1353153018;
    int CADENCE = 1364599670;
  }

  interface Features<T extends Features<T>> extends IResourceContainer.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("enabled").defaultValue("true").id(IProcess.FeatureIDs.ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Float, Float, FloatListener, Features<?>> QUEUE_PRIORITY = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("queuePriority").mandatory(true).defaultValue("1f").id(IProcess.FeatureIDs.QUEUE_PRIORITY).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Relation<ICadence, ICadence, Listener<ICadence>, Features<?>> CADENCE = new RelationBuilder<ICadence, ICadence, Listener<ICadence>, Features<?>>().name("cadence").contains(true).id(IProcess.FeatureIDs.CADENCE).concept(() -> ApplicationModelDefinition.Groups.I_CADENCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, RESOURCE_PKG, DESCRIPTOR_PKG, ENABLED, QUEUE_PRIORITY, CADENCE);
  }
}
