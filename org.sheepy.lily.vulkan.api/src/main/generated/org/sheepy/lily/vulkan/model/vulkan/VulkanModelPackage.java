package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import java.util.Optional;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IJavaWrapperConverter;
import org.logoce.lmf.core.api.model.IModelPackage;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.lang.builder.MetaModelBuilder;

public final class VulkanModelPackage implements IModelPackage {
  public static final VulkanModelPackage Instance = new VulkanModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Vulkan").domain("org.sheepy.lily.vulkan.model").addImports(List.of("org.sheepy.lily.core.model.Application", "org.sheepy.lily.core.model.Cadence", "org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Variable", "org.sheepy.vulkan.model.Enumeration")).genNamePackage(true).lmPackage(Instance).addGroups(VulkanModelDefinition.Groups.ALL).addEnums(VulkanModelDefinition.Enums.ALL).addUnits(VulkanModelDefinition.Units.ALL).addAliases(VulkanModelDefinition.Aliases.ALL).addJavaWrappers(VulkanModelDefinition.JavaWrappers.ALL).build();

  private VulkanModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == VulkanModelDefinition.Groups.VULKAN_ENGINE) return Optional.of((IFeaturedObject.Builder<T>) VulkanEngine.builder());
    else if (group == VulkanModelDefinition.Groups.VULKAN_RESOURCE_PKG) return Optional.of((IFeaturedObject.Builder<T>) VulkanResourcePkg.builder());
    else if (group == VulkanModelDefinition.Groups.RUN_PROCESS) return Optional.of((IFeaturedObject.Builder<T>) RunProcess.builder());
    else if (group == VulkanModelDefinition.Groups.WAIT_PROCESS_IDLE) return Optional.of((IFeaturedObject.Builder<T>) WaitProcessIdle.builder());
    else if (group == VulkanModelDefinition.Groups.DESCRIPTOR_PKG) return Optional.of((IFeaturedObject.Builder<T>) DescriptorPkg.builder());
    else if (group == VulkanModelDefinition.Groups.MOUSE_LOCATION) return Optional.of((IFeaturedObject.Builder<T>) MouseLocation.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
