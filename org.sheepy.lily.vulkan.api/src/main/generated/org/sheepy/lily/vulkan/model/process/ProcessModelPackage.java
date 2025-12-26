package org.sheepy.lily.vulkan.model.process;

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

public final class ProcessModelPackage implements IModelPackage {
  public static final ProcessModelPackage Instance = new ProcessModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Process").domain("org.sheepy.lily.vulkan.model").addImports(List.of("org.sheepy.lily.core.model.Maintainer", "org.sheepy.lily.core.model.Types", "org.sheepy.lily.vulkan.model.Vulkan", "org.sheepy.lily.vulkan.model.VulkanResource", "org.sheepy.vulkan.model.Barrier", "org.sheepy.vulkan.model.Enumeration", "org.sheepy.vulkan.model.Pipeline")).genNamePackage(true).lmPackage(Instance).addGroups(ProcessModelDefinition.Groups.ALL).addEnums(ProcessModelDefinition.Enums.ALL).addUnits(ProcessModelDefinition.Units.ALL).addAliases(ProcessModelDefinition.Aliases.ALL).addJavaWrappers(ProcessModelDefinition.JavaWrappers.ALL).build();

  private ProcessModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == ProcessModelDefinition.Groups.PROCESS_EXTENSION_PKG) return Optional.of((IFeaturedObject.Builder<T>) ProcessExtensionPkg.builder());
    else if (group == ProcessModelDefinition.Groups.PIPELINE_EXTENSION_PKG) return Optional.of((IFeaturedObject.Builder<T>) PipelineExtensionPkg.builder());
    else if (group == ProcessModelDefinition.Groups.SUBMISSION) return Optional.of((IFeaturedObject.Builder<T>) Submission.builder());
    else if (group == ProcessModelDefinition.Groups.PIPELINE_PKG) return Optional.of((IFeaturedObject.Builder<T>) PipelinePkg.builder());
    else if (group == ProcessModelDefinition.Groups.TASK_PKG) return Optional.of((IFeaturedObject.Builder<T>) TaskPkg.builder());
    else if (group == ProcessModelDefinition.Groups.PIPELINE) return Optional.of((IFeaturedObject.Builder<T>) Pipeline.builder());
    else if (group == ProcessModelDefinition.Groups.COMPOSITE_PIPELINE) return Optional.of((IFeaturedObject.Builder<T>) CompositePipeline.builder());
    else if (group == ProcessModelDefinition.Groups.COMPOSITE_TASK) return Optional.of((IFeaturedObject.Builder<T>) CompositeTask.builder());
    else if (group == ProcessModelDefinition.Groups.PIPELINE_BARRIER) return Optional.of((IFeaturedObject.Builder<T>) PipelineBarrier.builder());
    else if (group == ProcessModelDefinition.Groups.BIND_DESCRIPTOR_SETS) return Optional.of((IFeaturedObject.Builder<T>) BindDescriptorSets.builder());
    else if (group == ProcessModelDefinition.Groups.PUSH_CONSTANT_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) PushConstantBuffer.builder());
    else if (group == ProcessModelDefinition.Groups.FLUSH_TRANSFER_BUFFER_TASK) return Optional.of((IFeaturedObject.Builder<T>) FlushTransferBufferTask.builder());
    else if (group == ProcessModelDefinition.Groups.COPY_BUFFER_TASK) return Optional.of((IFeaturedObject.Builder<T>) CopyBufferTask.builder());
    else if (group == ProcessModelDefinition.Groups.FETCH_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) FetchBuffer.builder());
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
