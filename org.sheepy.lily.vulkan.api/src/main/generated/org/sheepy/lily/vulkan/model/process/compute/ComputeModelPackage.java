package org.sheepy.lily.vulkan.model.process.compute;

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

public final class ComputeModelPackage implements IModelPackage {
  public static final ComputeModelPackage Instance = new ComputeModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Compute").domain("org.sheepy.lily.vulkan.model.process").addImports(List.of("org.sheepy.lily.core.model.Application", "org.sheepy.lily.core.model.Maintainer", "org.sheepy.lily.vulkan.model.Process", "org.sheepy.lily.vulkan.model.VulkanResource")).genNamePackage(true).lmPackage(Instance).addGroups(ComputeModelDefinition.Groups.ALL).addEnums(ComputeModelDefinition.Enums.ALL).addUnits(ComputeModelDefinition.Units.ALL).addAliases(ComputeModelDefinition.Aliases.ALL).addJavaWrappers(ComputeModelDefinition.JavaWrappers.ALL).build();

  private ComputeModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == ComputeModelDefinition.Groups.COMPUTE_PROCESS) return Optional.of((IFeaturedObject.Builder<T>) ComputeProcess.builder());
    else if (group == ComputeModelDefinition.Groups.COMPUTE_PIPELINE) return Optional.of((IFeaturedObject.Builder<T>) ComputePipeline.builder());
    else if (group == ComputeModelDefinition.Groups.DISPATCH_TASK) return Optional.of((IFeaturedObject.Builder<T>) DispatchTask.builder());
    else if (group == ComputeModelDefinition.Groups.COMPUTE_CONFIGURATION) return Optional.of((IFeaturedObject.Builder<T>) ComputeConfiguration.builder());
    else if (group == ComputeModelDefinition.Groups.COMPUTE_EXECUTION_MANAGER) return Optional.of((IFeaturedObject.Builder<T>) ComputeExecutionManager.builder());
    else if (group == ComputeModelDefinition.Groups.COMPUTE_EXECUTION_RECORDER) return Optional.of((IFeaturedObject.Builder<T>) ComputeExecutionRecorder.builder());
    else if (group == ComputeModelDefinition.Groups.COMPUTE_COMMAND_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) ComputeCommandBuffer.builder());
    else if (group == ComputeModelDefinition.Groups.COMPUTE_ACQUIRER) return Optional.of((IFeaturedObject.Builder<T>) ComputeAcquirer.builder());
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
