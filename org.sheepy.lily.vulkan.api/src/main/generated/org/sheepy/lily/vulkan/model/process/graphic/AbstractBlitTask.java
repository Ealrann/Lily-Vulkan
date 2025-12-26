package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.joml.Vector3ic;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface AbstractBlitTask extends IPipelineTask {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EFilter filter();
  Vector3ic clearColor();
  IVulkanImage srcImage();
  void filter(final EFilter filter);
  void clearColor(final Vector3ic clearColor);
  void srcImage(final IVulkanImage srcImage);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int FILTER = -1553768145;
    int CLEAR_COLOR = -1025486003;
    int SRC_IMAGE = 1759579598;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<EFilter, EFilter, Listener<EFilter>, Features<?>> FILTER = new AttributeBuilder<EFilter, EFilter, Listener<EFilter>, Features<?>>().name("filter").defaultValue("NEAREST").id(AbstractBlitTask.FeatureIDs.FILTER).datatype(() -> EnumerationModelDefinition.Enums.E_FILTER).build();
    Attribute<Vector3ic, Vector3ic, Listener<Vector3ic>, Features<?>> CLEAR_COLOR = new AttributeBuilder<Vector3ic, Vector3ic, Listener<Vector3ic>, Features<?>>().name("clearColor").mandatory(true).defaultValue("0;0;0").id(AbstractBlitTask.FeatureIDs.CLEAR_COLOR).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3I).build();
    Relation<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>> SRC_IMAGE = new RelationBuilder<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>>().name("srcImage").id(AbstractBlitTask.FeatureIDs.SRC_IMAGE).concept(() -> VulkanResourceModelDefinition.Groups.I_VULKAN_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, FILTER, CLEAR_COLOR, SRC_IMAGE);
  }
}
