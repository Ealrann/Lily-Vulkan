package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.compute.builder.DispatchTaskBuilder;

public interface DispatchTask extends IPipelineTask {
  static Builder builder() {
    return new DispatchTaskBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int workgroupCountX();
  int workgroupCountY();
  int workgroupCountZ();
  void workgroupCountX(final int workgroupCountX);
  void workgroupCountY(final int workgroupCountY);
  void workgroupCountZ(final int workgroupCountZ);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int WORKGROUP_COUNTX = -503831468;
    int WORKGROUP_COUNTY = -503831467;
    int WORKGROUP_COUNTZ = -503831466;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Integer, Integer, IntListener, Features<?>> WORKGROUP_COUNTX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("workgroupCountX").defaultValue("1").id(DispatchTask.FeatureIDs.WORKGROUP_COUNTX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> WORKGROUP_COUNTY = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("workgroupCountY").defaultValue("1").id(DispatchTask.FeatureIDs.WORKGROUP_COUNTY).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> WORKGROUP_COUNTZ = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("workgroupCountZ").defaultValue("1").id(DispatchTask.FeatureIDs.WORKGROUP_COUNTZ).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, WORKGROUP_COUNTX, WORKGROUP_COUNTY, WORKGROUP_COUNTZ);
  }

  interface Builder extends IFeaturedObject.Builder<DispatchTask> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder workgroupCountX(int workgroupCountX);
    Builder workgroupCountY(int workgroupCountY);
    Builder workgroupCountZ(int workgroupCountZ);
  }
}
