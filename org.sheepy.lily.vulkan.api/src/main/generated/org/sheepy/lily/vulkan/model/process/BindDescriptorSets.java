package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.BindDescriptorSetsBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EBindPoint;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface BindDescriptorSets extends IPipelineTask {
  static Builder builder() {
    return new BindDescriptorSetsBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<DescriptorSet> descriptorSets();
  EBindPoint bindPoint();
  int stride();
  void bindPoint(final EBindPoint bindPoint);
  void stride(final int stride);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int DESCRIPTOR_SETS = 93855132;
    int BIND_POINT = 843101335;
    int STRIDE = 742240277;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Relation<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, Features<?>> DESCRIPTOR_SETS = new RelationBuilder<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, Features<?>>().name("descriptorSets").many(true).id(BindDescriptorSets.FeatureIDs.DESCRIPTOR_SETS).concept(() -> VulkanResourceModelDefinition.Groups.DESCRIPTOR_SET).build();
    Attribute<EBindPoint, EBindPoint, Listener<EBindPoint>, Features<?>> BIND_POINT = new AttributeBuilder<EBindPoint, EBindPoint, Listener<EBindPoint>, Features<?>>().name("bindPoint").mandatory(true).id(BindDescriptorSets.FeatureIDs.BIND_POINT).datatype(() -> EnumerationModelDefinition.Enums.E_BIND_POINT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> STRIDE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("stride").defaultValue("0").id(BindDescriptorSets.FeatureIDs.STRIDE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, DESCRIPTOR_SETS, BIND_POINT, STRIDE);
  }

  interface Builder extends IFeaturedObject.Builder<BindDescriptorSets> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder addDescriptorSet(Supplier<DescriptorSet> descriptorSet);
    Builder bindPoint(EBindPoint bindPoint);
    Builder stride(int stride);
    Builder addDescriptorSets(List<DescriptorSet> descriptorSets);
  }
}
